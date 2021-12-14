import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });
  

export default {

  account() {
    return http.get('/account')
  },

  activeBooks(childId) {
    return http.get('/account/'+ childId + '/active-books')
  },

  bookLogs() {
    return http.get('/account/logs')
  },

  library() {
    return http.get('/account/library')
  },

  postBookLog(bookLog) {
    return http.post('/add-log', bookLog)
  },

  addActiveBook(activeBook) {
    return http.post('/add-active-book', activeBook)
  },

  deleteActiveBook(activeBook) {
    return http.delete('/delete-active-book', {data: activeBook});
  },

  addChild(child) {
    return http.post('/account/add-child', child)
  },

  getChild(childId) {
    return http.get('/account/get-child/' + childId)
  }
}
