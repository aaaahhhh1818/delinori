package com.noriteo.delinori.saleboard.dto;

import com.noriteo.delinori.saleboard.domain.SaleBoard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleBoardDTO {

    private Long sno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public SaleBoard getDomain() {

        SaleBoard saleBoard = SaleBoard.builder()
                .sno(sno)
                .title(title)
                .content(content)
                .writer(writer)
                .regDate(regDate)
                .modDate(modDate)
                .build();

        return  saleBoard;
    }

}
