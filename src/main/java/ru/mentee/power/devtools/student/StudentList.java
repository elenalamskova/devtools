package ru.mentee.power.devtools.student;

import java.util.List;
import java.util.ArrayList;  // порядок импортов нарушен

public class StudentList {
        private List<Student> student__list;  // нарушение: snake_case

        public StudentList() {
            student__list = new ArrayList<>();
        }

        // нарушение: имя метода
        public void add_student(Student student) {
            if(student != null)  // нарушение: нет пробела после if
                student__list.add(student);
        }

        // нарушение: длинная строка (>120 символов)
        public List<Student>  get_students_from_specific_city_with_very_long_method_name_that_exceeds_one_hundred_twenty_characters(String city) {
            return student__list.stream().filter(s -> s.city().equals(city)).toList();
        }
    }
