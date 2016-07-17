package com.goforit.firstapple.forum.model;

import com.goforit.firstapple.user.model.User;

import java.util.Date;

/**
 * Created by junqingfjq on 16/6/28.
 */
public class Topic {

    private long id;

    private long boardId;

    private String title;

    //TODO 替换掉user模型,user模型展示的太多了
    private User createUser;

    private long viewNum;

    private long postNum;

    private Date latestPostTime;

    private Date createdTime;

    private Date modifiedTime;

    public void addPost(Date latestPostTime){
        this.postNum++;
        this.latestPostTime=latestPostTime;
    }

    public void deletePost(){
        //TODO latestPostTime 需要更新
        this.postNum--;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public long getViewNum() {
        return viewNum;
    }

    public void setViewNum(long viewNum) {
        this.viewNum = viewNum;
    }

    public long getPostNum() {
        return postNum;
    }

    public void setPostNum(long postNum) {
        this.postNum = postNum;
    }

    public Date getLatestPostTime() {
        return latestPostTime;
    }

    public void setLatestPostTime(Date latestPostTime) {
        this.latestPostTime = latestPostTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
