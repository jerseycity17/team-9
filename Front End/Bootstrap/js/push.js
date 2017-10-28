var config = {
    apiKey: "AIzaSyC8NkmJKsy_P4ERtWiBo_hnObKErwfAfpk",
    authDomain: "teamnine-40084.firebaseapp.com",
    databaseURL: "https://teamnine-40084.firebaseio.com/",
    storageBucket: "teamnine-40084.appspot.com",
    messagingSenderId: "1056108808174",
};
firebase.initializeApp(config);
function writeUserData() {
  firebase.database().ref('data/alerts/').set({
    alerts: "TEST ALERT"
  });
};