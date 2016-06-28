package com.goforit.firstapple.forum.service;

import com.goforit.firstapple.forum.model.Topic;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */
public interface TopicService {

    List<Topic> getAllTopicsByBoardId(long boardId);

    Topic createTopic(Topic topic);

    Topic get(long id);
}
