package com.blackcat.junit;

import org.junit.jupiter.api.Test;

/**
 * <p> 描述 ：元注释,注释测试
 * @author : blackcat
 * @date : 2020/5/14 14:03
 * @see Fast
 * @see FastTest
 */
public class myFastTest {

    @Fast
    @Test
    void myFastTest() {
        // ...
    }

    @FastTest
    void myFastTest2() {
        // ...
    }
}
