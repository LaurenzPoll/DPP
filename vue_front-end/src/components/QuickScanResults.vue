<template>
  <div class="quick-scan-result">
    <!-- Header with title -->
    <header class="header">
      <span class="title">DPP</span>
    </header>

    <!-- Navigation bar -->
    <nav class="navigation">
      <ul>
        <li>Battery Base Information</li>
        <li>Battery Recycle and Reuse</li>
        <li>Battery Safety and Sustainability</li>
      </ul>
    </nav>

    <!-- Content area where the GAP report table is rendered -->
    <section class="content">
      <!-- Table to display GAP report -->
      <table class="gap-report">
        <thead>
        <tr>
          <th>Field</th>
          <th>Requirement Level</th>
          <th>Compliance</th>
          <th>Input</th>
          <th>Gap</th>
        </tr>
        </thead>
        <tbody>
        <!-- Loop through each row of data and display in table -->
        <tr v-for="(row, index) in gapReportRows" :key="index">
          <td>{{ row.Field }}</td>
          <td>{{ row['Requirement Level'] }}</td>
          <td>{{ row.Compliance }}</td>
          <td>{{ row.Input }}</td>
          <td>{{ row.Gap }}</td>
        </tr>
        </tbody>
      </table>

      <!-- Text area for additional information -->
      <div class="text-area">
        <textarea v-model="textAreaValue" placeholder="Enter additional information..."></textarea>
        <div class="icons">
          <!-- Icon buttons for refreshing data and clearing text -->
          <i @click="refreshData" class="icon-refresh">🔄</i>
          <i @click="clearText" class="icon-delete">❌</i>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      dppReadinessReport: null, // This will hold the fetched data
      textAreaValue: '', // For the text area value
    };
  },
  computed: {
    gapReportRows() {
      return this.dppReadinessReport?.["General Information"]?.rows || [];
    }
  },
  methods: {
    // Fetch data from the API
    async fetchData() {
      try {
        const response = await axios.get('http://localhost:8090/your-endpoint'); // Replace with your actual endpoint
        this.dppReadinessReport = response.data; // Store the fetched data
      } catch (error) {
        console.error('Error fetching data:', error);
        // Fallback to example JSON if the request fails
        this.dppReadinessReport = {
          "General Information": {
            "overall_readiness_level": "50%",
            "columns": ["Field", "Requirement Level", "Compliance", "Input", "Gap"],
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
                "Field": "Manufacturing Place",
                "Requirement Level": "Mandatory",
                "Compliance": "Not Compliant",
                "Input": "Not provided",
                "Gap": "Field not provided"
              },
              {
                "Field": "Manufacturing Date",
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
        };
      }
    },

    // Method to refresh data
    refreshData() {
      console.log('Refreshing data...');
      this.fetchData(); // Call the fetchData method again to refresh
    },

    // Method to clear the text area
    clearText() {
      this.textAreaValue = '';
    }
  },
  mounted() {
    this.fetchData(); // Fetch data when the component is mounted
  }
};
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

.text-area {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 20px;
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

/* Style for the GAP report table */
.gap-report {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

.gap-report th, .gap-report td {
  border: 1px solid #ccc;
  padding: 10px;
  text-align: left;
}

.gap-report th {
  background-color: #f5f5f5;
}
</style>
