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
        if(null==topic){
            throw new RuntimeException("not find topic find by id="+post.getTopicId());
        }

        postMapper.create(post);

        topic.addPost(post.getCreatedTime());

        topicMapper.updateTopic(topic);

        return post;
    }

    @Override
    @Transactional
    public Boolean deletePost(Long postId) {

        Post post=postMapper.selectForUpdate(postId);

        if(null==post){
            throw new RuntimeException("not find post by post id="+postId);
        }

        Topic topic=topicMapper.selectForUpdate(post.getTopicId(),null);

        if(null==topic){
            throw new RuntimeException("not find topic by topic id="+post.getTopicId());
        }

        topic.deletePost();

        topicMapper.updateTopic(topic);

        postMapper.delete(postId);

        return true;
    }

    @Override
    @Transactional
    //TODO remove topicId
    public Post updatePostLikeNum(Long topicId, Long postId, PostLikeType type) {

        Post post=postMapper.selectForUpdate(postId);

        if(null==post){
            throw new RuntimeException("not find post by id="+postId);
        }

        post.changeLikeOrDislike(type);

        postMapper.update(post);

        return postMapper.findById(postId);
    }

    @Override
    public List<Topic> findAllTopicInBoard(Long boardId) {
        return topicMapper.findByBoardId(boardId);
    }

    @Override
    public Topic findById(Long topicId) {
        return topicMapper.get(topicId);
    }
}
