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

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */

@Controller
@Path("/forum/board/")
public class BoardRestService {

    @Autowired
    private BoardService boardService;

    @Autowired
    private TopicService topicService;

    //TODO 填充user
    @Path("/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Board createBoard(Board board){
        Preconditions.checkNotNull(board);

        return boardService.create(board);
    }

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Board> getAllBoard(){
        return boardService.getAll();
    }

    @Path("/{boardId}/topic")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Topic> getAllTopicByBoard(@PathVariable String boardId){

        Preconditions.checkArgument(StringUtils.isNotBlank(boardId),"board id can't be null");

        return topicService.getAllTopicsByBoardId(Long.valueOf(boardId));
    }

}
