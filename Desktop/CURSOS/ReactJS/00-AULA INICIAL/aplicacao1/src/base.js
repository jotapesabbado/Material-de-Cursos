const config = {
    apiKey: "AIzaSyBNVyi0EyriKXbH-iBNj0cPdfILxXPSpDw",
    authDomain: "mercadodev-195d2.firebaseapp.com",
    databaseURL: "https://mercadodev-195d2.firebaseio.com",
    projectId: "mercadodev-195d2",
    storageBucket: "gs://mercadodev-195d2.appspot.com",
    messagingSenderId: "715825302744"
  }

  const Rebase = require('re-base')
  const firebase = require('firebase/app')
  require('firebase/database')
  require('firebase/storage')

  const app = firebase.initializeApp(config)
  const base = Rebase.createClass(app.database())

  export const storage = app.storage()

  export default base

