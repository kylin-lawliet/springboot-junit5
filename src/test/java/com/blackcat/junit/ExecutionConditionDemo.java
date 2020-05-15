package com.blackcat.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.JRE.*;
import static org.junit.jupiter.api.condition.OS.*;

/**
 * <p> 描述 ：条件测试执行
 * @author : blackcat
 * @date : 2020/5/15 15:30
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 *
 * JUnit Jupiter中的ExecutionCondition扩展API允许开发人员以编程方式启用或禁用容器或测试。 这种情况最简单的例子是内置的DisabledCondition，它支持 @Disabled注释，也就是@Disabled注解介绍博文。
 * 除了@Disabled之外，JUnit Jupiter还支持 org.junit.jupiter.api.condition类中的其他几个注解去允许开发人员以注解声明的方式启用或禁用容器和测试的条件包。
 */
public class ExecutionConditionDemo {

    //********************************规定操作系统条件*******************************
    // 可以通过@EnabledOnOs和@DisabledOnOs注解在特定操作系统上启用或禁用容器或测试。

    @Test
    @EnabledOnOs(MAC)
    void onlyOnMacOs() {
        // ...
    }

    @TestOnMac
    void testOnMac() {
        // ...
    }

    @Test
    @EnabledOnOs({ LINUX, MAC })
    void onLinuxOrMac() {
        // ...
    }

    @Test
    @DisabledOnOs(WINDOWS)
    void notOnWindows() {
        // ...
    }
    //********************************规定操作系统条件*******************************


    //********************************规定Java 运行环境条件*******************************
    // 可以通过@EnabledOnJre和@DisabledOnJre注解在特定版本的Java运行时环境（JRE）上启用或禁用容器或测试。
    // 容器或测试可以通过@enabledforjre和@disabled on JRE注释在特定版本的Java运行时环境（JRE）上启用或禁用，
    // 也可以通过@enabledforjrange和@disabledforjrange注释在特定范围的JRE版本上启用或禁用。
    // 范围默认为JRE.JAVA_8版作为下边界（最小值）和JRE.其他作为更高的边界（max），允许使用半开放范围。

    @Test
    @EnabledOnJre(JAVA_8)
    void onlyOnJava8() {
        // ...
    }

    @Test
    @EnabledOnJre({ JAVA_9, JAVA_10 })
    void onJava9Or10() {
        // ...
    }

    @Test
    void fromJava9to11() {
        // ...
    }

    @Test
    void fromJava9toCurrentJavaFeatureNumber() {
        // ...
    }

    @Test
    void fromJava8To11() {
        // ...
    }

    @Test
    @DisabledOnJre(JAVA_9)
    void notOnJava9() {
        // ...
    }

    /*
    @DisabledForJreRange 当前版本低 5.6支持
    @Test
    @DisabledForJreRange(min = JAVA_9, max = JAVA_11)
    void notFromJava9to11() {
        // ...
    }

    @Test
    @DisabledForJreRange(min = JAVA_9)
    void notFromJava9toCurrentJavaFeatureNumber() {
        // ...
    }

    @Test
    @DisabledForJreRange(max = JAVA_11)
    void notFromJava8to11() {
        // ...
    }*/
    //********************************规定Java 运行环境条件*******************************

    //************************规定系统属性条件****************************
    // 通过 @EnabledIfSystemProperty 和 @DisabledIfSystemProperty 注解，
    // 可以根据命名的JVM系统属性的值启用或禁用容器或测试。
    // 其中通过matches属性提供的值将被解释为正则表达式。

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void onlyOn64BitArchitectures() {
        // ...
    }

    @Test
    @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    void notOnCiServer() {
        // ...
    }
    //************************规定系统属性条件****************************
    // 可以根据底层操作系统中命名的环境变量的值通过 @EnabledIfEnvironmentVariable和 @DisabledIfEnvironmentVariable 注解来启用或禁用容器或测试。
    // 其中通过matches属性提供的值将被解释为正则表达式。

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    void onlyOnStagingServer() {
        // ...
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    void notOnDeveloperWorkstation() {
        // ...
    }
    //************************规定环境变量条件****************************
}
