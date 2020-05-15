package com.blackcat.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;

/**
 * <p> 描述 ：构造函数和方法的依赖注入
 * @author : blackcat
 * @date : 2020/5/15 16:31
 * @link https://junit.org/junit5/docs/current/user-guide/#writing-tests-assumptions
 *
 * 其他参数解析器必须通过@ExtendWith注册适当的扩展来显式启用。
 * 方法参数的类型是TestReporter，TestReporterParameterResolver将提供一个TestReporter的实例。
 * TestReporter可用于发布有关当前测试运行的额外数据。
 * 数据可以通过TestExecutionListener.reportingEntryPublished()来使用，因此可以被IDE查看或包含在报告中。
 * 在JUnit Jupiter中，当你需要打印信息时，就像在JUnit4使用stdout或stderr，你应该使用TestReporter。
 * 使用@RunWith（JUnitPlatform.class）甚至会将所有报告的条目输出到stdout。
 */
public class TestReporterDemo {

    @Test
    void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("a key", "a value");
    }

    @Test
    void reportSeveralValues(TestReporter testReporter) {
        HashMap<String, String> values = new HashMap<>();
        values.put("user name", "dk38");
        values.put("award year", "1974");

        testReporter.publishEntry(values);
    }
}
