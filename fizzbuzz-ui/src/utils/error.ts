export type FieldError = {
  name: string,
  reason: string
};

export class FieldErrors {
  readonly errors: FieldError[] = [];

  add(name: string, reason: string): void {
    this.errors.push({name, reason});
  }
  clear(): void {
    this.errors.splice(0);
  }
  size(): number {
    return this.errors.length;
  }
  isEmpty(): boolean {
    return this.size() <= 0;
  }
  contains(field: string): boolean {
    return this.errorsOf(field).length > 0;
  }
  errorsOf(field: string): FieldError[] {
    return this.errors.filter(error => error.name === field);
  }
}
