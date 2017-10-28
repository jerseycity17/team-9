// Initialize Firebase
// TODO: Replace with your project's customized code snippet
var config = {
    apiKey: "AIzaSyC8NkmJKsy_P4ERtWiBo_hnObKErwfAfpk",
    authDomain: "teamnine-40084.firebaseapp.com",
    databaseURL: "https://teamnine-40084.firebaseio.com/",
    storageBucket: "teamnine-40084.appspot.com",
    messagingSenderId: "1056108808174",
};
firebase.initializeApp(config);
var database = firebase.database();
firebase.initializeApp(config);
function writeUserData() {
  firebase.database().ref('users/' + userId).set({
    alerts: "TEST ALERT"
  });
}