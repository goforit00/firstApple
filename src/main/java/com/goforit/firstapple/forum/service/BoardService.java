package com.goforit.firstapple.forum.service;

import com.goforit.firstapple.forum.model.Board;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/28.
 */
public interface BoardService {

    Board create(Board board);

    List<Board> getAll();

}
