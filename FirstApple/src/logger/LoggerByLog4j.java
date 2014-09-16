package logger;

import org.apache.log4j.Logger;

/**
 * 通过log4j来实现logger
 * @author junqing.fjq
 * @version $Id: LoggerByLog4j.java, v 0.1 2014年9月12日 下午4:33:54 junqing.fjq Exp $
 */
public class LoggerByLog4j implements CommonLogger{
    /** log4j logger  */
    private Logger    logger;
    public LoggerByLog4j(Class<?> clazz) {
        logger=Logger.getLogger(clazz);
    }
    @Override
    public void info(Object message) {
        logger.info(message);
    }

    @Override
    public void error(Object message, Throwable error) {
        logger.error(message,error);
    }

    @Override
    public void debug(Object message) {
        logger.debug(message);
    }

    /**
     * Getter method for property <tt>logger</tt>.
     * 
     * @return property value of logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Setter method for property <tt>logger</tt>.
     * 
     * @param logger value to be assigned to property logger
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

}
