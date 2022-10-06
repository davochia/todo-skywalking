<template>
  <form @submit="onSubmit" class="add-form">
    <div class="form-control">
      <label>Title</label>
      <input type="text" v-model="title" name="text" placeholder="Add Title" />
    </div>
    <div class="form-control">
      <label for="description">Description</label>
      <textarea
        type="text"
        id="description"
        rows="5"
        placeholder="Description for the appointment"
        v-model="description"
      ></textarea>
    </div>
    <div class="form-control">
      <label>Day & Time</label>
      <input
        type="datetime-local"
        v-model="day"
        name="day"
        placeholder="Add Day & Time"
      />
    </div>
    <div class="form-control form-control-check">
      <label>Set Reminder</label>
      <input type="checkbox" v-model="reminder" name="reminder" />
    </div>

    <input type="submit" value="Save Todo" class="btn btn-block" />
  </form>
</template>

<script>
export default {
  name: "AddTodo",
  data() {
    return {
      title: "",
      description: "",
      day: "",
      reminder: false,
    };
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
      if (!this.title) {
        alert("Please add a title");
        return;
      } else if (!this.description) {
        alert("Please add a description");
        return;
      }
      const newTodo = {
        title: this.title,
        description: this.description,
        day: this.day,
        reminder: this.reminder,
      };
      this.$emit("add-todo", newTodo);
      (this.title = ""), (this.description = ""), (this.day = "");
      this.reminder = false;
    },
  },
};
</script>

<style scoped>
.add-form {
  margin-bottom: 40px;
}
.form-control {
  margin: 20px 0;
}
.form-control label {
  display: block;
}
.form-control input,
textarea {
  width: 100%;
  height: 40px;
  margin: 5px;
  padding: 3px 7px;
  font-size: 17px;
}
.form-control-check {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.form-control-check label {
  flex: 1;
}
.form-control-check input {
  flex: 2;
  height: 20px;
}
</style>
