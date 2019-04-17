package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HelloLambdaTest {
    public static void main(String[] args) {
        //old
        new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类 实现线程");
            }
        })).start();
        //lambda
        new Thread(() -> System.out.println("java8 lambda实现线程")).start();


        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

// 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }
        System.out.print("-------------------------------------------------------");
// 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));

// 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }


}

