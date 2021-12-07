import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });
  

export default {

  account() {
    return http.get('/account')
  },

  book() {
    return http.get('/account/:child_id')
  }


}
