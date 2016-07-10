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

/**
 * Created by junqingfjq on 16/6/28.
 */

@Controller
@RequestMapping(value = "/forum/topic")
public class TopicRestService {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody
    Topic findById(@PathVariable String id){
        return topicService.get(Long.valueOf(id));
    }

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Topic create(Topic topic,Post firstPost){
        Topic createdTopic=topicService.createTopic(topic,firstPost);

        return createdTopic;
    }

    @RequestMapping(value = "/{topicId}/addPost",method = RequestMethod.PUT)
    public @ResponseBody Post addPost(@PathVariable String topicId, Post post){
        post.setTopicId(Long.valueOf(topicId));
        return topicService.addPost(post);
    }

    @RequestMapping(value="/{topicId}/post/{postId}/{likeType}/",method = RequestMethod.PUT)
    public @ResponseBody Post addLike(@PathVariable String topicId,@PathVariable String postId,@PathVariable String likeType){
        return topicService.updatePostLikeNum(Long.valueOf(topicId),Long.valueOf(postId), PostLikeType.valueOf(likeType));
    }

    @RequestMapping(value = "/{topicId}/post/{postId}",method = RequestMethod.DELETE)
    public @ResponseBody Topic deletePost(@PathVariable String topicId,@PathVariable String postId ){
        if(!topicService.deleteTopic(Long.valueOf(postId))){
            return null;
        }
        return topicService.get(Long.valueOf(topicId));
    }

    @RequestMapping(value = "/{topicId}",method = RequestMethod.DELETE)
    public @ResponseBody Boolean deleteTopic(@PathVariable String topicId){
        return topicService.deleteTopic(Long.valueOf(topicId));
    }

    @RequestMapping(value = "/test/{testId}",method = RequestMethod.GET,headers = {"Accept=text/xml, application/json"})
    public @ResponseBody Topic test(){
        Topic topic=new Topic();
        topic.setId(10);
        topic.setBoardId(20);
        return topic;
    }
}
