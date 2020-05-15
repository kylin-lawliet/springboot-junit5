package com.blackcat.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * <p> 描述 ：禁用方法的测试类。
 * @author : blackcat
 * @date : 2020/5/15 15:21
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 */
public class DisabledTestsDemo {

    /**
     * <p> 描述 : 此方法被禁止执行，并在控制台打印自定义消息'Disabled until bug #42 has been resolved'
     * @author : blackcat
     * @date  : 2020/5/15 15:23
    */
    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void testWillBeSkipped() {
    }

    /**
     * <p> 描述 : 此方法被禁止执行，并在控制台打印默认消息'void com.blackcat.junit.DisabledTestsDemo.testWillBeSkipped2() is @Disabled'
     * @author : blackcat
     * @date  : 2020/5/15 15:24
    */
    @Disabled
    @Test
    void testWillBeSkipped2() {
    }

    /**
     * <p> 描述 : 此方法正常执行
     * @author : blackcat
     * @date  : 2020/5/15 15:23   
    */
    @Test
    void testWillBeExecuted() {
    }
}
