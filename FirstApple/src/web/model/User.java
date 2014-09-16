package web.model;

/**
 * 
 * @author junqing.fjq
 * @version $Id: User.java, v 0.1 2014年8月20日 下午2:10:38 junqing.fjq Exp $
 */
public class User {
	
	/**  */
	private String userId;

	/**  */
	private String name;
	
	/**  */
	private String sex;
	
	/**  */
	private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

	
    /**
     * Getter method for property <tt>password</tt>.
     * 
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property <tt>password</tt>.
     * 
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }
	
    public String toString() {
        return "name:"+name;//TODO:
    }

}
