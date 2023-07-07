import { isInteger, isInRange } from '../validations';

describe('error', () => {
  describe('isInteger', () => {
    it('should be true if integer', () => {
      expect(isInteger('1')).toBeTruthy();
      expect(isInteger('-1')).toBeTruthy();
    });
    it('should be false if not integer', () => {
      expect(isInteger('0.1')).toBeFalsy();
      expect(isInteger('100.1')).toBeFalsy();
    });
  });
  describe('isInRange', () => {
    it('should be true if in range', () => {
      expect(isInRange('1', 1, 100)).toBeTruthy();
      expect(isInRange('-1', -1, 0)).toBeTruthy();
    });
    it('should be false if not in range', () => {
      expect(isInRange('0.9', 1, 100)).toBeFalsy();
      expect(isInRange('100.1', 1, 100)).toBeFalsy();
    });
  });
});