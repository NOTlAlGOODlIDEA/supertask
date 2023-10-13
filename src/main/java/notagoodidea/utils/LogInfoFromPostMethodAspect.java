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
    private Logger logger;

    public LogInfoFromPostMethodAspect() {
        logger = Logger.getLogger(LOGGER_NAME);
    }

    @Before("@annotation(LogInfoFromPostMethod)")
    public void logCall(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof User) {
                User user = (User) arg;
                logger.setLevel(Level.INFO);
                logger.info("######" + user.getName() + " " + user.getPassword() + "######");
            }
        }
    }
}
