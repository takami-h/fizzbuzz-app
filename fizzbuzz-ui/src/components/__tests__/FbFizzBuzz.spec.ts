import '@testing-library/jest-dom';
import { render, screen } from '@testing-library/vue';
import userEvent from '@testing-library/user-event';
import { rest } from 'msw';
import { setupServer } from 'msw/node';

import { API_BASE_URL } from '../../config';
import FbFizzBuzz from '../FbFizzBuzz.vue';

describe('App', () => {
  const server = setupServer();
  beforeAll(() => server.listen());
  afterEach(() => server.resetHandlers());
  afterAll(() => server.close());

  it('should be Fizz if 3', async () => {
    server.use(
      rest.get(
        `${API_BASE_URL}/fizzbuzz/3`,
        (req, res, ctx) => res(ctx.text('Fizz'))
      )
    );
    const user = userEvent.setup();

    render(FbFizzBuzz);

    await user.type(screen.getByLabelText('your number'), '3');
    await user.click(screen.getByText('send'));

    // number sent by user should be displayed.
    expect(screen.getAllByRole('listitem')[1]).toHaveTextContent('3');
    // fizzbuzz api response should be displayed
    expect(screen.getAllByRole('listitem')[0]).toHaveTextContent('Fizz');
  });

  it('should list errors if invaild input', async () => {
    const user = userEvent.setup();

    render(FbFizzBuzz);

    await user.type(screen.getByLabelText('your number'), '0.9');
    await user.click(screen.getByText('send'));

    expect(screen.getByText('整数を入力してください')).toBeVisible();
    expect(screen.getByText('1から100までの範囲で入力してください')).toBeVisible();
  });
});