package com.redhat.labs.fizzbuzz.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {
  private FizzBuzz fizzbuzz;

  @BeforeEach void setup() {
    fizzbuzz = new FizzBuzz();
  }

  @Test void fizzbuzzShouldReturnNumber() {
    assertThat(fizzbuzz.fizzbuzz(1)).isEqualTo("1");
    assertThat(fizzbuzz.fizzbuzz(2)).isEqualTo("2");
    assertThat(fizzbuzz.fizzbuzz(4)).isEqualTo("4");
  }

  @Test void fizzbuzzShouldReturnFizz() {
    assertThat(fizzbuzz.fizzbuzz(3)).isEqualTo("Fizz");
    assertThat(fizzbuzz.fizzbuzz(3*2)).isEqualTo("Fizz");
    assertThat(fizzbuzz.fizzbuzz(3*3)).isEqualTo("Fizz");
  }

  @Test void fizzbuzzShouldReturnBuzz() {
    assertThat(fizzbuzz.fizzbuzz(5)).isEqualTo("Buzz");
    assertThat(fizzbuzz.fizzbuzz(5*2)).isEqualTo("Buzz");
    assertThat(fizzbuzz.fizzbuzz(5*4)).isEqualTo("Buzz");
  }

  @Test void fizzbuzzShouldReturnFizzBuzz() {
    assertThat(fizzbuzz.fizzbuzz(3*5)).isEqualTo("Fizz Buzz");
    assertThat(fizzbuzz.fizzbuzz(3*5*2)).isEqualTo("Fizz Buzz");
    assertThat(fizzbuzz.fizzbuzz(3*5*3)).isEqualTo("Fizz Buzz");
  }

  @Test void fizzbuzzShouldThrowException() {
    assertThatThrownBy(() -> fizzbuzz.fizzbuzz(0), "fizzbuzz only handle integer 1 - 100")
      .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> fizzbuzz.fizzbuzz(101))
      .isInstanceOf(IllegalArgumentException.class);
  }
}
