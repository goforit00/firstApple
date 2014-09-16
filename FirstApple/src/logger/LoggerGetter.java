package logger;

/**
 * Logger 获得器
 * @author junqing.fjq
 * @version $Id: LoggerGetter.java, v 0.1 2014年9月12日 下午4:11:06 junqing.fjq Exp $
 */
public class LoggerGetter {
    /**  */
    private static CommonLogger logger;
    /**
     * 
     * @param clazz
     * @return
     */
    public static CommonLogger getLogger(Class<?> clazz)
    {
        logger = new LoggerByLog4j(clazz);
        return logger;
    }
}
