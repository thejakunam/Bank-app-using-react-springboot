import http from "../http-common";
import authHeader from './auth-header';

class BankAppDataService {
  getAccount(username) {
    return http.get("/accounts?username="+username);
  }
  getBalance(username) {
      return http.get("/balance?username="+username);
  }
  getUserinfo(username) {
      return http.get("/userinfo?username="+username);
  }
}

export default new BankAppDataService();