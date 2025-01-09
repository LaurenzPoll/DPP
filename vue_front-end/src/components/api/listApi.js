import axios from 'axios';

// 创建一个配置好的 Axios 实例
const apiClient = axios.create({

    baseURL: 'http://localhost:8090', // 这里是你的后端 API 基本 URL
    headers: {
        'Content-Type': 'application/json',  // 设置请求头，告诉服务器我们发送的是 JSON 格式的数据
    }
});

// 定义一个函数，用于向后端发送 POST 请求
export const createListItem = async (data) => {
    try {
        const response = await apiClient.post('/list', data);
        return response.data;  // Zorg ervoor dat de backend een veld "validated" en "data" terugstuurt
    } catch (error) {
        throw error;
    }
};

// 默认导出函数，使其可以在其他地方被引用
export default createListItem;
