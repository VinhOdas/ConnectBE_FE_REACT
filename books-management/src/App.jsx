import { useState } from 'react'
import Book from './compoments/Book'
import './App.css'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import BookAdd from './compoments/BookAdd'
import BookEdit from './compoments/BookEdit'


function App() {

  return (
    <>
    <BrowserRouter>
    <Routes>
      <Route path='/' element={<Book/>} />
      <Route path='/create' element={<BookAdd/>} />
      <Route path='/edit/:id' element={<BookEdit/>} />
      </Routes>
    </BrowserRouter>

    </>
  )
}

export default App
