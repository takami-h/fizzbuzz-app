package com.redhat.labs.fizzbuzz.application;

/**
 * Fizz Buzz の制約など。
 */
public interface FizzBuzzPolicy {

  /**
   * 整数がFizzBuzzで扱える範囲にあるか判定する。
   * @param i 整数
   * @return 整数がFizzBuzzで扱える範囲のときtrue
   */
  boolean isInValidRange(int i);

  int getMinNumber();

  int getMaxNumber();
}
