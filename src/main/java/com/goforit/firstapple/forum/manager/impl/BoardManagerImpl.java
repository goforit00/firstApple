package com.goforit.firstapple.forum.manager.impl;

import com.goforit.firstapple.forum.manager.BoardManager;
import com.goforit.firstapple.forum.mapper.BoardMapper;
import com.goforit.firstapple.forum.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by goforit on 16/6/29.
 */

@Service
public class BoardManagerImpl implements BoardManager{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    @Transactional
    public Board create(Board board) {

        boardMapper.create(board);

        return boardMapper.get(board.getId());
    }

    @Override
    public List<Board> getAll() {

        return boardMapper.getAll();
    }
}
