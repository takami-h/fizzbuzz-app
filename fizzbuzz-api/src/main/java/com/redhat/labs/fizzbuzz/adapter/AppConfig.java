package com.redhat.labs.fizzbuzz.adapter;

import com.redhat.labs.fizzbuzz.application.FizzBuzzPolicy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * アプリケーションの設定。
 */
@Configuration
@ConfigurationProperties("com.redhat.labs.fizzbuzz")
public class AppConfig implements FizzBuzzPolicy {
  private int minNumber;
  private int maxNumber;

  @Override
  public boolean isInValidRange(int i) {
    return getMinNumber() <= i && i <= getMaxNumber();
  }

  public int getMinNumber() {
    return minNumber;
  }

  public void setMinNumber(int minNumber) {
    this.minNumber = minNumber;
  }

  public int getMaxNumber() {
    return maxNumber;
  }

  public void setMaxNumber(int maxNumber) {
    this.maxNumber = maxNumber;
  }
}
