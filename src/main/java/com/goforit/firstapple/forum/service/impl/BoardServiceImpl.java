package com.goforit.firstapple.forum.service.impl;

import com.goforit.firstapple.forum.manager.BoardManager;
import com.goforit.firstapple.forum.model.Board;
import com.goforit.firstapple.forum.service.BoardService;
import com.goforit.firstapple.forum.service.impl.validators.BoardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by junqingfjq on 16/6/28.
 */

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardManager boardManager;

    @Override
    public Board create(Board board) {

        BoardValidator.validateBoardCreate(board);

        return boardManager.create(board);
    }

    @Override
    public List<Board> getAll() {

        return boardManager.getAll();

    }
}
