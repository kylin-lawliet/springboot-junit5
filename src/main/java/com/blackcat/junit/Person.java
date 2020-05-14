package com.blackcat.junit;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p> 描述 ：测试模型
 * @author : blackcat
 * @date : 2020/5/14 15:11
 */
@Data
@AllArgsConstructor
public class Person {

    private String lastName;
    private String firstName;
}
