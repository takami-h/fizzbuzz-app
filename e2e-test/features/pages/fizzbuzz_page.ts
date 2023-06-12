import { Locator, Page } from "@playwright/test";

export class FizzBuzzPage {
  readonly page: Page;
  readonly yourNumberInput: Locator;
  readonly sendButton: Locator;
  readonly latestAnswer: Locator;

  constructor(page: Page) {
    this.page = page;
    this.yourNumberInput = this.page.getByLabel('your number');
    this.sendButton = this.page.getByText('send');
    this.latestAnswer = this.page.getByRole('listitem').nth(0);
  }

  async open() {
    await this.page.goto('http://localhost:5173');
  }
  async send(number: string) {
    await this.yourNumberInput.fill(number);
    await this.sendButton.click();
  }
}