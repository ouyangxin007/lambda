package com.example;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by chixue on 18-12-18.
 */

@Data
@ToString
@Accessors(chain = true)
public class People {
    private String name;
    private int age;
    private String sex;
}
