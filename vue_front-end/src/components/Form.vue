<template>


  <div>
    <form @submit.prevent="handleSubmit" method="post">


      <label for="myDateTime">Select a date and time:</label>
      <input type="datetime-local" id="myDateTime" name="myDateTime">
      <br>


      <input type="file" id="file" name="file" @change="handleFileChange" />

      <br>



      <h2>battery design</h2>


      <ul>

        <li>Hazardous substances
          <br>
          <label>Hg</label>
          <input type="text" placeholder="Please fill in the content percentage (by weight)" style="width: 300px; height: 20px;">

          <br>
          <label>Cd</label>
          <input type="text" placeholder="Please fill in the content percentage (by weight)" style="width: 300px; height: 20px;">

          <br>
          <label>Pb</label>
          <input type="text" placeholder="Please fill in the content percentage (by weight)" style="width: 300px; height: 20px;">
        </li>

        <br>

        <li>Performance and durability
          <br>

          <label>Rated capacity</label>
          <input type="text" style="width: 400px; height: 20px;" placeholder="Expressed in ampere-hours (Ah) or milliampere-hours (mAh)">

          <br>

          <label>Capacity retention after storage</label>
          <input type="text" style="width: 300px; height: 20px;" placeholder="Please input a percentage">
          <br>
          <i>
            <font size="2" style = "color:#ff0000;">* Capacity retention rate = C2/C1×100%, where C1 is the standard capacity of the battery and C2 is the discharge capacity after storage.
            </font>
          </i>
          <br>


          <label>Cycle life</label>
          <input type="text" style="width: 300px; height: 20px;" placeholder="Please fill in the number of cycle life">

          <br>
          <i>
            <font size="2" style = "color:#ff0000;">* The charge and discharge current is 1C (full charge and discharge), the test environment temperature is 25°C, and the number of cycles is 1000 times
            </font>
          </i>
          <br>


          <label>Leak-proof performance</label>

          <input type="radio" id="优秀" name="drone" value="优秀" checked>
          <label for="优秀">perfect</label>
          <input type="radio" id="良好" name="drone" value="良好">
          <label for="良好">good</label>
          <input type="radio" id="中等" name="drone" value="中等">
          <label for="中等">medium</label>
          <input type="radio" id="及格" name="drone" value="及格">
          <label for="及格">pass</label>

        </li>

        <li>Removability and replaceability</li>
        <input type="radio" id="是" name="drone1" value="是" checked>
        <label for="是">yes</label>

        <input type="radio" id="否" name="drone1" value="否">
        <label for="否">no</label>


        <li>Labels and logos</li>
        <input type="radio" id="是1" name="label" value="是" checked>
        <label for="是1">yes</label>

        <input type="radio" id="否1" name="label" value="否">
        <label for="否1">no</label>


      </ul>


      <h2>battery lifecycle</h2>
      <!--
      1、SOC（State of charge）为电池荷电状态，常用来表示电池剩余电量。
      2、SOH（State of health）为电池健康状态，常用来表示电池的剩余电量。
      3、SOP（State of power）是电池功率状态，通常用短时最高功率值来表示。
      -->

      <span style="color:red;margin-right:4px">*</span>
      <span>SOC</span>
      <span><input type="text" style="width: 300px; height: 20px;" placeholder="Please input the remaining battery power" required="required"> </span>
      <br>

      <span style="color:red;margin-right:4px">*</span>
      <span>SOH</span>
      <span><input type="text" style="width: 300px; height: 20px;" placeholder="Please input the remaining battery power"></span>
      <br>

      <span style="color:red;margin-right:4px">*</span>
      <span>SOP</span>
      <span><input type="text" style="width: 300px; height: 20px;" placeholder="Please input the short-term maximum power value"> </span>
      <br>

      <!-- 锂离子电池的磷酸锂材料主要有钴酸锂、锰酸锂、镍酸锂、三元材料、磷酸铁锂等 -->
      <br>
      <fieldset>
        <legend style="font-size: 22px;">Choose your battery material:</legend>

        <div>
          <input type="checkbox" id="scales" name="scales" checked />
          <label for="scales">LiCoO2</label>
        </div>

        <div>
          <input type="checkbox" id="horns" name="horns" />
          <label for="horns">LiMn2O4</label>
        </div>

        <div>
          <input type="checkbox" id="horns2" name="horns" />
          <label for="horns">LiNiO2</label>
        </div>

        <div>
          <input type="checkbox" id="horns3" name="horns" />
          <label for="horns">Ni-Co-Mn composite compound</label>
        </div>

        <div>
          <input type="checkbox" id="horns4" name="horns" />
          <label for="horns">LiFePO4</label>
        </div>



      </fieldset>

      <button type="submit">Send your message</button>
      <button type="reset">Reset</button>
    </form>



    <!-- 错误和成功消息显示 -->
    <div v-if="errorMessage" class="error">{{ errorMessage }}</div>
    <div v-if="successMessage" class="success">{{ successMessage }}</div>

  </div>
</template>

<script>

import { createListItem } from './api/listApi.js';  // 引入 API 模块

export default {
  name: "FormPage",
  data() {
    return {
      formData: {
        dateTime: '',
        photoVideo: null,
        hg: '',
        cd: '',
        pb: '',
        soc: '',
        soh: '',
        sop: '',
        materials: []
      },
      errorMessage: null,
      successMessage: null
    };
  },
  methods: {
    async handleSubmit() {
      try {
        // 调用 API 模块的 createListItem 函数，提交表单数据
        const response = await createListItem(this.formData);
        // 请求成功后的处理逻辑
        this.successMessage = 'Form submitted successfully!';
        this.errorMessage = null;
        console.log('Response from backend:', response);
      } catch (error) {
        // 请求失败后的处理逻辑
        this.errorMessage = 'An error occurred while submitting the form.';
        this.successMessage = null;
        console.error('Error:', error.message);
      }
    }
  }
};

</script>

<style scoped>

form {
  /* 居中表单 */
  margin: 0 auto;
  width: 800px;
  /* 显示表单的轮廓 */
  padding: 1em;
  border: 3px solid #ccc;
  border-radius: 3em;

}

input {
  margin: 0.7rem;
}

button {
  position: relative;
  background-color:dodgerblue;
  border:2px solid #008cba;
  border-radius:8px;
  font-size: 18px;
  color:beige;
  padding: 10px 20px;
  margin: 4px 2px;
  text-align: center;
  -webkit-transition-duration: 0.4s;
  transition-duration: 0.4s;
  text-decoration: none;
  overflow: hidden;
  cursor: pointer;
}


/* 错误和成功消息的样式 */
.error {
  color: red;
}

.success {
  color: green;
}

</style>

