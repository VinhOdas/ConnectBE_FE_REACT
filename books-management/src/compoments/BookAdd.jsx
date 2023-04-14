import React, {  useEffect, useState } from 'react'
import {Form, Formik, Field, ErrorMessage} from 'formik'
import * as BookService from './service/BookService'
import { useNavigate } from 'react-router-dom'
import Swal from 'sweetalert2'
import * as Yup from 'yup'

export default function BookAdd() {

    // const [bookAdd, setBookAdd] = useState([])
    const [type, setType] = useState([])
    const navigate = useNavigate()

    useEffect(() =>{
        const listType = async() =>{
            let res  = await BookService.getAllType()
            setType(res)
        }
        listType()
    },[])
    
  return (

    <>
     <h1>Book Add</h1>
    <Formik initialValues={{idName: '' , name: '', typeBook: '', day:'', soLuong: ''}}
            validationSchema={Yup.object({
                // idName: Yup.string().required('Không được để trống'),
                // name: Yup.string().required('Không được để trống'),
                // soLuong: Yup.number().required('Không được để trống').max(20, 'Không được quá 20 sách')

            })}
       
        onSubmit={(values ) =>{
            // if(typeof values === 'string'){
            //     values.typeId = parseInt(values.typeId)
            // }
               const addBook = async () =>{
                await BookService.save(values)
                navigate("/")
              
                Swal.fire(
                    'Good job!',
                    'You clicked the button!',
                    'success'
                  )
               
                  return values 
              
               } 
               addBook()

        }}

    >
       
        <Form style={{background: 'whitesmoke'}} >
            <div>
                <div>
                <label htmlFor="idName">mã sách</label>
                </div>
                <div>
                <Field type='text' name='idName' id='idName' />
                </div>
               
                <ErrorMessage name='idName'  component='span' />
            </div>
            
            <div>
                <div>
                <label htmlFor="name">tên sách</label>
                </div>
                <div>
                <Field type='text' name='name' id='name' />
                </div>
                <ErrorMessage name='name' component='span' />

            </div>
            <div>
                <div>
                <label htmlFor="day">ngày nhập sách</label>

                </div>
                <Field type='date' name='day' id='day' />
                
            </div>
            <div>
                <div>
                <label htmlFor="soLuong">số lượng</label>

                </div>
                <div>
                <Field type='number' name='soLuong' id='soLuong' />

                </div>
                <ErrorMessage name='soLuong'  component='span' />

            </div>
            <div>
                <div>
                <label htmlFor="typeId">Type</label>

                </div>
                <Field name='typeBook' id='typeId' as='select' >
                <>
                         <option value="luachon">
                         ---------------
                         </option>
                    {
                        type.map((typeList, i) =>(
                             <option key={i} value={typeList.id}>
                                 {typeList.name}
                             </option>
                          
                        ))
                        
                    }
                    </>
                </Field>
            </div>
            {
             <button type='submit'>Add</button>
            }

        
        </Form>
        


    </Formik>
        
    </>
  )
}
