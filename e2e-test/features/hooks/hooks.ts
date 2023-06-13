import { After, AfterAll, Before, BeforeAll, World } from "@cucumber/cucumber";
import { Browser, BrowserContext, Page, chromium } from "@playwright/test";
import { FizzBuzzPage } from "../pages/fizzbuzz_page";

export type FbWorld = World & {
  context: BrowserContext,
  page: Page,
  fizzbuzz: FizzBuzzPage
};

let browser: Browser;

BeforeAll(async function() {
  browser = await chromium.launch({
    // headless: false,
    // slowMo: 1000 // milliseconds
  });
});
AfterAll(async function() {
  browser.close();
});

Before(async function(this: FbWorld) {
  this.context = await browser.newContext({
    baseURL: 'http://localhost:5173'
  });
  this.page = await this.context.newPage();
  this.fizzbuzz = new FizzBuzzPage(this.page);
});
After(async function(this: FbWorld) {
  const buffer = await this.page.screenshot();
  this.attach(buffer, 'image/png');
  await this.context.close();
});
