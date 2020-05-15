package com.blackcat.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * <p> 描述 ：标签和过滤
 * 可以通过 @Tag 注释对测试类和方法进行标记。这些标记稍后可用于筛选测试发现和执行。
 * @author : blackcat
 * @date : 2020/5/15 15:58
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 * @see TestInfoDemo#test1 有使用示例
 *
 * 有关演示如何为标记创建自定义注释的示例，请参见元注释和组合注释。
 *
 * 语法规则
 * 标签不能为空或 null。
 * trim() 的标记不能包含空格。
 * trim() 的标签不能包含ISO控制字符。
 * trim()的标记不能包含以下任何保留字符:
 *      ,: 逗号
 *      (: 左括号
 *      ): 右括号
 *      &: 与
 *      |: 竖线
 *      : 非
 */
@Tag("fast")
@Tag("model")
public class TaggingDemo {

    @Test
    @Tag("taxes")
    void testingTaxCalculation() {
    }
}
