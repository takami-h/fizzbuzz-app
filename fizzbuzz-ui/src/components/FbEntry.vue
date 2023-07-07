<script setup lang="ts">
import { reactive } from 'vue';
import { FieldErrors } from '../utils/error';
import { isInteger, isInRange } from '../utils/validations';

type State = {
  newNumber: string,
  errors: FieldErrors
};

const state = reactive<State>({
  newNumber: '',
  errors: new FieldErrors()
});

const emit = defineEmits<{
  (e: 'send', value: string): void
}>();

function validate(): void {
  if (!isInteger(state.newNumber)) {
    state.errors.add('newNumber', '整数を入力してください');
  }
  if (!isInRange(state.newNumber, 1, 100)) {
    state.errors.add('newNumber', '1から100までの範囲で入力してください');
  }
}
async function send(): Promise<void> {
  state.errors.clear();

  validate();
  if (!state.errors.isEmpty()) return;

  emit('send', state.newNumber);
  state.newNumber = '';
}
</script>

<template>
  <form>
    <input type="number" aria-label="your number" v-model="state.newNumber" placeholder="1 to 100" :class="{ invalid: state.errors.contains('newNumber') }" /> <button @click.prevent="send" :disabled="state.newNumber.length <= 0">send</button>
    <ul aria-label="error messages" class="messages error" >
      <li v-for="error in state.errors.errorsOf('newNumber')" :key="error.reason" >{{ error.reason }}</li>
    </ul>
  </form>
</template>

<style scoped>
.invalid {
  border: 1px solid red;
}

.messages {
  font-size: smaller;
  list-style: none;

  margin-top: 0;
  padding: 0;
}
.error {
  color: red;
}
</style>
