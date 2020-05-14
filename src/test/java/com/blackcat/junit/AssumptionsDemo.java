package com.blackcat.junit;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * <p> 描述 ：假设
 * 顾名思义是假设的意思也就是做一些假设，只有当假设成功后才会执行接下来的代码。
 * JUnit Jupiter附带了JUnit 4提供的假设方法的一个子集，并添加了一些可以很好地用于Java 8 lambdas的假设方法。
 * 所有的JUnit Jupiter假设都是在 org.junit.jupiter.api.Assumptions 的静态方法。
 * @author : blackcat
 * @date : 2020/5/14 15:46
 * @see Assumptions
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 *
 * 使用Assumptions类中的假设方法时，当假设不成立时会报错，但是测试会显示被ignore忽略执行。
 * 也就是当我们一个类中有多个测试方法时，其中一个假设测试方法假设失败，其他的测试方法全部成功，那么该测试类也会显示测试成功！
 * 这说明假设方法适用于：在不影响测试是否成功的结果的情况下根据不同情况执行相关代码！
 */
public class AssumptionsDemo {

    @Test
    void testAssumTrue() {
        System.out.println("test");
        // assumeTrue该语句并不会影响其前面的语句执行
        //可以将3>5改成3<5自行测试成功的效果
        assumeTrue(3>5);
        //该方法中下面所有的代码变为在上面假设的条件成立后执行
        // 如果上述假设不成立，则会忽略执行该行下面的代码，并报错
        System.out.println("assume is true!");
    }

    @Test
    void testAssumTrueMessage() {
        assumeTrue(3<5,
                //第二个参数为当第一个参数不成立时，输出的自定义错误信息
                () -> "Aborting test: not on developer workstation");
        //下面的代码变为在上面假设的条件成立后执行
        System.out.println("assume is true!");
    }

    @Test
    void testAssumeTrueLambda(){
        //这个方法的第一个参数为函数式接口，通过看起源码可以发现无参数，返回值为boolean
        assumeTrue(()->{
            System.out.println("in assumeTrue");
            boolean flag = true;
//            boolean flag = false;
            return flag;
        });
        System.out.println("out assumeTrue");
    }

    @Test
    void testAssumFalse(){
        //同assumTrue效果相反
        assumeFalse(3>5);
        System.out.println("assume is true!");
    }

    @Test
    void testAssumFalseMessage(){
        //同assumTrue效果相反
        assumeFalse(3<5,
                () -> "Aborting test: not on developer workstation");
        System.out.println("assume is true!");
    }

    @Test
    void testAssumThat() {
        assumingThat(3>5,
                () -> {
                    //与上述方法不同的是，仅当前面假设成立时，才会执行这里面的语句！！！！
                    // 且只会影响到该lambda表达式中的代码
                    assertEquals(2, 2);
                });
        //此处的断言不受上述assumingThat限制，在所有情况下都会执行
        System.out.println("no effect");
        assertEquals("a string", "a string");
    }
}
