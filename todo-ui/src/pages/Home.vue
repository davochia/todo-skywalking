<template>
  <AddTodo v-show="showAddTodo" @add-todo="addTodo" />
  <AppTodos
    @toggle-reminder="toggleReminder"
    @delete-todo="deleteTodo"
    :todos="todos"
  />
</template>

<script>
import AppTodos from "../components/Todos";
import AddTodo from "../components/AddTodo";

export default {
  name: "AppHome",
  props: {
    showAddTodo: Boolean,
  },
  components: {
    AppTodos,
    AddTodo,
  },
  data() {
    return {
      todos: [],
    };
  },
  methods: {
    async addTodo(todo) {
      const res = await fetch("http://localhost:9500/api/todos", {
        method: "POST",
        headers: {
          "Content-type": "application/json",
        },
        body: JSON.stringify(todo),
      });
      const data = await res.json();

      this.todos = [...this.todos, data];
    },
    async deleteTodo(id) {
      if (confirm("Are you sure?")) {
        const res = await fetch(`http://localhost:9500/api/todos/${id}`, {
          method: "DELETE",
        });
        res.status === 200
          ? (this.todos = this.todos.filter((todo) => todo.id !== id))
          : alert("Error deleting todo");
      }
    },
    async toggleReminder(id) {
      const todoToToggle = await this.fetchTask(id);
      const updateTodo = { ...todoToToggle, reminder: !todoToToggle.reminder };
      const res = await fetch(`http://localhost:9500/api/todos/${id}`, {
        method: "PUT",
        headers: {
          "Content-type": "application/json",
        },
        body: JSON.stringify(updateTodo),
      });
      const data = await res.json();
      this.todos = this.todos.map((todo) =>
        todo.id === id ? { ...todo, reminder: data.reminder } : todo
      );
    },
    async fetchTodos() {
      const res = await fetch("http://localhost:9500/api/todos");
      const data = await res.json();
      return data;
    },
    async fetchTask(id) {
      const res = await fetch(`http://localhost:9500/api/todos/${id}`);
      const data = await res.json();

      return data;
    },
  },
  async created() {
    this.todos = await this.fetchTodos();
  },
};
</script>
