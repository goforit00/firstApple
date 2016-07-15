package com.goforit.firstapple.forum.manager.impl;

import com.goforit.firstapple.forum.manager.TopicManager;
import com.goforit.firstapple.forum.mapper.PostMapper;
import com.goforit.firstapple.forum.mapper.TopicMapper;
import com.goforit.firstapple.forum.model.Post;
import com.goforit.firstapple.forum.model.Topic;
import com.goforit.firstapple.forum.model.enums.PostLikeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by goforit on 16/6/29.
 */

@Service
public class TopicManagerImpl implements TopicManager{

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private PostMapper postMapper;

    @Override
    @Transactional
    public Topic create(Topic topic, Post firstPost) {
        topicMapper.create(topic);
        firstPost.setTopicId(topic.getId());

        postMapper.create(firstPost);
        return topic;
    }

    @Override
    public Boolean deleteTopic(Long topicId) {

        topicMapper.delete(topicId);

        return true;
    }

    @Override
    @Transactional
    public Post addPostInTopic(Post post) {

        Topic topic=topicMapper.selectForUpdate(post.getTopicId(),null);

        postMapper.create(post);

        topic.addPost(post.getCreatedTime());

        topicMapper.updateTopic(topic);

        return post;
    }

    @Override
    @Transactional
    public Boolean deletePost(Long postId) {

        Post post=postMapper.selectForUpdate(postId);

        Topic topic=topicMapper.selectForUpdate(post.getTopicId(),null);

        topic.deletePost();

        topicMapper.updateTopic(topic);

        postMapper.delete(postId);

        return true;
    }

    @Override
    public Post updatePostLikeNum(Long topicId, Long postId, PostLikeType type) {
        return null;
    }

    @Override
    public List<Topic> findAllTopicInBoard(Long boardId) {
        return null;
    }

    @Override
    public Topic findById(Long topicId) {
        return null;
    }
}
