import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });
  

export default {

  account() {
    return http.get('/account')
  },

  activeBooks(childId) {
    return http.get('/account/:childId/active-books', {params: {child: childId}})
  },

  // bookLogs() {
  //   return http.get('/account/:childId')
  // },

  library() {
    return http.get('/account/library')
  },

  // readingHistory() {
  //   return http.post('/book-log')
  // }




}
