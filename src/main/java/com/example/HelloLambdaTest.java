package com.example;

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
    new Thread( () -> System.out.println("java8 lambda实现线程")).start();

  }


}

