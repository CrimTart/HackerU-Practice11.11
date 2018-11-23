package com.company.task6;

import com.company.task6.Student;

import java.util.Comparator;

public class StudentGroupComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2){
        if(s1.getGroup().compareTo(s2.getGroup()) == 0) return s1.getName().compareTo(s2.getName());
        return s1.getGroup().compareTo(s2.getGroup());
    }
}
