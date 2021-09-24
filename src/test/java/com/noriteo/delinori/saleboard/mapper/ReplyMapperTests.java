package com.noriteo.delinori.saleboard.mapper;

import com.noriteo.delinori.common.config.RootConfig;
import com.noriteo.delinori.saleboard.domain.Reply;
import com.noriteo.delinori.saleboard.config.SaleBoardRootConfig;
import com.noriteo.delinori.saleboard.mapper.ReplyMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {RootConfig.class, SaleBoardRootConfig.class})
public class ReplyMapperTests {

    @Autowired(required = false)
    ReplyMapper replyMapper;

    @Test
    public void insertDummies() {

        long[] arr = {100L, 99L, 98L, 97L, 96L};

        IntStream.rangeClosed(1, 100).forEach(num -> {

            long sno = arr[((int) (Math.random() * 1000)) % 5];

            Reply reply = Reply.builder()
                    .sno(sno)
                    .reply("댓글...." + num)
                    .replyer("user" + (num % 10))
                    .build();

            replyMapper.insert(reply);

        });
    }

    @Test
    public void testList() {
        Long sno = 100L;

        replyMapper.getListWithBoard(sno).forEach(reply -> log.info(reply));
    }

}
