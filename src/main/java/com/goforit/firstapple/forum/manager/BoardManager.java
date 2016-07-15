package com.goforit.firstapple.forum.manager;

import com.goforit.firstapple.forum.model.Board;

import java.util.List;

/**
 * Created by goforit on 16/6/29.
 */
public interface BoardManager {

    //~~~~ operator method ~~~~
    Board create(Board board);


    //~~~~ query method ~~~~
    List<Board> getAll();
}
