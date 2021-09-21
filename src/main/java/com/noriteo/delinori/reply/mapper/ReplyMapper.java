package com.noriteo.delinori.reply.mapper;

import com.noriteo.delinori.reply.domain.Reply;

import java.util.List;

public interface ReplyMapper {

    int insert(Reply reply);

    List<Reply> getListWithBoard(Long sno);

    int delete(Long rno);

    int update(Reply reply);

}
