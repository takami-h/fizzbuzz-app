package com.redhat.labs.fizzbuzz.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

  @ParameterizedTest
  @MethodSource("fizzbuzzProvider")
  void fizzbuzzTest(int i, String expectedReturn) {
    assertThat(fizzbuzz.fizzbuzz(i)).isEqualTo(expectedReturn);
  }
  static Stream<Arguments> fizzbuzzProvider() {
    return Stream.of(
      arguments(1, "1"),
      arguments(3, "Fizz"),
      arguments(5, "Buzz"),
      arguments(3*5, "Fizz Buzz")
    );
  }

  @Test void fizzbuzzShouldThrowException() {
    assertThatThrownBy(() -> fizzbuzz.fizzbuzz(0))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("fizzbuzz only accepts integer 1 ... 100");
    assertThatThrownBy(() -> fizzbuzz.fizzbuzz(101))
      .isInstanceOf(IllegalArgumentException.class);
  }
}
