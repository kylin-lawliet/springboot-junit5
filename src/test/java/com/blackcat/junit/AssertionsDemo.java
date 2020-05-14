package com.blackcat.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <p> 描述 ：断言
 * 断言是编写单元测试用例的核心方式，即期望值是多少，测试的结果是多少，以此来判断测试是否通过。
 * 本类中的示例只是根据官网写出的部分示例，全部方法请看org.junit.jupiter.api.Assertions类
 * @author : blackcat
 * @date : 2020/5/14 14:49
 * @see Assertions
 * @link https://junit.org/junit5/docs/current/user-guide/#overview-java-versions
 *
 * 官网翻译：
 * JUnit Jupiter附带了许多JUnit 4拥有的断言方法，并添加了一些可以很好地用于Java 8 lambdas的断言方法。
 * 所有JUnit Jupiter断言都是 org.junit.jupiter.api.Assertions 中的静态方法断言类。
 */
public class AssertionsDemo {

    private final Person person =new Person("Jane", "Doe");

    /**
     * <p> 描述 :
     *      assertEquals比较两个值是否相同
     *      assertTrue 判断括号里面的参数是否为true
     * 当不相等时，会打印出第三个参数，下面的所有的此类型的参数都是这种作用
     * @author : blackcat
     * @date  : 2020/5/14 15:14
    */
    @Test
    void standardAssertions() {
        assertEquals(2, 2);
        assertTrue('a' < 'b', () -> "断言消息可以惰性地进行求值，以避免不必要地构造复杂消息。");
        // 报错：org.opentest4j.AssertionFailedError: 可选的断言消息现在是最后一个参数。 ==>
        assertEquals(4, 4, "可选的断言消息现在是最后一个参数。");
    }

    /**
     * <p> 描述 : assertAll()方法用于将多个测试语句放在一个组中执行
     * 组中若有一个测试语句不通过，则这个组将会一起报错.
     * 第一个参数 person ：组名称
     * 第二个参数：组测试语句
     * @author : blackcat
     * @date  : 2020/5/14 15:18
    */
    @Test
    void groupedAssertions() {
        assertAll("person",
                () -> assertEquals("John", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName())
        );
    }

    /**
     * <p> 描述 : assertAll()方法也可以嵌套多个assertAll()方法
     * 其中嵌套的多个测试组，这些组只会打印出这个组和父组的错误，对其他的组没有影响
     * @author : blackcat
     * @date  : 2020/5/14 15:20
    */
    @Test
    void dependentAssertions() {
        // 在代码块中，如果断言失败，则将跳过同一块中的后续代码。
        assertAll("properties",
                //第一个测试组
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    // 仅在前面的断言有效时执行。
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("n"))
                    );
                },
                //第二个测试组
                () -> {
                    // 分组断言，因此独立于名断言的结果进行处理。
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    // 仅在前面的断言有效时执行。
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }

    /**
     * <p> 描述 : assertThrows()可以用来判断lambda表达式中的代码抛出的异常
     * @author : blackcat
     * @date  : 2020/5/14 15:25
     *
     * 参数：
     * 1：异常类声明
     * 2：测试代码Lambda表达式
    */
    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
                BigDecimal.ONE.divide(BigDecimal.ZERO));
        assertEquals("/ by zero", exception.getMessage());
    }

    /**
     * <p> 描述 : assertTimeout()对方法执行时间进行测试
     * 这里要借助java.time.Duration中的方法结合实现
     * 实例中执行的代码部分必须在2分钟之内执行完毕，否则测试不通过
     * @author : blackcat
     * @date  : 2020/5/14 15:30
    */
    @Test
    void timeoutNotExceeded() {
        assertTimeout(ofMinutes(2), () -> {
            //执行的代码部分
        });
    }

    /**
     * <p> 描述 : assertTimeout()还可以接受一个返回值（泛型 T）
     * 被测试代码如果通过测试并返回一个值，这个值被assertTimeout()方法返回
     * @author : blackcat
     * @date  : 2020/5/14 15:32
    */
    @Test
    void timeoutNotExceededWithResult() {
        // 以下断言成功，并返回提供的对象。
        String actualResult = assertTimeout(ofMinutes(2), () -> {
            return "a result";
        });
        assertEquals("a result", actualResult);
    }

    /**
     * <p> 描述 : assertTimeout（）毫秒案例
     * @author : blackcat
     * @date  : 2020/5/14 15:33
    */
    @Test
    void timeoutExceeded() {
        // 以下断言失败，错误消息类似于：执行超过超时10毫秒91毫秒
        assertTimeout(ofMillis(10), () -> {
            // 模拟超过10毫秒的任务
            Thread.sleep(100);
        });
    }

    /**
     * <p> 描述 : 抢占超时
     * @author : blackcat
     * @date  : 2020/5/14 15:37
     * 使用assertTimeoutPreemptyly（）的抢占超时与声明性超时相反，
     * Assertions类中的各种assertTimeoutPreemptyly（）方法在不同于调用代码的线程中执行提供的可执行文件或提供程序。
     * 如果在可执行文件或供应商中执行的代码依赖java.lang.ThreadLocal存储，
     * 则此行为可能会导致不良的副作用。
     *
     * 一个常见的例子是Spring框架中的事务测试支持。
     * 具体来说，Spring的测试支持在调用测试方法之前将事务状态绑定到当前线程（通过ThreadLocal）。
     * 因此，如果提供给asserttimeoutpremptily（）的可执行文件或供应商调用参与事务的Spring托管组件，
     * 则这些组件所采取的任何操作都不会与测试托管事务一起回滚。
     * 相反，即使测试管理的事务被回滚，此类操作也将被提交到持久存储（例如，关系数据库）。
     * 依赖ThreadLocal存储的其他框架可能会遇到类似的副作用。
    */
    @Test
    void timeoutExceededWithPreemptiveTermination() {
        // 以下断言失败，错误消息类似于：10毫秒后执行超时
        assertTimeoutPreemptively(ofMillis(10), () -> {
            // 模拟超过10毫秒的任务。
            new CountDownLatch(1).await();
        });
    }

}
