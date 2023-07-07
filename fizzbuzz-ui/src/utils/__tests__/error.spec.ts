import { FieldErrors } from '../error';

describe('error', () => {
  describe('FieldErrors', () => {
    it('should add multiple errors', () => {
      const errors = new FieldErrors();
      errors.add('name', 'too long');
      errors.add('name', 'accepts alphabet only');
      errors.add('age', 'should be positive integer');

      expect(errors.isEmpty()).toBeFalsy();
      expect(errors.size()).toBe(3);
      expect(errors.contains('name')).toBeTruthy();
      expect(errors.contains('belongsTo')).toBeFalsy();
      expect(errors.errorsOf('name').length).toBe(2);
    });
  });
});