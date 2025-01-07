<template>
  <div class="form-page">
    <h2>Fill out the form</h2>
    <p>Please fill out the form below for a quick scan.</p>
  </div>
</template>

<script>
import { createListItem } from './api/listApi.js'; 

export default {
  name: 'FormPage',
};
</script>

<style scoped>
.form-page {
  padding: 20px;
  text-align: center;
}

input {
  margin: 0.7rem;
}

button {
  position: relative;
  background-color: dodgerblue;
  border: 2px solid #008cba;
  border-radius: 8px;
  font-size: 18px;
  color: beige;
  padding: 10px 20px;
  margin: 4px 2px;
  text-align: center;
  -webkit-transition-duration: 0.4s;
  transition-duration: 0.4s;
  text-decoration: none;
  overflow: hidden;
  cursor: pointer;
}


.error {
  color: red;
}

.success {
  color: green;
}
</style>
