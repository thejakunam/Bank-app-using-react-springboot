import axios from "axios";
import authHeader from './services/auth-header';

export default axios.create({
  baseURL: "http://localhost:8018/api/bank",
  headers: {
    "Content-type": "application/json",
    "Authorization": authHeader()
  }
});