<template>
  <div class="battery-form">
    <h2>Battery Passport Identification</h2>

    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="batteryPassportIdentification">Battery Passport Identification</label>
        <input
            type="text"
            id="batteryPassportIdentification"
            v-model="formData.batteryPassportIdentification"
            placeholder="Please enter the battery passport identification"
            required
        />
      </div>

      <div class="form-group">
        <label for="batteryIdentification">Battery Identification</label>
        <input
            type="text"
            id="batteryIdentification"
            v-model="formData.batteryIdentification"
            placeholder="Please enter the battery identification"
            required
        />
      </div>

      <div class="form-group">
        <label for="responsibleEconomicOperatorIdentifier">Responsible Economic Operator Identifier</label>
        <input
            type="text"
            id="responsibleEconomicOperatorIdentifier"
            v-model="formData.responsibleEconomicOperatorIdentifier"
            placeholder="Please enter the responsible economic operator identifier"
            required
        />
      </div>

      <div class="form-group">
        <label for="manufacturersIdentification">Manufacturer's Identification</label>
        <input
            type="text"
            id="manufacturersIdentification"
            v-model="formData.manufacturersIdentification"
            placeholder="Please enter the manufacturer's identification"
            required
        />
      </div>

      <div class="form-group">
        <label for="manufacturingPlace">Manufacturing Place</label>
        <input
            type="text"
            id="manufacturingPlace"
            v-model="formData.manufacturingPlace"
            placeholder="Please enter the manufacturing place"
            required
        />
      </div>

      <div class="form-group">
        <label for="manufacturingDate">Manufacturing Date</label>
        <input
            type="month"
            id="manufacturingDate"
            v-model="formData.manufacturingDate"
            required
        />
      </div>

      <div class="form-group">
        <label for="batteryCategory">Battery Category</label>
        <select
            id="batteryCategory"
            v-model="formData.batteryCategory"
            required
        >
          <option value="Stationary">Stationary</option>
          <option value="Battery Energy Storage System">Battery Energy Storage System</option>
          <option value="Industrial Battery">Industrial Battery</option>
          <option value="LMT Battery">LMT Battery</option>
          <option value="Electric Vehicle Battery">Electric Vehicle Battery</option>
        </select>
      </div>

      <div class="form-group">
        <label for="weight">Weight/kg</label>
        <input
            type="text"
            id="weight"
            v-model="formData.weight"
            placeholder="Please enter the Weight"
            @input="validateWeight"
            required
        />
      </div>

      <div class="form-group">
        <label for="batteryStatus">Battery Status</label>
        <select
            id="batteryStatus"
            v-model="formData.batteryStatus"
            required
        >
          <option value="Original">Original</option>
          <option value="Repurposed">Repurposed</option>
          <option value="Reused">Reused</option>
          <option value="Remanufactured">Remanufactured</option>
          <option value="Waste">Waste</option>
        </select>
      </div>

      <div class="form-group">
        <button type="submit">Submit</button>
      </div>
    </form>
  </div>
</template>

<script>
import { createListItem } from './api/listApi.js';
import axios from "axios";

export default {
  data() {
    return {
      formData: {
        batteryPassportIdentification: '',
        batteryIdentification: '',
        responsibleEconomicOperatorIdentifier: '',
        manufacturersIdentification: '',
        manufacturingPlace: '',
        manufacturingDate: '',
        batteryCategory: 'Stationary',
        weight: '',
        batteryStatus: 'Original',
      },
    };
  },
  methods: {
    submitForm() {
      const monthYear = this.formData.manufacturingDate;
      if (monthYear) {
        const [year, month] = monthYear.split('-');
        this.formData.manufacturingDate = `${month}/${year}`;
      }

      axios.post('http://localhost:8090/test/validate', this.formData)
          .then(response => {
            this.$router.push({
              name: 'QuickScanResults',
              query: {data: JSON.stringify(response.data)}
            });
          })
          .catch(error => {
            alert('Error submitting form');
          });
    }
  },
};
</script>

<style scoped>
.battery-form {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
}

.form-group {
  margin-bottom: 1rem;
}

label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: bold;
}

input[type="text"],
input[type="month"],
select {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 10px 15px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
</style>
