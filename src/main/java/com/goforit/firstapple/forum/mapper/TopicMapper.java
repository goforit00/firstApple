package com.goforit.firstapple.forum.mapper;

import com.goforit.firstapple.forum.model.Post;
import com.goforit.firstapple.forum.model.Topic;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */
public interface TopicMapper {

    //~~~~ operator method ~~~~
    void create(Topic topic);

    void delete(long id);

    Topic updateTopic(Topic topic);


    //~~~~ query method ~~~~

    Topic selectForUpdate(long topicId,String title);

    List<Topic> findByBoardId(long boardId);

    Topic get(long topicId);
}
