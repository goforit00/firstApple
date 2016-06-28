package com.goforit.firstapple.forum.mapper;

import com.goforit.firstapple.forum.model.Board;

/**
 * Created by junqingfjq on 16/6/28.
 */
public interface BoardMapper {

    void create(Board board);

    Board get(long id);

}
