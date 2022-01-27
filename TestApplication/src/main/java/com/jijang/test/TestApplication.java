package com.jijang.test;

import com.jijang.test.t1.TestRegister;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class TestApplication {

    public static void main(String[] args) throws CsvValidationException, IOException {
        TestRegister register = new TestRegister();
        register.registerTest();
    }
}
