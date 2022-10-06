<template>
  <header>
    <h1>{{ title }}</h1>
    <AppButton
      v-show="homePage"
      @btn-click="$emit('toggle-add-todo')"
      :text="showAddTodo ? 'Close' : 'Add Tod'"
      :color="showAddTodo ? 'red' : 'green'"
    />
  </header>
</template>

<script>
import AppButton from "./Button";
export default {
  name: "AppHeader",
  props: {
    title: String,
    showAddTodo: Boolean,
  },
  components: {
    AppButton,
  },
  computed: {
    homePage() {
      if (this.$route.path === "/") {
        return true;
      } else {
        return false;
      }
    },
  },
};
</script>

<style scoped>
header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}
</style>
