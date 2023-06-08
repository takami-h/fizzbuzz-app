import { Given, When, Then } from '@cucumber/cucumber';

Given('Fizz Buzzを始める', function() {
  // 画面を開く
  return 'pending';
});

When('{int} を指定する', function(number: number) {
  // numberを入力してsend押す
  return 'pending';
});

Then('{string} が返る', function(answer: string) {
  // ログの先頭にanswerが書かれている
  return 'pending';
});