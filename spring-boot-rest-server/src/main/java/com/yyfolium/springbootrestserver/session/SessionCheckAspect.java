package com.yyfolium.springbootrestserver.session;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
    1. 해야할 일 (Advice)
    2. 어디에 적용시킬 것인가 (Pointcut)
 */
@Component
@Aspect
public class SessionCheckAspect {

    @Autowired
    private SessionRepository sessionRepository;

    @Around("@annotation(com.yyfolium.springbootrestserver.session.SessionCheck)")
    public Object sessionCheckPerf(ProceedingJoinPoint pip) throws Throwable {
        Map requestObject = (Map) pip.getArgs()[0];

        System.out.println(requestObject.toString());

        Map sessionObject = (Map) requestObject.get("sessionObject");
        if(sessionObject==null) {
            return null;
        }

        String sessionId = sessionObject.get("sessionId").toString();
        Session session = sessionRepository.findById(sessionId);
        if(session==null) {
            return null;
        }

        Object retVal = pip.proceed();
        return retVal;
    }

}
