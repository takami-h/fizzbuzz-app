package com.redhat.labs.fizzbuzz.application;

/**
 * Fizz Buzz の制約など。
 */
public interface FizzBuzzPolicy {

  int getMinNumber();

  int getMaxNumber();
}
