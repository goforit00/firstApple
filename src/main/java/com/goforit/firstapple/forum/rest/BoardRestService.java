package com.goforit.firstapple.forum.rest;

import com.goforit.firstapple.forum.model.Board;
import com.goforit.firstapple.forum.model.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */

@Controller
@RequestMapping(value = "/forum/board/")
public class BoardRestService {

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createBoard(Board board){
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Board> getAllBoard(){
        return null;
    }

    @RequestMapping(value = "{boardId}/topic",method = RequestMethod.GET)
    public List<Topic> getAllTopicByBoard(@PathVariable String boardId){
        return null;
    }

}
