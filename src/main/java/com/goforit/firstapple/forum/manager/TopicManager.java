package com.goforit.firstapple.forum.manager;

import com.goforit.firstapple.forum.model.Board;
import com.goforit.firstapple.forum.model.Post;
import com.goforit.firstapple.forum.model.Topic;
import com.goforit.firstapple.forum.model.enums.PostLikeType;

import java.util.List;

/**
 * Created by goforit on 16/6/29.
 */
public interface TopicManager {

    //~~~~ operator method ~~~~
    Topic create(Topic topic,Post firstPost);

    Boolean deleteTopic(Long topicId);

    Post addPostInTopic(Post post);

    Boolean deletePost(Long postId);

    Post updatePostLikeNum(Long topicId, Long postId, PostLikeType type);

    //~~~~ query method ~~~~
    List<Topic> findAllTopicInBoard(Long boardId);

    Topic findById(Long topicId);

}
