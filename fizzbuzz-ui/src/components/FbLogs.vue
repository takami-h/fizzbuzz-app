<script setup lang="ts">
export type Log = {
  id: number,
  type: 'number' | 'answer',
  message: string
};

defineProps<{
  logs: Log[]
}>();
</script>

<template>
  <ul class="logs">
    <li v-for="(log, index) in logs.slice().reverse()" :key="log.id" class="log-entry" :class="log.type" :aria-label="`${index === 0 ? 'latest' : ''} ${log.type}`">{{ log.message }}</li>
  </ul>
</template>

<style scoped>
.logs {
  list-style: none;
  padding: 0;
  width: 20rem;
}
.log-entry {
  padding: 0.3rem 1rem;
  margin: 0.3rem;
  width: 6rem;
  border-radius: 0.3rem;
}
.number {
  background-color: #c8dfff;
  text-align: left;
}
.answer {
  background-color: #eee;
  text-align: right;
  margin-left: auto;
  margin-right: 0;
}
</style>
