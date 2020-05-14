package com.blackcat.junit;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> 描述 ：元注释,注释
 * @author : blackcat
 * @date : 2020/5/14 14:01
 * @link https://junit.org/junit5/docs/current/user-guide/#overview-java-versions
 *
 * 官网翻译：
 * 例如，您可以创建一个名为 @Fast 的自定义组合注释，
 * 如下所示，而不是在整个代码库中复制和粘贴@Tag(“fast”)(请参阅标记和过滤)。然后可以使用@Fast作为@Tag(“fast”)的drop-in替代。
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
public @interface Fast {

}
