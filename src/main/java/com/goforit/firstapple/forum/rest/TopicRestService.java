package com.goforit.firstapple.forum.rest;

import com.goforit.firstapple.forum.model.Post;
import com.goforit.firstapple.forum.model.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by junqingfjq on 16/6/28.
 */

@Controller
@RequestMapping(value = "/forum/topic")
public class TopicRestService {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Topic findById(@PathVariable String id){
        return null;
    }

    @RequestMapping(method=RequestMethod.POST)
    public Topic create(Topic topic,Post firstPost){
        return null;
    }

    @RequestMapping(value = "/{topicId}/addPost",method = RequestMethod.PUT)
    public Topic addPost(@PathVariable String topicId,Post post){
        return null;
    }

    @RequestMapping(value="/{topicId}/post/{postId}/{likeType}/",method = RequestMethod.PUT)
    public Post addLike(@PathVariable String topicId,@PathVariable String postId,@PathVariable String likeType){
        return null;
    }

    @RequestMapping(value = "/{topicId}/post/{postId}",method = RequestMethod.DELETE)
    public Topic deletePost(@PathVariable String topicId,@PathVariable String postId ){
        return null;
    }

    @RequestMapping(value = "/{topicId}",method = RequestMethod.DELETE)
    public boolean deleteTopic(@PathVariable String topicId){
        return true;
    }
}
