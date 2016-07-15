package com.goforit.firstapple.forum.mapper;

import com.goforit.firstapple.forum.model.Board;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */
public interface BoardMapper {

    //~~~~ operator method ~~~~
    void create(Board board);

    //~~~~ query method ~~~~
    Board get(long id);

    List<Board> getAll();

    //TODO 增加分页查询

}
