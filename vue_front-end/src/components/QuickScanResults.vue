<template>
  <div class="quick-scan-result">
    <!-- 顶部标识行 -->
    <header class="header">
      <span class="title">DPP</span>
    </header>

    <!-- 导航栏 -->
    <nav class="navigation">
      <ul>
        <li>Battery Base Information</li>
        <li>Battery Recycle and Reuse</li>
        <li>Battery Safety and Sustainability</li>
      </ul>
    </nav>

    <!-- 内容区域 -->
    <section class="content">
<!--      <div class="battery-info">-->
<!--        &lt;!&ndash; 电池容量、电压、电池功率标签 &ndash;&gt;-->
<!--        <div class="battery-stat">-->
<!--          <div class="stat-label">Battery Capacity</div>-->
<!--          <div class="bar-chart">-->
<!--            <div class="bar" :style="{ height: `${batteryCapacityPercentage}%` }"></div>-->
<!--          </div>-->
<!--        </div>-->

<!--        <div class="battery-stat">-->
<!--          <div class="stat-label">Battery Voltage</div>-->
<!--          <div class="bar-chart">-->
<!--            <div class="bar" :style="{ height: `${batteryVoltagePercentage}%` }"></div>-->
<!--          </div>-->
<!--        </div>-->

<!--        <div class="battery-stat">-->
<!--          <div class="stat-label">Battery Power</div>-->
<!--          <div class="bar-chart">-->
<!--            <div class="bar" :style="{ height: `${batteryPowerPercentage}%` }"></div>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->

      <!-- 文本域 -->
      <div class="text-area">
        <textarea v-model="textAreaValue" placeholder="Enter additional information..."></textarea>
        <div class="icons">
          <i @click="refreshData" class="icon-refresh">🔄</i>
          <i @click="clearText" class="icon-delete">❌</i>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
// export default {
//   data() {
//     return {
//       // 模拟数据，可以根据需求更新
//       batteryCapacity: 4500,  // 电池容量
//       standardCapacity: 5000, // 标准电池容量
//       batteryVoltage: 3.7,    // 电池电压
//       batteryPower: 15,       // 电池功率
//       textAreaValue: "",      // 文本域内容
//
//       // 计算百分比（用于柱状图的高度）
//       batteryCapacityPercentage: 90, // 假设实际为4500，标准为5000，所以90%
//       batteryVoltagePercentage: 80,  // 假设电压值
//       batteryPowerPercentage: 70,    // 假设功率值
//     };
//   },
//   methods: {
//     refreshData() {
//       console.log("Refreshing data...");
//       // 实现刷新数据的逻辑
//     },
//     clearText() {
//       this.textAreaValue = "";
//       console.log("Text cleared.");
//     }
//   }
//};
</script>

<style scoped>
.quick-scan-result {
  font-family: Arial, sans-serif;
}

.header {
  background-color: black;
  color: white;
  padding: 20px;
  text-align: center;
  font-size: 2em;
}

.navigation {
  background-color: #f0f0f0;
  padding: 10px 0;
  text-align: center;
}

.navigation ul {
  list-style: none;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
}

.navigation ul li {
  margin: 0 20px;
  cursor: pointer;
  font-weight: bold;
}

.content {
  padding: 20px;
}

.battery-info {
  display: flex;
  justify-content: space-around;
  margin-bottom: 30px;
}

.battery-stat {
  width: 30%;
  text-align: center;
}

.stat-label {
  font-weight: bold;
  margin-bottom: 10px;
}

.bar-chart {
  width: 100%;
  height: 200px;
  background-color: #e0e0e0;
  position: relative;
  border-radius: 5px;
}

.bar {
  width: 100%;
  background-color: #4caf50;
  position: absolute;
  bottom: 0;
  transition: height 0.5s;
}

.text-area {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.text-area textarea {
  width: 80%;
  height: 100px;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
}

.icons {
  display: flex;
  gap: 10px;
}

.icon-refresh, .icon-delete {
  cursor: pointer;
  font-size: 1.5em;
}
</style>
