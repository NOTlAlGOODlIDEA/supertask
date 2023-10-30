package notagoodidea.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import notagoodidea.model.User;

@Aspect
@Component
public class LogInfoFromPostMethodAspect {

    private static final String LOGGER_NAME = "PostMethodLogger";
    private static final String LOGGER_MESSAGE =
            "Post method controller got the User(%s) with username(%s) and password(%s)";
    private Logger logger;

    public LogInfoFromPostMethodAspect() {
        logger = Logger.getLogger(LOGGER_NAME);
        logger.setLevel(Level.INFO);
    }

    @Before("@annotation(notagoodidea.utils.annotations.LogInfoFromPostMethod)")
    public void logInfoFromPostMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof User) {
                User user = (User) arg;

                logger.info(LOGGER_MESSAGE.formatted(user, user.getName(), user.getPassword()));
            }
        }
    }
}
