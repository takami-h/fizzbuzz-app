export function isInteger(value: string) {
  const num = Math.floor(Number(value));
  return String(num) === String(value);
}
export function isInRange(value: string, from: number, to: number) {
  const num = Number(value);
  return from <= num && num <= to;
}