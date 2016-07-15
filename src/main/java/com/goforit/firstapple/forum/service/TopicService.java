package com.goforit.firstapple.forum.service;

import com.goforit.firstapple.forum.model.Post;
import com.goforit.firstapple.forum.model.Topic;
import com.goforit.firstapple.forum.model.enums.PostLikeType;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */
public interface TopicService {

    //~~~~ operate method ~~~~

    Topic createTopic(Topic topic,Post firstPost);

    Boolean deleteTopic(Long id);

    Post addPost(Post post);

    Boolean deletePost(Long id);

    Post updatePostLikeNum(Long topicId, Long postId, PostLikeType type);

    //~~~~ query method ~~~~

    List<Topic> getAllTopicsByBoardId(Long boardId);

    Topic get(Long id);


}
