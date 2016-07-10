package com.goforit.firstapple.forum.rest;

import com.goforit.firstapple.forum.model.Board;
import com.goforit.firstapple.forum.model.Topic;
import com.goforit.firstapple.forum.service.BoardService;
import com.goforit.firstapple.forum.service.TopicService;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */

@Controller
@RequestMapping(value = "/forum/board/")
public class BoardRestService {

    @Autowired
    private BoardService boardService;

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public @ResponseBody Board createBoard(Board board){
        Preconditions.checkNotNull(board);

        return boardService.create(board);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Board> getAllBoard(){
        return boardService.getAll();
    }

    @RequestMapping(value = "{boardId}/topic",method = RequestMethod.GET)
    public @ResponseBody List<Topic> getAllTopicByBoard(@PathVariable String boardId){

        Preconditions.checkArgument(StringUtils.isNotBlank(boardId),"boardId can't be null");

        return topicService.getAllTopicsByBoardId(Long.valueOf(boardId));
    }

}
