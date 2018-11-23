package com.company.task6;

import java.util.ArrayList;

public class University {
    private ArrayList<Student> students;

    public University(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void sortNames() {
        StudentNameComparator snc = new StudentNameComparator();
        students.sort(snc);
        System.out.println(students);
    }

    public void sortSingleGroup(String group) {
        ArrayList<Student> res = new ArrayList<>();
        for (Student st : students) {
            if (st.getGroup().equals(group)) res.add(st);
        }
        res.sort(new StudentNameComparator());
        System.out.println(res);
    }

    public void sortGroups() {
        StudentGroupComparator sgc = new StudentGroupComparator();
        students.sort(sgc);
        System.out.println(students);
    }

    public void only4or5() {
        ArrayList<Student> res = new ArrayList<>();
        for (Student st : students) {
            if (goodOrExcellent(st.getMarks())) res.add(st);
        }
        StudentNameComparator snc = new StudentNameComparator();
        res.sort(snc);
        System.out.println(res);
    }

    public static boolean goodOrExcellent(byte[] marks) {
        boolean res = true;
        for (int i=0; i<marks.length; i++) {
            if (marks[i]<4) {res = false; break;}
        }
        return res;
    }

    public void averageMarkNotLowerThan(float cutoff) {
        ArrayList<Student> res = new ArrayList<>();
        for (Student st : students) {
            if (st.getAverageMark() >= cutoff) res.add(st);
        }
        StudentAverageMarkComparator samc = new StudentAverageMarkComparator();
        res.sort(samc);
        System.out.println(res);
    }
}
