<template>
  <div class="battery-form">
    <h2>Battery Passport Identification</h2>

    <form @submit.prevent="submitForm">
      <!-- 电池护照标识 -->
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

      <!-- 电池标识 -->
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

      <!-- 负责经济运营者标识 -->
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

      <!-- 制造商标识 -->
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

      <!-- 制造地点 -->
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

      <!-- 制造日期 -->
      <div class="form-group">
        <label for="manufacturingDate">Manufacturing Date</label>
        <input
            type="month"
            id="manufacturingDate"
            v-model="formData.manufacturingDate"
            required
        />
      </div>

      <!-- 电池类别 -->
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

      <!-- 重量 -->
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

      <!-- 电池状态 -->
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

      <!-- 提交按钮 -->
      <div class="form-group">
        <button type="submit">submit</button>
      </div>
    </form>
  </div>
</template>

<script>
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
    // 校验重量输入是否为数字
    validateWeight(event) {
      const regex = /^[0-9]+(\.[0-9]{1,2})?$/;  // 允许整数或小数（最多两位）
      if (!regex.test(event.target.value)) {
        event.target.setCustomValidity('please enter a number');
      } else {
        event.target.setCustomValidity('');
      }
    },
    submitForm() {
      // 提交表单
      console.log('提交的数据:', this.formData);
      alert('表单已提交');
      // Perform any HTTP request (e.g., via axios/fetch) to "/test/validate" here
      // axios.post("/test/validate", this.formData)...
    },
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
