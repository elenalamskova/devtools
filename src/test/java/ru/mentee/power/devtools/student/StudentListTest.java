package ru.mentee.power.devtools.student;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @Test
    void addStudentIncreasesSize() {
        StudentList list = new StudentList();
        Student student = new Student("Иван", "Пермь");

        list.addStudent(student);

        assertEquals(1, list.getStudentsByCity("Пермь").size());
    }

    @Test
    void getStudentsByCityFiltersCorrectly() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Иван", "Пермь"));
        list.addStudent(new Student("Петр", "Москва"));

        List<Student> permStudents = list.getStudentsByCity("Пермь");

        assertEquals(1, permStudents.size());
        assertEquals("Иван", permStudents.get(0).name());
    }
    @Test
    void addStudentShouldIgnoreNull() {
        StudentList list = new StudentList();

        list.addStudent(null);

        assertEquals(0, list.getStudentsByCity("Пермь").size());
    }
}