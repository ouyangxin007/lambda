package com.example;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PeopleTset {
  public static void main(String[] args) {
    List<People> list = getPersonList();
    list.forEach(person -> System.out.println(person.toString()));
    System.out.println("------------------------------------------");

    list.stream().filter(e -> e.getAge() > 20)
            .forEach(e -> System.out.println(e.toString()));
    System.out.println("------------------------------------------");

    Consumer<People> changeAge = e -> e.setAge(e.getAge() + 3);
    list.forEach(changeAge);
    list.forEach(person -> System.out.println(person.toString()));
    System.out.println("------------------------------------------");

    Predicate<People> ageFilter = e -> e.getAge() > 20;
    Predicate<People> sexFilter = e -> e.getSex().equals("male");
    //多条件过滤
    list.stream().filter(ageFilter)
            .filter(sexFilter)
            .forEach(e -> System.out.println(e.toString()));
    System.out.println("------------------------------------------");

    // Predicate : and or
    list.stream().filter(ageFilter.and(sexFilter))
            .forEach(e -> System.out.println(e.toString()));
    System.out.println("------------------------------------------");

    //年龄排序
    list.stream().sorted((p1,p2) -> (p1.getAge() - p2.getAge()))
            .forEach(e -> System.out.println(e.toString()));
    System.out.println("------------------------------------------");

    //姓名排序
    list.stream().sorted(Comparator.comparing(People::getName))
            .forEach(e -> System.out.println(e.toString()));
    System.out.println("------------------------------------------");

    long num = list.parallelStream().filter(x -> x.getAge() < 22).count();
    System.out.println(num);
  }

  static public List<People> getPersonList() {
    People p1 = new People().setName("liu").setAge(22).setSex("male");
    People p2 = new People().setName("zhao").setAge(21).setSex("male");
    People p3 = new People().setName("li").setAge(18).setSex("female");
    People p4 = new People().setName("wang").setAge(21).setSex("female");
    List<People> list = new ArrayList<>();
    list.add(p1);
    list.add(p2);
    list.add(p3);
    list.add(p4);
    return list;
  }



}

