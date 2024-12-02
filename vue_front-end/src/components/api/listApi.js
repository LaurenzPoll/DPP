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
        // 发送 POST 请求到 /list 端点
        const response = await apiClient.post('/list', data);

        // 返回后端响应的数据
        return response.data;
    } catch (error) {
        // 如果请求失败，抛出错误，方便外部捕获和处理
        throw error;
    }
};

// 默认导出函数，使其可以在其他地方被引用
export default createListItem;
