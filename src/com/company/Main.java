package com.company;

import com.company.task6.Student;
import com.company.task6.University;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(1, null, null);
        //OneWayList<Integer> list = new OneWayList<>(1, null);
        //list.append(2);
        MyList<Integer> list = new MyList<Integer>(new MyNode<>(0));
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //System.out.println(list.toString());
        //list.reverse();
        //System.out.println(list);
        /*int[] arr1 = {1,2,4,8,11}, arr2 = {3,5,6,10};
        int[] result = merge(arr1, arr2);
        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }*/
        Integer[] b = new Integer[]{3,4,5,6,7,8,1,2,3,4};
        //System.out.println(Arrays.toString(sort(b)));
        int[] a = new int[]{1,-2,3,-4,5};
        //reverseArray(a);
        //System.out.println(Arrays.toString(a));

        //System.out.println(polynomial(a));
        /*ArrayList<Student> studs = new ArrayList();
        studs.add(new Student("Vasya", "22", new byte[] {4,5,5,4,3}));//4.2
        studs.add(new Student("Kolya", "33", new byte[] {5,5,5,4,4,5}));//4.(6)
        studs.add(new Student("Petya", "33", new byte[] {4,5,5,5,3,4}));//4.(3)
        studs.add(new Student("Vasya", "34", new byte[] {5,4,5,5,4,4}));//4.5

        University uni = new University(studs);
        uni.sortNames();
        uni.sortSingleGroup("33");
        uni.sortGroups();
        uni.only4or5();
        uni.averageMarkNotLowerThan(4.5f);*/
        /*int[] arr = new int[]{1,2,3,-1,4,5,6,-1,7,-1};
        int[] minAm = minAndAmount(arr);
        System.out.println(minAm[0] + " " + minAm[1]);*/
        //System.out.println(crossDigitMax(652193891));
        User user1 = new User();
        user1.setUsername("Dominator666");
        user1.setEmail("vasyapupkin@mail.ru");
        user1.setPasswordHash(new byte[]{1, 2, 4, 8, 16, 32});
        User user2 = new User();
        user2.setUsername("~~EtheralWind~~");
        user2.setEmail("mashabubkina@yandex.ru");
        user2.setPasswordHash(new byte[]{5, 127, 28, 9, 11, 69});
        User user3 = new User();
        user3.setUsername("Ababuga");
        user3.setEmail("ababuga@urmom.com");
        user3.setPasswordHash(new byte[]{4, 8, 15, 16, 23, 42});
        ArrayList<User> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        list1.add(user1); list1.add(user2); list1.add(user3);
        list2.add(user1); list2.add(user3); list1.add(user2);
        ArrayList<User> repeating = repeatingUsers(list1, list2);
        for (User u : repeating) {
            printUser(u);
        }
    }

    //***********************************4**************************************
    public static int[] merge(int[] ar1, int[] ar2) {
        int[] res = new int[ar1.length + ar2.length];
        int i=0, j=0, k=0;
        while (k<res.length) {
            if (i==ar1.length) {
                res[k++] = ar2[j++];
                continue;
            }
            if (j==ar2.length){
                res[k++] = ar1[i++];
                continue;
            }
            if(ar1[i]<ar2[j]) res[k++] = ar1[i++];
            else res[k++] = ar2[j++];
            System.out.println(i + " "+ j + " " + k);
        }
        return res;
    }

    //*********************************5*****************************************
    public static Integer[] sort(Integer[] mas) {
        if (mas.length<=1) return mas;
        Integer a0 = mas[0];
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        for(int i=1; i<mas.length; i++) {
            if(mas[i]<a0) less.add(mas[i]);
            else greater.add(mas[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(sort(less.toArray(new Integer[0]))));
        result.add(a0);
        result.addAll(Arrays.asList(sort(greater.toArray(new Integer[0]))));
        return result.toArray(new Integer[0]);
    }

    //********************************3******************************************
    public static void reverseArray(int[] a) {
        int n = a.length;
        for(int i=0; i<n/2; i++) {
            a[i] += a[n-1-i];
            a[n-1-i] = a[i] - a[n-1-i];
            a[i]-=a[n-1-i];
        }
    }

    //*******************************7*******************************************
    public static StringBuilder polynomial(int[] a) {
        int n = a.length;
        StringBuilder result = new StringBuilder();
        for(int i=0; i<n; i++) {
            if (a[i]==0) continue;
            StringBuilder monomial = new StringBuilder().append(a[i]);
            for(int j=0; j<n-i-1; j++) {
                monomial.append("*x");
            }
            result.append(monomial.toString() + "+");
        }
        if (result.length() == 0) return new StringBuilder("0");
        result.deleteCharAt(result.length()-1);
        return result;
    }

    //********************************9******************************************
    public static int[] minAndAmount(int[] data) {
        if (data == null || data.length == 0) throw new IllegalArgumentException("Must have at least one number in a sequence!");
        int[] res = new int[]{data[0], 1};
        for (int i = 1; i < data.length; i++) {
            if (data[i] == res[0]) res[1]++;
            if (data[i] < res[0]) {res[0] = data[i]; res[1] = 1;}
        }
        return res;
    }

    //*********************************10***************************************
    public static int crossDigitMax(int number) {
        if (number < 1) throw new IllegalArgumentException("Must give a natural number.");
        if (number < 9) return 0;
        int res = crossDigit(number, 0), length = String.valueOf(number).length();
        for (int k=1; k<length; k++) {
            int candidate = crossDigit(number,k);
            if (res < candidate) res = candidate;
        }
        return res;
    }

    public static int crossDigit(int number, int k) {
        StringBuilder sb = new StringBuilder(String.valueOf(number));
        return Integer.parseInt(sb.deleteCharAt(k).toString());
    }

    //*************************************12************************************
    public static ArrayList<User> repeatingUsers(ArrayList<User> au1, ArrayList<User> au2) {
        if (au1 == null || au1.isEmpty() || au2 == null || au2.isEmpty()) return new ArrayList<>();

        ArrayList<User> resWithDupes = new ArrayList<>();
        for (User u1 : au1) {
            for (User u2 : au2) {
                if (userEquals(u1, u2)) {
                    resWithDupes.add(u1);
                    break;
                }
            }
        }

        ArrayList<User> resWithoutDupes = new ArrayList<>();
        for (User u : resWithDupes) {
            boolean duped = false;
            for (User u0 : resWithoutDupes) {
                if (userEquals(u, u0)) {
                    duped = true;
                    break;
                }
            }
            if (!duped) resWithoutDupes.add(u);
        }

        return resWithoutDupes;
    }

    public static boolean userEquals(User u1, User u2) {
        if (u1 == null) return (u2 == null);
        if (u2 == null) return false;

        boolean res;

        if (u1.getUsername() == null) res = (u2.getUsername() == null);
        else res = u1.getUsername().equals(u2.getUsername());

        if (u1.getEmail() == null) res = res && (u2.getEmail() == null);
        else res = res && u1.getEmail().equals(u2.getEmail());

        if (u1.getPasswordHash() == null) res = res && (u2.getPasswordHash() == null);
        else res = res && Arrays.equals(u1.getPasswordHash(), u2.getPasswordHash());

        return res;
    }

    public static void printUser(User user) {
        if (user == null) { System.out.println("null"); return;}
        System.out.println(user.getUsername() + " " + user.getEmail() + " " + Arrays.toString(user.getPasswordHash()));
    }
}
