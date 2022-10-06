<template>
  <div :key="todo.id" v-for="todo in todos">
    <AppTodo
      @toggle-reminder="$emit('toggle-reminder', todo.id)"
      @delete-todo="$emit('delete-todo', todo.id)"
      :todo="todo"
    />
  </div>
</template>

<script>
import AppTodo from "./Todo";

export default {
  name: "AppTodos",
  props: {
    todos: Array,
  },
  components: {
    AppTodo,
  },
  emits: ["delete-todo", "toggle-reminder"],
};
</script>
