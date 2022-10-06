<template>
  <div
    @dblclick="$emit('toggle-reminder', todo.id)"
    :class="[todo.reminder ? 'reminder' : '', 'todo']"
  >
    <h3>
      Title: {{ firstupper(todo.title) }}
      <i @click="$emit('delete-todo', todo.id)" class="bi bi-trash"></i>
    </h3>
    <p>Description: {{ todo.description }}</p>
    <p>When: {{ formatDate(todo.day) }}</p>
  </div>
</template>

<script>
export default {
  name: "AppTodo",
  props: {
    todo: Object,
  },
  methods: {
    /**
     *
     * @param {*} dateString Date ISO string to format
     * @returns formated date
     */
    formatDate(dateString) {
      const date = new Date(dateString);

      return new Intl.DateTimeFormat("default", {
        dateStyle: "full",
        timeStyle: "long",
      }).format(date);
    },

    firstupper(wordString) {
      if (this.todo) {
        return wordString.charAt(0).toUpperCase() + wordString.slice(1);
      }
    },
  },
};
</script>

<style scope>
.bi {
  color: red;
}
.todo {
  background: #f4f4f4;
  margin: 5px;
  padding: 10px 20px;
  cursor: pointer;
}
.todo.reminder {
  border-left: 5px solid green;
}
.todo h3 {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
</style>
