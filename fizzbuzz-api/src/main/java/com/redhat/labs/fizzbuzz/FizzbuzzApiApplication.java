package com.redhat.labs.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Bootのmainクラス。
 */
@SpringBootApplication
@SuppressWarnings("PMD")
public class FizzbuzzApiApplication {
  /**
   * Spring Bootのエントリーポイント。
   * 
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {
    SpringApplication.run(FizzbuzzApiApplication.class, args);
  }

}
