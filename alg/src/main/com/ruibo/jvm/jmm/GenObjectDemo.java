package com.ruibo.jvm.jmm;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GenObjectDemo {

    public static void main(String[] args) throws InterruptedException {
        int counter = 10000;
        List<Person> personList = new LinkedList<>();
        while (counter > 0) {
            Thread.sleep(1000);
            personList.add(new Person(new Random().nextInt() + "", new Random().nextInt() + ""));
            counter--;
        }

    }


    public static class Person {
        private String id;
        private String name;

        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
