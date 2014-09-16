package logger;

/**
 * 日志记录 接口
 * @author junqing.fjq
 * @version $Id: Logger.java, v 0.1 2014年9月12日 下午4:15:38 junqing.fjq Exp $
 */
public interface CommonLogger {
    
    /**
     * info级别
     * @param message
     */
    public void info(Object message) ;
    
    /**
     * error级别
     * @param message
     * @param error
     */
    public void error(Object message ,Throwable error);
    
    
    /**
     * debug级别
     * @param message
     */
    public void debug(Object message);

}
