package com.goforit.firstapple.forum.service;

import com.goforit.firstapple.forum.model.Post;
import com.goforit.firstapple.forum.model.Topic;
import com.goforit.firstapple.forum.model.enums.PostLikeType;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */
public interface TopicService {

    List<Topic> getAllTopicsByBoardId(long boardId);

    Topic createTopic(Topic topic,Post firstPost);

    Topic get(long id);

    boolean deleteTopic(long id);

    Post addPost(Post post);

    boolean deletePost(long id);

    Post updatePostLikeNum(long topicId, long postId, PostLikeType type);


}
