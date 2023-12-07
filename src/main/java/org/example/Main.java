package org.example;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws CsvValidationException, IOException, ParseException {

        String filePath = "src/main/resources/foreign_names.csv";
        PersonsList personsList = new PersonsList();

        try {
            personsList.readCSVToPersonList(filePath);
            System.out.println(personsList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}