package com.goforit.firstapple.forum.mapper;

import com.goforit.firstapple.forum.model.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by goforit on 16/7/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:core-service.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DirtiesContext
//    @Transactional
    public void baseTest(){

        Board board=new Board();
        board.setName("test");
        board.setUserId("111");
        boardMapper.create(board);
    }
}
