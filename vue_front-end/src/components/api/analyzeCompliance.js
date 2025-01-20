import axios from 'axios';

// Create a pre-configured Axios instance for API communication
const apiClient = axios.create({

    baseURL: 'http://localhost:8090', // Backend API base URL
    headers: {
        'Content-Type': 'application/json',  // Set headers to indicate JSON data format
    }
});

/**
 * Sends data for compliance analysis, including data cleaning, scoring, and gap analysis.
 * @param {Object} data - The data object to be processed.
 * @returns {Promise<Object>} - The compliance results including score and gaps.
 * @throws {Error} - Throws an error if the request fails.
 */
export const analyzeCompliance = async (data) => {
    try {
        const response = await apiClient.post('/test/validate', data);

        // Ensure the backend response contains expected fields
        if (!response.data || typeof response.data !== 'object') {
            throw new Error('Invalid response format from backend');
        }
        return response.data;
    } catch (error) {
        throw error;
    }
};

// Export the function as default for easy import elsewhere
export default analyzeCompliance;
