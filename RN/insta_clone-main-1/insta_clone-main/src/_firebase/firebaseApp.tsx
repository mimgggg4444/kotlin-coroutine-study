import {initializeApp} from "firebase/app"
import { getAnalytics } from "firebase/analytics"

const firebaseConfig = {
  apiKey: import.meta.env.VITE_APIKEY,
  appId: import.meta.env.VITE_APPID,
  authDomain: import.meta.env.VITE_AUTHDOMAIN,
  databaseURL: import.meta.env.VITE_DATABASEURL,
  projectId: import.meta.env.VITE_PROJECTID,
  storageBucket: import.meta.env.VITE_STORAGEBUCKET,
  messagingSenderId: import.meta.env.VITE_MESSAGINGSENDERID,
}

const firebaseApp = initializeApp(firebaseConfig)
const firebaseAnalytics = getAnalytics(firebaseApp)

export {firebaseApp, firebaseAnalytics}