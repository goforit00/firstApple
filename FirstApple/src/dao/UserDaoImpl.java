package dao;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import common.StringUtil;
import web.model.User;

/**
 * 
 * @author junqing.fjq
 * @version $Id: UserDaoImpl.java, v 0.1 2014年8月20日 下午2:43:43 junqing.fjq Exp $
 */
public class UserDaoImpl implements UserDao {

    private SqlMapClientTemplate sqlMapClientTemplate;

    /** 
     * @see dao.UserDao#addUser(web.model.User)
     */
    @Override
    public boolean addUser(User user) {
        if (user == null || StringUtil.isBlank(user.getUserId()))
            return false;

        sqlMapClientTemplate.insert("addUser", user);
        return true;
    }

    /** 
     * @see dao.UserDao#queryUserByUserId(java.lang.String)
     */
    @Override
    public User queryUserByUserId(String id) {
        if (StringUtil.isBlank(id))
            return null;
        return (User) sqlMapClientTemplate.queryForObject("getUserById", id);
    }

    /** 
     * @see dao.UserDao#queryUserByUserName(java.lang.String)
     */
    @Override
    public User queryUserByUserName(String name) {
        if (StringUtil.isBlank(name)) {
            return null;
        }

        return (User) sqlMapClientTemplate.queryForObject("getUserByName", name);
    }

    @Override
    public boolean updateUser(User user) {
        if (user == null || StringUtil.isBlank(user.getUserId()))
            return false;
        return sqlMapClientTemplate.update("updateUser", user) >= 1 ? true : false;

    }

    @Override
    public boolean deleteUserById(String userId) {
        if (StringUtil.isBlank(userId))
            return false;
        return sqlMapClientTemplate.delete("deleteUser") >= 1 ? true : false;
        //TODO  需要验证
    }

    /**
     * 
     * @return
     */
    public SqlMapClientTemplate getSqlMapClientTemplate() {
        return sqlMapClientTemplate;
    }

    /**
     * 
     * @param sqlMapClientTemplate
     */
    public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
        this.sqlMapClientTemplate = sqlMapClientTemplate;
    }

}
