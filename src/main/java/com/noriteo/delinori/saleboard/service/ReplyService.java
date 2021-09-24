package com.noriteo.delinori.saleboard.service;

import com.noriteo.delinori.saleboard.domain.Reply;
import com.noriteo.delinori.saleboard.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {

    int add(ReplyDTO replyDTO);

    List<ReplyDTO> getRepliesWithSno(Long sno);

    int Remove(Long rno);

    int modify(ReplyDTO replyDTO);

    default Reply dtoToEntity(ReplyDTO dto) {
        Reply reply = Reply.builder()
                .rno(dto.getRno())
                .sno(dto.getSno())
                .reply(dto.getReply())
                .replyer(dto.getReplyer())
                .replyDate(dto.getReplyDate())
                .modDate(dto.getModDate())
                .build();
        return reply;
    }

    default ReplyDTO entityToDTO(Reply reply) {

        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getRno())
                .sno(reply.getSno())
                .reply(reply.getReply())
                .replyer(reply.getReplyer())
                .replyDate(reply.getReplyDate())
                .modDate(reply.getModDate())
                .build();

        return replyDTO;
    }
}
