package com.blackcat.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * <p> 描述 ：MyRandomParametersTest演示如何将随机值注入@Test方法。
 * @author : blackcat
 * @date : 2020/5/15 16:53
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 */
@ExtendWith(RandomParametersExtension.class)
public class MyRandomParametersTest {
    @Test
    void injectsInteger(@RandomParametersExtension.Random int i, @RandomParametersExtension.Random int j) {
        assertNotEquals(i, j);
    }

    @Test
    void injectsDouble(@RandomParametersExtension.Random double d) {
        assertEquals(0.0, d, 1.0);
    }
}
