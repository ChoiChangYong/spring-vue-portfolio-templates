package com.yyfolium.springbootrestserver.session;

import java.lang.annotation.*;

/*
    RetentionPolicy : 이 애노테이션 정보를 어디까지 유지할 것인가
            */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface SessionCheck {
}
