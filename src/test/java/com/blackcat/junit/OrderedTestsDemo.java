package com.blackcat.junit;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * <p> 描述 ：测试执行顺序
 * 默认情况下，测试方法将使用一个确定的、但故意不明显的算法进行排序。
 * 这可以确保测试套件的后续运行以相同的顺序执行测试方法，从而允许可重复的构建。
 * @author : blackcat
 * @date : 2020/5/15 16:08
 *
 * 官网翻译：
 * 虽然真正的单元测试通常不应该依赖于它们执行的顺序，但有时需要强制执行特定的测试方法执行顺序，
 * 例如，在编写集成测试或功能测试时，测试的顺序很重要，尤其是与@TestInstance（Lifecycle.PER_CLASS）结合使用。
 * 要控制测试方法的执行顺序，请使用@TestMethodOrder注释测试类或测试接口，
 * 并指定所需的methodorder实现。您可以实现自己的自定义methodorder或使用以下内置methodorder实现之一。
 * Alphanumeric：根据测试方法的名称和形式参数列表对其进行字母数字排序。
 * OrderAnnotation：根据通过@Order注释指定的值对测试方法进行数字排序。
 * Random：伪随机命令测试方法，并支持自定义种子的配置。
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.Alphanumeric.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.Random.class)
public class OrderedTestsDemo {

    @Test
    @Order(1)
    void nullValues() {
        // perform assertions against null values
    }

    @Test
    @Order(2)
    void emptyValues() {
        // perform assertions against empty values
    }

    @Test
    @Order(3)
    void validValues() {
        // perform assertions against valid values
    }
}
