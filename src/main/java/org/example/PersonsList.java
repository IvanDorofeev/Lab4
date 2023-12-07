package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This class is for reading personal information from csv and write it into ArrayList
 * @author Ivan Dorofeev
 */
public class PersonsList {
    /**
     * List for saving all the person's information
     */
    ArrayList <Person> persons;

    /**
     * Constructor for already read Persons
     * @param persons Person's ArrayList
     */
    public PersonsList(ArrayList<Person> persons) {
        this.persons = persons;
    }
    /**
     * Constructor for new Persons
     */
    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    /**
     * Method for string representation of Person's List
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PersonsList{");
        for (Person person: persons) {
            stringBuilder.append(person + "\n");
        }
        stringBuilder.append("}\n");
        return String.valueOf(stringBuilder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonsList that = (PersonsList) o;
        return Objects.equals(persons, that.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persons);
    }

    /**
     * Method for read information from csv and write it into ArrayList persons
     * @param filePath path of the file
     */
    public void readCSVToPersonList(String filePath) throws IOException, CsvValidationException, ParseException {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(filePath));
            String[] nextLine = csvReader.readNext();

            while ((nextLine = csvReader.readNext()) != null) {
                String[] nextLineDilimited = nextLine[0].split(";");

                persons.add(new Person(Integer.parseInt(nextLineDilimited[0]),
                        nextLineDilimited[1],
                        nextLineDilimited[2],
                        new SimpleDateFormat("dd.MM.yyyy").parse(nextLineDilimited[3]),
                        new Division((nextLineDilimited[4].charAt(0) - 'A'), nextLineDilimited[4]),
                        Integer.parseInt(nextLineDilimited[5])));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
