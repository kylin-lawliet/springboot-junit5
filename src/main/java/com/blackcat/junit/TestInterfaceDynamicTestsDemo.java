package com.blackcat.junit;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * <p> 描述 ：测试接口和默认方法
 * @author : blackcat
 * @date : 2020/5/15 17:10
 * https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 */
interface TestInterfaceDynamicTestsDemo {

    @TestFactory
    default Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
                dynamicTest("1st dynamic test in test interface", () -> assertTrue(true)),
                dynamicTest("2nd dynamic test in test interface", () -> assertEquals(4, 2 * 2))
        );
    }
}
