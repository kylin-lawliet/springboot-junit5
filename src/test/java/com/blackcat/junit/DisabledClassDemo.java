package com.blackcat.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * <p> 描述 ：禁用
 * 因为在类上注释了@Disabled，所以类中的所有方法都被禁止执行
 * @author : blackcat
 * @date : 2020/5/14 16:11
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 *
 * 官网翻译：
 * 整个测试类或单个测试方法可以通过@disabled注释、条件测试执行中讨论的注释之一或通过自定义的ExecutionCondition禁用。
 */
@Disabled("禁用提示信息")
public class DisabledClassDemo {

    @Test
    void testWillBeSkipped() {
    }
}
