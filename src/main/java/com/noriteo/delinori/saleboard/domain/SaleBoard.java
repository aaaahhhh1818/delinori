package com.noriteo.delinori.saleboard.domain;

import com.noriteo.delinori.saleboard.dto.SaleBoardDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleBoard {

    private Long sno;
    private String title, content, writer;
    private LocalDateTime regDate, modDate;

    public SaleBoardDTO getDTO() {
        SaleBoardDTO saleBoardDTO = SaleBoardDTO.builder()
                .sno(sno)
                .title(title)
                .content(content)
                .writer(writer)
                .regDate(regDate)
                .modDate(modDate)
                .build();

        return saleBoardDTO;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }
}
