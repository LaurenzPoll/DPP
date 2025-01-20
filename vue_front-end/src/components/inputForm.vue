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

        />
      </div>

      <div class="form-group">
        <label for="batteryIdentification">Battery Identification</label>
        <input
            type="text"
            id="batteryIdentification"
            v-model="formData.batteryIdentification"
            placeholder="Please enter the battery identification"

        />
      </div>

      <div class="form-group">
        <label for="responsibleEconomicOperatorIdentifier">Responsible Economic Operator Identifier</label>
        <input
            type="text"
            id="responsibleEconomicOperatorIdentifier"
            v-model="formData.responsibleEconomicOperatorIdentifier"
            placeholder="Please enter the responsible economic operator identifier"

        />
      </div>

      <div class="form-group">
        <label for="manufacturersIdentification">Manufacturer's Identification</label>
        <input
            type="text"
            id="manufacturersIdentification"
            v-model="formData.manufacturersIdentification"
            placeholder="Please enter the manufacturer's identification"

        />
      </div>

      <div class="form-group">
        <label for="manufacturingPlace">Manufacturing Place</label>
        <input
            type="text"
            id="manufacturingPlace"
            v-model="formData.manufacturingPlace"
            placeholder="Please enter the manufacturing place"

        />
      </div>

      <div class="form-group">
        <label for="manufacturingDate">Manufacturing Date</label>
        <input
            type="month"
            id="manufacturingDate"
            v-model="formData.manufacturingDate"

        />
      </div>

      <div class="form-group">
        <label for="batteryCategory">Battery Category</label>
        <select
            id="batteryCategory"
            v-model="formData.batteryCategory"

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

        />
      </div>

      <div class="form-group">
        <label for="batteryStatus">Battery Status</label>
        <select
            id="batteryStatus"
            v-model="formData.batteryStatus"

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
import { createListItem } from './api/analyzeCompliance.js';
// import axios from "axios";

import analyzeCompliance from './api/analyzeCompliance.js';

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
        batteryCategory: '',
        weight: '',
        batteryStatus: 'Original',
      },
    };
  },
  methods: {
    async submitForm() {
      const dataToSend = { ...this.formData };

      const monthYear = dataToSend.manufacturingDate;
      if (monthYear) {
        const [year, month] = monthYear.split('-');
        dataToSend.manufacturingDate = `${month}/${year}`;
      } else {
        dataToSend.manufacturingDate = null;
      }

      const response = await analyzeCompliance(dataToSend);

      // Navigate to results page with response data
      this.$router.push({
        name: 'QuickScanResults',
        query: { data: JSON.stringify(response) }
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
