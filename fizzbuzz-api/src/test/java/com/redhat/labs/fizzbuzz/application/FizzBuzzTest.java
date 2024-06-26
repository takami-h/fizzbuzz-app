package com.redhat.labs.fizzbuzz.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import com.redhat.labs.fizzbuzz.adapter.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FizzBuzzTest {
  private FizzBuzz fizzbuzz;

  @BeforeEach void setup() {
    var policy = new AppConfig();
    policy.setMinNumber(1);
    policy.setMaxNumber(100);

    fizzbuzz = new FizzBuzz(policy);
  }

  @Test void fizzbuzzShouldReturnNumber() {
    assertThat(fizzbuzz.fizzbuzz(1)).isEqualTo("1");
    assertThat(fizzbuzz.fizzbuzz(2)).isEqualTo("2");
    assertThat(fizzbuzz.fizzbuzz(4)).isEqualTo("4");
  }

  @Test void fizzbuzzShouldReturnFizz() {
    assertThat(fizzbuzz.fizzbuzz(3)).isEqualTo("Fizz");
    assertThat(fizzbuzz.fizzbuzz(3 * 2)).isEqualTo("Fizz");
    assertThat(fizzbuzz.fizzbuzz(3 * 3)).isEqualTo("Fizz");
  }

  @Test void fizzbuzzShouldReturnBuzz() {
    assertThat(fizzbuzz.fizzbuzz(5)).isEqualTo("Buzz");
    assertThat(fizzbuzz.fizzbuzz(5 * 2)).isEqualTo("Buzz");
    assertThat(fizzbuzz.fizzbuzz(5 * 4)).isEqualTo("Buzz");
  }

  @Test void fizzbuzzShouldReturnFizzBuzz() {
    assertThat(fizzbuzz.fizzbuzz(3 * 5)).isEqualTo("Fizz Buzz");
    assertThat(fizzbuzz.fizzbuzz(3 * 5 * 2)).isEqualTo("Fizz Buzz");
    assertThat(fizzbuzz.fizzbuzz(3 * 5 * 3)).isEqualTo("Fizz Buzz");
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
      arguments(3 * 5, "Fizz Buzz")
    );
  }

  @Test void fizzbuzzShouldThrowException() {
    assertThatThrownBy(() -> fizzbuzz.fizzbuzz(0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("fizzbuzz only accepts integer 1 ... 100");
    assertThatThrownBy(() -> fizzbuzz.fizzbuzz(101))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Disabled("不適切なアサーションのデモ")
  @Test void useCorrectAssertion1() {
    var expected = LocalDateTime.of(2023, 12, 31, 10, 0, 0);
    var actual = LocalDateTime.now();
    
    assertThat(actual.equals(expected))
      .as("適切なアサーションを使わないと、エラーの時にわかりづらい。せめて description 等でエラー時の情報を補強すること。actual = %s", actual)
      .isTrue();
  }
  @Disabled("適切なアサーションのデモ")
  @Test void useCorrectAssertion2() {
    var expected = LocalDateTime.of(2023, 12, 31, 10, 0, 0);
    var actual = LocalDateTime.now();
    
    assertThat(actual)
      .as("エラーの情報が詳しく出る")
      .isEqualTo(expected);
  }
}
