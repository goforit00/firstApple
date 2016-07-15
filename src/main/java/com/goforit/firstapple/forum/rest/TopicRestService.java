package com.goforit.firstapple.forum.rest;

import com.goforit.firstapple.forum.model.Post;
import com.goforit.firstapple.forum.model.Topic;
import com.goforit.firstapple.forum.model.enums.PostLikeType;
import com.goforit.firstapple.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by junqingfjq on 16/6/28.
 */

@Controller
@Path("/forum/topic")
public class TopicRestService {

    @Autowired
    private TopicService topicService;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Topic findById(@PathVariable String id){
        return topicService.get(Long.valueOf(id));
    }

    //TODO 填充user
    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Topic create(Topic topic,Post firstPost){
        Topic createdTopic=topicService.createTopic(topic,firstPost);

        return createdTopic;
    }

    //TODO 填充user
    @Path("/{topicId}/addPost")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Post addPost(@PathVariable String topicId, Post post){
        post.setTopicId(Long.valueOf(topicId));
        return topicService.addPost(post);
    }

    @Path("/{topicId}/post/{postId}/{likeType}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Post addLike(@PathVariable String topicId,@PathVariable String postId,@PathVariable String likeType){
        return topicService.updatePostLikeNum(Long.valueOf(topicId),Long.valueOf(postId), PostLikeType.valueOf(likeType));
    }

    @Path("/{topicId}/post/{postId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Topic deletePost(@PathVariable String topicId,@PathVariable String postId ){
        if(!topicService.deleteTopic(Long.valueOf(postId))){
            return null;
        }
        return topicService.get(Long.valueOf(topicId));
    }

    @Path("/{topicId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean deleteTopic(@PathVariable String topicId){
        return topicService.deleteTopic(Long.valueOf(topicId));
    }

    @Path("/test/{testId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Topic test(){
        Topic topic=new Topic();
        topic.setId(10);
        topic.setBoardId(20);
        return topic;
    }
}
