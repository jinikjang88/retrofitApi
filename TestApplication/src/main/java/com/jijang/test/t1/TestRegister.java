package com.jijang.test.t1;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class TestRegister {

    private final CsvFileReader csvFileReader;

    public TestRegister() {
        this.csvFileReader = new CsvFileReader();
    }

    public void registerTest() throws CsvValidationException, IOException {
        csvFileReader.readFromCsv();
    }
}
