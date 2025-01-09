<template>
  <div class="quick-scan-result">
    <!-- Header with title -->
    <header class="header">
      <span class="title">DPP Compliance Report</span>
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
      <!-- Check if data is available -->
      <div v-if="gapReportRows.length === 0 && !dppReadinessReport">
        <p>No data available to display.</p>
      </div>

      <!-- Display overall readiness level -->
      <div v-if="dppReadinessReport && dppReadinessReport['General Information']">
        <h2>Overall Readiness Level: {{ dppReadinessReport['General Information'].overall_readiness_level }}</h2>
      </div>

      <!-- Render the table with data -->
      <table v-else class="gap-report">
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
          <!-- Icon buttons for clearing text -->
          <i @click="clearText" class="icon-delete">❌</i>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dppReadinessReport: null, // This will hold the fetched data from the query parameter
      textAreaValue: '', // For the text area value
    };
  },
  computed: {
    gapReportRows() {
      // We will only access rows if the data is fully available
      if (this.dppReadinessReport && this.dppReadinessReport.dpp_readiness_report) {
        const rows = this.dppReadinessReport.dpp_readiness_report['General Information']?.rows || [];

        // Return rows with fallback for missing fields
        return rows.map(row => {
          return {
            ...row,
            'Requirement Level': row['Requirement Level'] || 'N/A',
            'Gap': row.Gap || 'None'
          };
        });
      }
      return [];
    }
  },
  methods: {
    clearText() {
      this.textAreaValue = '';
    }
  },
  mounted() {
    try {
      if (this.$route.query.data) {
        // Parse the data from the query parameter
        this.dppReadinessReport = JSON.parse(this.$route.query.data);
      } else {
        alert('No data available to display.');
      }
    } catch (error) {
      alert('An error occurred while loading the data.');
    }
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

.icon-delete {
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

@media (max-width: 768px) {
  .gap-report th, .gap-report td {
    padding: 5px;
  }

  .text-area textarea {
    width: 100%;
  }
}
</style>
