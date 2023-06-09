# Fizz Buzz app

The [Fizz Buzz](https://en.wikipedia.org/wiki/Fizz_buzz) app.

- fizzbuzz-api: Fizz Buzz REST API built with Spring Boot.
- fizzbuzz-ui: Fizz Buzz web frontend built with Vue.
- e2e-test: End-to-end test using Cucumber + Playwright.

## How to build & run.

### fizzbuzz-api

Build and run fizzbuzz-api with JDK 17 & maven.

```
$ cd fizzbuzz-api
$ ./mvnw spring-boot:run
```

### fizzbuzz-ui

Build and run fizzbuzz-ui with Node.js 18 & npm.

```
$ cd fizzbuzz-ui
$ npm install
$ npm run dev
```

open http://localhost:5173 

## How to run tests.

### fizzbuzz-api

Run unit tests and integration tests.

```
$ cd fizzbuzz-api
$ ./mvnw test
```

### fizzbuzz-ui

Run testing-library/vue based integration tests.

```
$ cd fizzbuzz-ui
$ npm run test:unit
```

### e2e-test

Run end-to-end tests.

```
$ cd e2e-test
$ npm install
$ npx playwright install --with-deps chromium
$ npm run test
```

Cucumber test report will be generated as filename `e2e-test-report.html`. The report contains screenshots.
