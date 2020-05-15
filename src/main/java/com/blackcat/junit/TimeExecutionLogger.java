package com.blackcat.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * <p> 描述 ：
 *
 * @author : blackcat
 * @date : 2020/5/15 17:12
 */
@Tag("timed")
@ExtendWith(TimingExtension.class)
interface TimeExecutionLogger {
}
