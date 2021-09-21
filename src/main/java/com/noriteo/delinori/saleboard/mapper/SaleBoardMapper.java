package com.noriteo.delinori.saleboard.mapper;

import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.saleboard.domain.SaleBoard;

import java.util.List;

public interface SaleBoardMapper {

    void insert(SaleBoard saleBoard);

    List<SaleBoard> getList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);

    SaleBoard select(Long sno);

    int delete(Long sno);
}
