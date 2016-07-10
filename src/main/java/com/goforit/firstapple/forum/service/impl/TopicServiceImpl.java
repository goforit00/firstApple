package com.goforit.firstapple.forum.service.impl;

import com.goforit.firstapple.forum.model.Post;
import com.goforit.firstapple.forum.model.Topic;
import com.goforit.firstapple.forum.model.enums.PostLikeType;
import com.goforit.firstapple.forum.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */

@Service
public class TopicServiceImpl implements TopicService {

    @Override
    public List<Topic> getAllTopicsByBoardId(long boardId) {
        return null;
    }

    @Override
    public Topic createTopic(Topic topic, Post firstPost) {
        return null;
    }


    @Override
    public Topic get(long id) {
        return null;
    }

    @Override
    public boolean deleteTopic(long id) {
        return false;
    }

    @Override
    public Post addPost(Post post) {
        return null;
    }

    @Override
    public boolean deletePost(long id) {
        return false;
    }

    @Override
    public Post updatePostLikeNum(long topicId, long postId, PostLikeType type) {
        return null;
    }


}
