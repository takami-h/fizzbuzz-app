package com.redhat.labs.fizzbuzz.adapter;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.labs.fizzbuzz.application.FizzBuzz;

@CrossOrigin
@RestController
public class FizzBuzzController {
  private FizzBuzz fizzbuzz;

  public FizzBuzzController(FizzBuzz fizzbuzz) {
    this.fizzbuzz = fizzbuzz;
  }

  @GetMapping(value = "/fizzbuzz/{number}", produces = { MediaType.TEXT_PLAIN_VALUE })
  public ResponseEntity<String> fizzbuzz(@PathVariable("number") Integer number) {
    try {
      var result = fizzbuzz.fizzbuzz(number);
      return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
