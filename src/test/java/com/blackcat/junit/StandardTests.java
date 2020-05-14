package com.blackcat.junit;

import org.junit.jupiter.api.*;

/**
 * <p> 描述 ：方法注解测试
 * @author : blackcat
 * @date : 2020/5/14 14:09
 * @link https://junit.org/junit5/docs/current/user-guide/#overview-java-versions
 */
public class StandardTests {

    public StandardTests() {
        System.out.println("构造函数");
    }

    /**
     * <p> 描述 :
     *      Test:表示该方法是一个测试方法。与JUnit 4的@Test注解不同的是，它没有声明任何属性，因为JUnit Jupiter中的测试扩展是基于它们自己的专用注解来完成的。
     *      DisplayName: 该注解为测试类或测试方法声明了一个自定义显示的名称
     * @author : blackcat
     * @date  : 2020/5/14 14:32
    */
    @Test
    @Disabled("自定义名称")
    void firstTest() {
        System.out.println("执行方法");
    }

    /**
     * <p> 描述 : Tag该注解表示为将测试类或者测试方法进行自定名称的标记，使用了标记后可以通过这些标记用来过滤、测试、发现和执行。
     * @author : blackcat
     * @date  : 2020/5/14 14:39
    */
    @Tag("second")
    @Test
    void secTest() {
        System.out.println("第二个方法");
    }

    /**
     * <p> 描述 : 该注解用来禁止整个测试类或者测试方法的执行。
     * 如上结果使用了此注解的测试方法skipRun并没有被执行，只输出了’skip run‘的禁止执行声明。
     * @author : blackcat
     * @date  : 2020/5/14 14:44
    */
    @Test
    @Disabled("skip run")
    @DisplayName("自定义")
    void skipRun() {
        System.out.println("不执行方法");
    }


    /**
     * <p> 描述 : 使用了该注解的方法在当前整个测试类中所有的测试方法之前执行，每个测试类运行时只会执行一次。
     * 并且这个注解需在static方法上使用，有一种情况例外（声明了TestInstance.Lifecycle.PER_CLASS情况下允许使用在非static方法上）。
     * @author : blackcat
     * @date  : 2020/5/14 14:24
    */
    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll：所有方法之前");
    }

    /**
     * <p> 描述 : 这个注解表示了在每一个测试方法（测试方法表示为所有了@Test、@RepeatedTest、@ParameterizedTest或者@TestFactory注解的方法）之前执行。
     * 根据如上接口可以看到每次执行@Test方法之前都会先执行@BeforeEach注解的方法一次（此方法执行输出结果为BeforeEach）。
     * 注意：不要与@BeforeAll概念混淆，@BeforeEach会每一个测试方法执行之前都会执行，@BeforeAll只会执行一次。
     * @author : blackcat
     * @date  : 2020/5/14 14:28
    */
    @BeforeEach
    void init() {
        System.out.println("在每一个测试方法之前执行。");
    }

    /**
     * <p> 描述 : 此注解表示在每一个测试方法执行之后都会执行。
     * @author : blackcat
     * @date  : 2020/5/14 14:29
    */
    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach: 每一个测试方法执行之后");
    }

    /**
     * <p> 描述 : 使用了该注解的方法在当前测试类中所有测试方法都执行完毕后执行的，每个测试类运行时只会执行一次。
     * 同样这个注解需要在static方法上使用，有一种例外情况。
     * 可以看到输出结果AfterAll是最后一个输出的。
     * @author : blackcat
     * @date  : 2020/5/14 14:26
    */
    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll：所有方法之后");
    }

}
