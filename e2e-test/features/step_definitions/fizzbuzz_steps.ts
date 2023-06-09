import { Given, When, Then } from '@cucumber/cucumber';
import { expect } from '@playwright/test';
import type { FbWorld } from '../hooks/hooks';

Given('Fizz Buzzを始める', async function(this: FbWorld) {
  await this.fizzbuzz.open();
});

When('{string} を指定する', async function(this: FbWorld, number: string) {
  await this.fizzbuzz.send(number);
});

Then('{string} が返る', async function(this: FbWorld, answer: string) {
  await expect(this.fizzbuzz.latestAnswer).toHaveText(answer);
});
