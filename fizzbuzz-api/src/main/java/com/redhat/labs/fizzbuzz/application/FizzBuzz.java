package com.redhat.labs.fizzbuzz.application;

import org.springframework.stereotype.Component;

@Component
public class FizzBuzz {

  private static final int MIN = 0;
  private static final int MAX = 100;

  public String fizzbuzz(int i) {
    if (i <= MIN || i > MAX) {
      throw new IllegalArgumentException("fizzbuzz only accepts integer 1 ... 100");
    }

    if (divisibleBy3(i) && divisibleBy5(i)) {
      return "Fizz Buzz";
    } else if (divisibleBy3(i)) {
      return "Fizz";
    } else if (divisibleBy5(i)) {
      return "Buzz";
    } else {
      return String.valueOf(i);
    }
  }

  private boolean divisibleBy5(int i) {
    return i % 5 == 0;
  }

  private boolean divisibleBy3(int i) {
    return i % 3 == 0;
  }
  
}
