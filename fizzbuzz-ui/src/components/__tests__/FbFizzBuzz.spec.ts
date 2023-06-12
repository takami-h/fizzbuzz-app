import '@testing-library/jest-dom';
import { render, screen, within } from '@testing-library/vue';
import userEvent from '@testing-library/user-event';
import { rest } from 'msw';
import { setupServer } from 'msw/node';

import FbFizzBuzz from '../FbFizzBuzz.vue';

describe('App', () => {
  const server = setupServer();
  beforeAll(() => server.listen());
  afterEach(() => server.restoreHandlers());
  afterAll(() => server.close());

  it('should be Fizz if 3', async () => {
    server.use(
      rest.get(
        'http://localhost:8080/fizzbuzz/3',
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
});