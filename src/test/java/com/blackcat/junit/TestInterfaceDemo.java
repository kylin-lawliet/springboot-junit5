package com.blackcat.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p> 描述 ：测试接口和默认方法
 * @author : blackcat
 * @date : 2020/5/15 17:07
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 *
 * JUnit Jupiter允许在接口default方法中声明@Test，@RepeatedTest，@ParameterizedTest，
 * @ TestFactory，@TestTemplate，@BeforeEach和@AfterEach。
 * 如果测试接口或测试类用@TestInstance(Lifecycle.PER_CLASS)注解（请参阅测试实例生命周期），
 * 则可以在测试接口中的static方法或接口default方法上声明@BeforeAll和@AfterAll。
 */
public class TestInterfaceDemo implements TestLifecycleLogger,
        TimeExecutionLogger, TestInterfaceDynamicTestsDemo {

    @Test
    void isEqualValue() {
        assertEquals(1, "a".length(), "is always equal");
    }
}
