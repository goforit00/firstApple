package com.goforit.firstapple.forum.service;

import com.goforit.firstapple.forum.model.Board;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */
public interface BoardService {

    //~~~~ operate method ~~~~
    Board create(Board board);


    //~~~~ query method ~~~~
    List<Board> getAll();

}
