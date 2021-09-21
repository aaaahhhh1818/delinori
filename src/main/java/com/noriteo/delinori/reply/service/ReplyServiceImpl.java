package com.noriteo.delinori.reply.service;

import com.noriteo.delinori.reply.dto.ReplyDTO;
import com.noriteo.delinori.reply.mapper.ReplyMapper;
import com.noriteo.delinori.saleboard.mapper.SaleBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;
    private final SaleBoardMapper saleBoardMapper;

    @Override
    public int add(ReplyDTO replyDTO) {

        int count = replyMapper.insert(dtoToEntity(replyDTO));
        saleBoardMapper.updateReplyCnt(replyDTO.getSno(), 1);

        return count;
    }

    @Override
    public List<ReplyDTO> getRepliesWithSno(Long sno) {
        return replyMapper.getListWithBoard(sno).stream().map(reply -> entityToDTO(reply)).collect(Collectors.toList());
    }

    @Override
    public int Remove(Long rno) {
        return replyMapper.delete(rno);
    }

    @Override
    public int modify(ReplyDTO replyDTO) {
        return replyMapper.update(dtoToEntity(replyDTO));
    }
}
