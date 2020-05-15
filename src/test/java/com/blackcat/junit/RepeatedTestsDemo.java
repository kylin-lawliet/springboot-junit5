package com.blackcat.junit;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p> 描述 ：重复测试
 * JUnit Jupiter通过使用@RepeatedTest注解方法并指定所需的重复次数，提供了重复测试指定次数的功能。
 * 每次重复测试的调用都像执行常规的@Test方法一样，完全支持相同的生命周期回调和扩展。
 * @author : blackcat
 * @date : 2020/5/15 17:20
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 *
 * 除了指定重复次数外，还可以通过@RepeatedTest注解的name属性为每次重复配置自定义显示名称。
 * 此外，显示名称可以是模式，由静态文本和动态占位符的组合而成。
 * 目前支持以下占位符：
 * {displayName}: @RepeatedTest方法的显示名称
 * {currentRepetition}: 当前重复次数
 * {totalRepetitions}: 重复的总次数
 */
public class RepeatedTestsDemo {

    Logger logger = Logger.getLogger(RepeatedTestsDemo.class.getName());

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        logger.info(String.format("About to execute repetition %d of %d for %s", //
                currentRepetition, totalRepetitions, methodName));
    }

    /**
     * <p> 描述 : 该测试将自动重复10次。
     * @author : blackcat
     * @date  : 2020/5/15 17:23
    */
    @RepeatedTest(10)
    void repeatedTest() {
        // ...
    }

    /**
     * <p> 描述 : RepetitionInfo的实例注入@RepeatedTest
     * @author : blackcat
     * @date  : 2020/5/15 17:24
    */
    @RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }

    /**
     * <p> 描述 : 占位符
     * @author : blackcat
     * @date  : 2020/5/15 17:24
     * {displayName}: @RepeatedTest方法的显示名称
     * {currentRepetition}: 当前重复次数
     * {totalRepetitions}: 重复的总次数
    */
    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void customDisplayName(TestInfo testInfo) {
        assertEquals("Repeat! 1/1", testInfo.getDisplayName());
    }

    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    void customDisplayNameWithLongPattern(TestInfo testInfo) {
        assertEquals("Details... :: repetition 1 of 1", testInfo.getDisplayName());
    }

    @RepeatedTest(value = 5, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
    void repeatedTestInGerman() {
        // ...
    }

}
