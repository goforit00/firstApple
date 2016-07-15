package com.goforit.firstapple.forum.service.impl;

import com.goforit.firstapple.forum.manager.TopicManager;
import com.goforit.firstapple.forum.model.Post;
import com.goforit.firstapple.forum.model.Topic;
import com.goforit.firstapple.forum.model.enums.PostLikeType;
import com.goforit.firstapple.forum.service.TopicService;
import com.goforit.firstapple.forum.service.impl.validators.TopicValidator;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */

//TODO 操作需要加入权限验证
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicManager topicManager;

    @Override
    public Topic createTopic(Topic topic, Post firstPost) {

        TopicValidator.validateCreateTopic(topic, firstPost);

        return topicManager.create(topic,firstPost);
    }

    @Override
    public Boolean deleteTopic(Long id) {

        Preconditions.checkArgument(id>0,"topic id not right!");

        return topicManager.deleteTopic(id);
    }

    @Override
    public Post addPost(Post post) {

        TopicValidator.validateAddPost(post);

        return topicManager.addPostInTopic(post);
    }

    @Override
    public Boolean deletePost(Long postId) {

        Preconditions.checkArgument(postId>0,"postId id not right!");

        return topicManager.deletePost(postId);

    }

    @Override
    public Post updatePostLikeNum(Long topicId, Long postId, PostLikeType type) {

        TopicValidator.validateUpdatePostLikeNum(topicId,postId,type);

        return topicManager.updatePostLikeNum(topicId,postId,type);
    }

    @Override
    public List<Topic> getAllTopicsByBoardId(Long boardId) {

        Preconditions.checkArgument(boardId>0,"board id not right!");

        return topicManager.findAllTopicInBoard(boardId);
    }

    @Override
    public Topic get(Long id) {

        Preconditions.checkArgument(id>0,"topic id not right!");

        return topicManager.findById(id);
    }

}
