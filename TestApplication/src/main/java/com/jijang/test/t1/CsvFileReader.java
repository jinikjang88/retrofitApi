package com.jijang.test.t1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class CsvFileReader {

    private static final String CSV_FILE_PATH = "sample.csv";
    private final TestApi testApi;

    public CsvFileReader() {
        this.testApi = new TestApi();
    }

    public void readFromCsv() throws IOException, CsvValidationException {
        URL resource = CsvFileReader.class.getClassLoader().getResource(CSV_FILE_PATH);

        if (Objects.isNull(resource)) {
            throw new IllegalArgumentException(CSV_FILE_PATH + " file not found ");
        }

        CSVReader reader = new CSVReader(new FileReader(resource.getFile()));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            System.out.println("#" + Arrays.toString(nextLine));
            testApi.postTest(nextLine[0]);
        }
    }
}
