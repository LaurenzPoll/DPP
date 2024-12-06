<template>
  <div id="app">
    <h1>DPP Readiness Report</h1>
    <table border="1">
      <thead>
      <tr>
        <!-- 修改这里，正确引用 columns -->
        <th v-for="column in report['General Information'].columns" :key="column">{{ column }}</th>
      </tr>
      </thead>
      <tbody>
      <!-- 修改这里，正确引用 rows -->
      <tr v-for="(row, index) in report['General Information'].rows" :key="index">
        <td>{{ row.Field }}</td>
        <td>{{ row['Requirement Level'] }}</td>
        <td>{{ row.Compliance }}</td>
        <td>{{ row.Input }}</td>
        <td>{{ row.Gap }}</td>
      </tr>
      </tbody>
    </table>
    <p><strong>Overall Readiness Level:</strong> {{ report['General Information'].overall_readiness_level }}</p>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      // JSON 模板数据
      report: {
        "General Information": {
          "overall_readiness_level": "50%",
          "columns": [
            "Field",
            "Requirement Level",
            "Compliance",
            "Input",
            "Gap"
          ],
          "rows": [
            {
              "Field": "Battery Passport Identification",
              "Requirement Level": "Mandatory",
              "Compliance": "Not Compliant",
              "Input": "Not provided",
              "Gap": "Field not provided"
            },
            {
              "Field": "Battery Identification",
              "Requirement Level": "Mandatory",
              "Compliance": "Compliant",
              "Input": "Unique ID: BAT-12345",
              "Gap": "None"
            },
            {
              "Field": "Responsible Economic Operator Identifier",
              "Requirement Level": "Mandatory",
              "Compliance": "Partially Compliant",
              "Input": "Identifiers available for 70% of operators",
              "Gap": "Some operators lack unique identifiers."
            },
            {
              "Field": "Manufacturer's Identification",
              "Requirement Level": "Mandatory",
              "Compliance": "Compliant",
              "Input": "Manufacturer ID: MANU-67890",
              "Gap": "None"
            },
            {
              "Field": "Manufacturing Place (manufacturing facility geographical location)",
              "Requirement Level": "Mandatory",
              "Compliance": "Not Compliant",
              "Input": "Not provided",
              "Gap": "Field not provided"
            },
            {
              "Field": "Manufacturing Date (month and year)",
              "Requirement Level": "Mandatory",
              "Compliance": "Not Compliant",
              "Input": "Not provided",
              "Gap": "Field not provided"
            },
            {
              "Field": "Battery category",
              "Requirement Level": "Mandatory",
              "Compliance": "Compliant",
              "Input": "original",
              "Gap": "None"
            },
            {
              "Field": "Weight",
              "Requirement Level": "Voluntary",
              "Compliance": "Compliant",
              "Input": "No weight data recorded",
              "Gap": "None"
            },
            {
              "Field": "Battery Status",
              "Requirement Level": "Mandatory",
              "Compliance": "Not Compliant",
              "Input": "Status field left blank",
              "Gap": "Field not provided"
            }
          ]
        }
      }
    };
  }
};
</script>

<style>
/* 添加简单的样式 */
table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  padding: 8px;
  text-align: left;
}

th {
  background-color: #f4f4f4;
}
</style>
