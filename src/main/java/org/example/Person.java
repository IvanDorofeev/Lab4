package org.example;

import java.util.Date;
import java.util.Objects;

/**
 * This class is for Person's structure
 * @author Ivan Dorofeev
 */
public class Person {
    int id;
    String name;
    String sex;
    Date birthDate;
    Division division;
    int salary;

    public Person(int id, String name, String sex, Date birthDate, Division division, int salary) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.division = division;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate=" + birthDate +
                ", division=" + division +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && salary == person.salary && Objects.equals(name, person.name) && Objects.equals(sex, person.sex) && Objects.equals(birthDate, person.birthDate) && Objects.equals(division, person.division);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, birthDate, division, salary);
    }
}
