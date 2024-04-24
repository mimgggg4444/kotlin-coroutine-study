import { PropsWithChildren, createContext, useContext, useEffect, useState } from "react";
import { 
  onAuthStateChanged,
  getAuth,
  signInWithEmailAndPassword,
  signOut,
  createUserWithEmailAndPassword,
  User,
  UserCredential
} from "firebase/auth";
import { firebaseApp } from "./firebaseApp";

const firebaseAuth = getAuth(firebaseApp)

const firebaseAuthContext = createContext<{
  user: User | null,
  createUser: null | (({email, password}:{email: string, password: string}) => Promise<UserCredential>),
  signIn: null | (({email, password}:{email: string, password: string}) => Promise<UserCredential>),
  signOutUser: null | (() => Promise<void>),
}>({user:null, createUser:null, signIn: null, signOutUser: null})

const FirebaseAuthProvider = ({ children }: PropsWithChildren) => {
  const [user, setUser] = useState< User| null>(null)

  useEffect(() => {
    const unsubscribe = onAuthStateChanged(firebaseAuth,() => {
      if (user) {
        setUser(user)
      } else {
        setUser(null)
      }
    })

    return () => {
      unsubscribe()
    }
  }, [])

  const createUser = ({email, password}:{email: string, password: string}) => {
    return createUserWithEmailAndPassword(firebaseAuth, email, password)
  }
  const signIn = ({email, password}:{email: string, password: string}) => {
    return signInWithEmailAndPassword(firebaseAuth, email, password)
  }
  const signOutUser = () => {
    return signOut(firebaseAuth)
  }

  return (
    <firebaseAuthContext.Provider value={{user, createUser, signIn, signOutUser}}>
      {children}
    </firebaseAuthContext.Provider>
  )
}

const useFirebaseAuth = () => {
  const {user, createUser, signIn, signOutUser} = useContext(firebaseAuthContext)

  return {user, createUser, signIn, signOutUser}
}

export { FirebaseAuthProvider, useFirebaseAuth }