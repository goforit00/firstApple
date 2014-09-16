package dao;

import web.model.User;

/**
 * 
 * @author junqing.fjq
 * @version $Id: UserDao.java, v 0.1 2014年9月3日 上午10:07:16 junqing.fjq Exp $
 */
public interface UserDao {
    
    /**
     * 
     * @param user
     * @return
     */
    public boolean  addUser(User user);
    
    /**
     * 
     * @param id
     * @return
     */
    public User queryUserByUserId(String id);
    
    /**
     * 
     * @param name
     * @return
     */
    public User queryUserByUserName(String name); 
    
    /**
     * 
     * @param user
     * @return
     */
    public boolean updateUser(User user) ;
    
    /**
     * 
     * @param userId
     * @return
     */
    public boolean deleteUserById(String userId) ;
        
}
