package com.jijang.test.t1.service;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TestParameter {
    private String test;

    public static TestParameter of(String test) {
        TestParameter testParameter = new TestParameter();
        testParameter.test = test;
        return testParameter;
    }
}
