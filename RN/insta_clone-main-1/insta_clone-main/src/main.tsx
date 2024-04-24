import React, { useState } from 'react'
import ReactDOM from 'react-dom/client'
import './_styles/index.css'
import Layout from './_layout/layout'
import screen1 from './assets/screenshot1-2x.png'
import screen2 from './assets/screenshot2-2x.png'
import screen3 from './assets/screenshot3-2x.png'
import screen4 from './assets/screenshot4-2x.png'
import ImgRotator from './_hooks/useImage'
import appStore from './assets/appStore.png'
import googlePlay from './assets/googlePlay.png'
import { FirebaseAuthProvider } from './_firebase/firebaseAuthContext'

const root = ReactDOM.createRoot(document.getElementById('root')!)

const imgs = [screen1, screen2, screen3, screen4]

const HomePage = () => {
  const [login, setLogin] = useState(true)

  return (
    <div className='container mx-auto mt-8'>
          <div className='w-full h-[695px] mx-auto flex items-stretch justify-center pb-8'>
          <div id='phone-rotator'>
            <div id='phone-rotator-container'>
             <ImgRotator images={imgs}/>
             
            </div>
          </div>
          <div className=' max-w-[350px] flex flex-col justify-center mt-3'>
            <div className='border-2 border-gray-300  text-center mb-3 py-3'>
              <div className=' mt-9 mb-3'>
                <div className={`bg-[url('/ATdtiLb2BQ9.png')] bg-no-repeat bg-[length:176px_181px] dark:bg-[center_-3.25rem] h-[51px] w-[175px] mx-auto`} ></div>
              </div>
              {login ? 
              <div className='flex flex-col w-[350px]'>
                <div className=' mt-2 mb-4 px-3'>
                You can log into these account because they're in your Accounts Center
                </div>
                <div className='w-full p-4'>
                  <hr />
                  <div className='pt-3'>
                  <div className='flex mt-3'>
                    <span className="material-symbols-outlined  grid place-content-center">
                    account_circle
                    </span>
                    <p className='pl-3 grid place-content-center'>demo@richkevan.com</p>
                    <button 
                    className=' w-[72.5px] h-[32px] ml-auto bg-blue-500 text-white px-2 rounded-md'
                    onClick={() => {console.log("Logged In")}}>Log in</button>
                  </div>
                  </div>
                  <div className='h-8 flex mt-3'></div>
                  <div className='h-8 flex mt-3'></div>
                </div>
              </div>:
              <div className='flex flex-col w-[350px]'>
                <form className='flex flex-col mt-6'>
                  <input type='email' placeholder='email' className=' mx-10 mb-2 border-2 border-gray-300 rounded-md p-1'/>
                  <input type='password' placeholder='password' className='mx-10 mb-2 border-2 border-gray-300 rounded-md p-1'/>
                  <button className='mx-10 my-2  bg-blue-500 text-white px-2 rounded-md px-4 py-1'>Log in</button>
                  <div className='grid grid-cols-3 items-center mx-10 mt-3 mb-5'>
                    <hr/>
                    <p>OR</p>
                    <hr/>
                  </div>
                  <div className=' text-sm mx-10 my-2'>Log in with Facebook</div>
                  <div className=' text-xs mt-3'>Forgot password?</div>
                </form>
              </div>
              }
            </div>
            <div className='border-2 border-gray-300 mb-3 pb-3 pt-3'>
              {login ? <div className='m-4 text-center'>
              <span className=' cursor-pointer' onClick={() => {
                setLogin(!login)
                }}>Switch accounts</span> or Sign Up
              </div>:
              <div className='m-4 text-center'>
                Don't have an account? <a href='/signup' className='text-blue-500 font-semibold'>Sign Up</a>
              </div>
              }
            </div>
            <div className='text-center'>
              <div className=' mx-5 my-3'>
              Get the app.
              </div>         
              <div className='flex justify-center my-3'>
                <img src={appStore} alt='appStore' className='inline-block w-[135px] h-[40px] mx-1'/>
                <img src={googlePlay} alt='googlePlay' className='inline-block w-[135px] h-[40px] mx-1'/>
              </div>
            </div>
          </div>
          </div>
          
          
        </div>
  )
}
root.render(
    <React.StrictMode>
      <FirebaseAuthProvider>
      <Layout >
        <HomePage />
      </Layout>
      </FirebaseAuthProvider>
    </React.StrictMode>,
  )

