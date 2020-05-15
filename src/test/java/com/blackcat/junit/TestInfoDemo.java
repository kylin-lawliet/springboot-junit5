package com.blackcat.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p> 描述 ：构造函数和方法的依赖注入
 * TestInfoParameterResolver内置解析器
 * @author : blackcat
 * @date : 2020/5/15 16:25
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 *
 * 如果方法参数是TestInfo类型，则TestInfoParameterResolver将提供一个TestInfo的实例，对应当前测试，作为参数的值。
 * 然后TestInfo可以用来获取有关当前测试的信息，例如测试的显示名称，测试类，测试方法或关联的标签。
 * 显示名称可以是技术名称，例如测试类或测试方法的名称，也可以是通过@DisplayName配置的自定义名称。
 * TestInfo充当JUnit4的TestName规则的替换品。以下演示如何将TestInfo注入到测试构造函数，@BeforeEach方法和@Test方法中
 */
public class TestInfoDemo {

    TestInfoDemo(TestInfo testInfo) {
        assertEquals("TestInfoDemo", testInfo.getDisplayName());
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {
    }
}
