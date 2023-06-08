<script setup lang="ts">
import { reactive } from 'vue';

type State = {
  newNumber: string
};

const state = reactive<State>({
  newNumber: ''
});

const emit = defineEmits<{
  (e: 'send', value: string): void
}>();

async function send() {
  emit('send', state.newNumber);
  state.newNumber = '';
}
</script>

<template>
  <form>
    <input type="number" aria-label="your number" v-model="state.newNumber" placeholder="1 to 100" /> <button @click.prevent="send" :disabled="state.newNumber.length <= 0">send</button>
  </form>
</template>

<style scoped>
</style>
