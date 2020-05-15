package com.blackcat.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p> 描述 ：嵌套测试 堆栈测试例子
 * 实例生命周期跟这个我没太懂，先参照官网写出例子，后期熟悉之后补充
 * @author : blackcat
 * @date : 2020/5/15 16:17
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 *
 * 嵌套测试使测试编写者有更多的能力来表达几组测试之间的关系。这是一个精心设计的例子。
 * 只有非静态嵌套类（即内部类）才能用作@nested测试类。
 * 嵌套可以是任意深度的，并且这些内部类被认为是测试类家族的完整成员，
 * 只有一个例外：@BeforeAll和@AfterAll方法默认不工作。原因是Java不允许内部类中有静态成员。
 * 但是，可以通过使用@test Instance（Lifecycle.PER_class）注释@Nested测试类来规避此限制（请参见测试实例生命周期）。
 */
@DisplayName("A stack")
public class TestingAStackDemo {

    Stack<Object> stack;

    @Test
    @DisplayName("is instantiated with new Stack()")
    void isInstantiatedWithNew() {
        new Stack<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {

            String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty() {
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElementWhenPopped() {
                assertEquals(anElement, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked() {
                assertEquals(anElement, stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }
}
