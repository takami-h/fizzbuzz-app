import { API_BASE_URL } from '../config';

export async function fizzbuzz(number: string): Promise<string> {
  try {
    const response = await fetch(`${API_BASE_URL}/fizzbuzz/${number}`);
    if (response.status >= 400) {
      return Promise.resolve('ERROR');
    } else {
      return await response.text();
    }
  } catch (error) {
    return Promise.resolve('ERROR');
  }
}
