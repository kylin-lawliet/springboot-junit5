package com.blackcat.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p> 描述 ：简单入门例子
 * @author : blackcat
 * @date : 2020/5/14 13:51
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests
 */
public class FirstJUnit5Tests {

    @Test
    void myFirstTest() {
        System.out.println("简单入门例子");
        assertEquals(2, 1+1);
    }
}
