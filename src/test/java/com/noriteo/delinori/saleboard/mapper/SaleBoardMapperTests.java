package com.noriteo.delinori.saleboard.mapper;

import com.noriteo.delinori.common.config.RootConfig;
import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.common.dto.PageResponseDTO;
import com.noriteo.delinori.saleboard.config.SaleBoardRootConfig;
import com.noriteo.delinori.saleboard.domain.SaleBoard;
import com.noriteo.delinori.saleboard.dto.SaleBoardDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {SaleBoardRootConfig.class, RootConfig.class})
public class SaleBoardMapperTests {

    @Autowired
    SaleBoardMapper saleBoardMapper;

    @Test
    public void testDummies() {

        IntStream.rangeClosed(1,100).forEach(i -> {
            SaleBoard saleBoard = SaleBoard.builder()
                    .title("title" + i)
                    .content("content" + i)
                    .writer("user" + (i % 10))
                    .build();

            saleBoardMapper.insert(saleBoard);
        });

    }

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(2)
                .build();

        log.info(pageRequestDTO);

        List<SaleBoardDTO> saleBoardDTOList = saleBoardMapper.getList(pageRequestDTO).stream().map(saleBoard -> saleBoard.getDTO()).collect(Collectors.toList());

        int count = saleBoardMapper.getCount(pageRequestDTO);


    }

    @Test
    public void testSelect() {

        SaleBoard saleBoard = saleBoardMapper.select(11L);

        log.info(saleBoard);

        log.info("-------------------");

    }

}
