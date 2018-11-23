package com.company.task6;

import java.util.Arrays;

public class Student {
    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public byte[] getMarks() {
        return marks;
    }

    public float getAverageMark() {
        float avg = 0.0f;
        for (int i=0; i< this.marks.length; i++) {
            avg+=this.marks[i];
        }
        if (this.marks.length != 0) avg/=this.marks.length;
        return avg;
    }

    private String name;
    private String group;
    private byte[] marks;

    public Student(String name, String group, byte[] marks) {
        this.name = name;
        this.group = group;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
