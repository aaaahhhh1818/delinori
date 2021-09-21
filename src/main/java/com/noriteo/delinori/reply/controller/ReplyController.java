package com.noriteo.delinori.reply.controller;

import com.noriteo.delinori.reply.dto.ReplyDTO;
import com.noriteo.delinori.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController //@ResponseBody
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("")
    public String[] doA() {

        return  new String[]{"AAA", "BBB", "CCC"};

    }

    @PostMapping("")
    public int add(@RequestBody ReplyDTO replyDTO) {

        log.info("==============================");
        log.info(replyDTO);

        return replyService.add(replyDTO);

    }

    @DeleteMapping("/{rno}")
    public String remove(@PathVariable(name = "rno") Long rno) {
        log.info("-----------reply remove-----------");

        log.info("rno : " + rno);

        replyService.Remove(rno);

        return "success";
    }

    @PutMapping("/{rno}")
    public String modify(@PathVariable(name = "rno") Long rno, @RequestBody ReplyDTO replyDTO) {

        log.info("----------reply modify------------");
        log.info(replyDTO);

        replyService.modify(replyDTO);

        return "success";

    }

    @GetMapping("/list/{sno}")
    public List<ReplyDTO> getBoardReplies(@PathVariable(name = "sno") Long sno) {

        return replyService.getRepliesWithSno(sno);

    }

}