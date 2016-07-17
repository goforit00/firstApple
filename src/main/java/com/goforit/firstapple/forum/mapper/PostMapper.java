package com.goforit.firstapple.forum.mapper;

import com.goforit.firstapple.forum.model.Post;
import javafx.geometry.Pos;

/**
 * Created by junqingfjq on 16/6/28.
 */
public interface PostMapper {

    //~~~~ operator method ~~~~
    void create(Post post);

    void delete(long postId);

    int update(Post post);


    //~~~~ query method ~~~~
    Post selectForUpdate(long postId);

    Post findById(long id);



}
