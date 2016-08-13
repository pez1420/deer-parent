package com.longlydeer.deer.common.logger;

import org.slf4j.Logger;

import java.text.MessageFormat;

/**
 * 日志辅助功能类
 *
 * @author pez1420@163.com
 * @version 2016/8/10 0:07
 */
public class LoggerUtils {

    /**
     * trace级别日志信息
     *
     * @param logger 日志记录对象
     * @param message  日志信息
     * @param arguments 参数
     */
    public static void trace(Logger logger, String message, String... arguments) {
        if (logger.isTraceEnabled())
            logger.trace(MessageFormat.format(message, arguments));
    }

    /**
     * debug级别日志信息
     *
     * @param logger
     * @param message
     * @param arguments
     */
    public static void debug(Logger logger, String message, String... arguments) {
        if (logger.isDebugEnabled())
            logger.debug(MessageFormat.format(message, arguments));
    }

    /**
     * info级别日志信息
     *
     * @param logger
     * @param message
     * @param arguments
     */
    public static void info(Logger logger, String message, String... arguments) {
        if (logger.isInfoEnabled())
            logger.info(MessageFormat.format(message, arguments));
    }

    /**
     * warn级别日志信息
     *
     * @param logger
     * @param message
     * @param arguments
     */
    public static void warn(Logger logger, String message, String... arguments) {
        if (logger.isWarnEnabled())
            logger.warn(MessageFormat.format(message, arguments));
    }

    /**
     * Error级别日志信息
     *
     * @param logger
     * @param message
     * @param arguments
     */
    public static void error(Logger logger, String message, String... arguments) {
        if (logger.isErrorEnabled())
            logger.error(MessageFormat.format(message, arguments));
    }
}
