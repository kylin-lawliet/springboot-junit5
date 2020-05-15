package com.blackcat.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static javafx.beans.binding.Bindings.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p> 描述 ：构造函数和方法的依赖注入
 * MyMockitoTest演示了如何将Mockito mock注入@BeforeEach和@Test方法。
 * @author : blackcat
 * @date : 2020/5/15 16:40
 */
@ExtendWith(MockitoExtension.class)
public class MyMockitoTest {

    @BeforeEach
    void init(@Mock Person person) {
        person.setFirstName("Dilbert");
//        when(person.getName()).thenReturn("Dilbert");
    }

    @Test
    void simpleTestWithInjectedMock(@Mock Person person) {
        assertEquals("Dilbert", person.getFirstName());
    }
}
