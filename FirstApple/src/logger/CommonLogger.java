package logger;

/**
 * ��־��¼ �ӿ�
 * @author junqing.fjq
 * @version $Id: Logger.java, v 0.1 2014��9��12�� ����4:15:38 junqing.fjq Exp $
 */
public interface CommonLogger {
    
    /**
     * info����
     * @param message
     */
    public void info(Object message) ;
    
    /**
     * error����
     * @param message
     * @param error
     */
    public void error(Object message ,Throwable error);
    
    
    /**
     * debug����
     * @param message
     */
    public void debug(Object message);

}
