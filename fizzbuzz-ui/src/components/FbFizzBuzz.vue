<script setup lang="ts">
import { reactive } from 'vue';

import { fizzbuzz } from '../api/fizzbuzz';
import type { Log } from './FbLogs.vue';

import FbInput from './FbEntry.vue';
import FbLog from './FbLogs.vue';

type State = {
  logs: Log[]
};

const state = reactive<State>({
  logs: []
});

function saveLog(message: string, type: 'number' | 'answer'): void {
  const nextId = state.logs.length;
  state.logs.push({id: nextId, type, message});
}
async function handleSend(input: string) {
  saveLog(input, 'number');

  const answer = await fizzbuzz(input);
  saveLog(answer, 'answer');
}
</script>

<template>
  <FbInput @send="handleSend" />
  <FbLog :logs="state.logs" />
</template>

<style scoped>
</style>
