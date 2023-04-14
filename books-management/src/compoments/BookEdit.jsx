import React, {  useEffect, useState } from 'react'
import {Form, Formik, Field, ErrorMessage} from 'formik'
import * as BookService from './service/BookService'
import { useNavigate, useParams } from 'react-router-dom'
import Swal from 'sweetalert2'
import * as Yup from 'yup'

export default function BookEdit() {
    const [type, setType] = useState([])
    const [book, setBook] = useState()
    const param  = useParams()
    const navigate = useNavigate()


    const findId = async(id) =>{
        let res = await BookService.findById(id)
        setBook(res)
    }

    useEffect(() =>{
        findId(param.id)
    }, [param.id])


    const listType = async() =>{
        let res  = await BookService.getAllType()
        setType(res)
    }
    useEffect(() =>{
        
        listType()
    },[])

    if(!book){
        return null
    } 
    

  return (
    <>
    <h1>Book Edit</h1>
    <Formik initialValues={{idName: book.idName , name: book.name, typeId: book.typeBook, day: book.day, soLuong: book.soLuong}}
            validationSchema={Yup.object({
                idName: Yup.string().required('Không được để trống'),
                name: Yup.string().required('Không được để trống'),
                soLuong: Yup.number().required('Không được để trống').max(20, 'Không được quá 20 sách')

            })}
       
        onSubmit={(values ) =>{
            // if(typeof values === 'string'){
            //     values.typeId = parseInt(values.typeId)
            // }
               const edit = async () =>{
                await BookService.saveEdit(values)
                navigate("/")
                setBook(values)
                Swal.fire(
                    'Good job!',
                    'You clicked the button!',
                    'success'
                  )
               
                  return values 
              
               } 
               edit()

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

