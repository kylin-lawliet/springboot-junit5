package com.blackcat.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> 描述 ：元注释,注释
 * @author : blackcat
 * @date : 2020/5/14 14:05
 * @link https://junit.org/junit5/docs/current/user-guide/#overview-java-versions
 *
 * 官网翻译：
 * 您甚至可以更进一步，引入一个定制的@fast Test注释，它可以作为@Tag（“fast”）和@Test的替换。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
@Test
public @interface FastTest {
}
