import React, { useEffect, useState } from 'react'
import * as BookService from './service/BookService'
import { NavLink, useNavigate } from 'react-router-dom'
import ReactPaginate from 'react-paginate';
import { Field, Form, Formik } from 'formik';
// import {Swal} from 'sweetalert2'



export default function Book() {
    let navigate = useNavigate()
    const [book, setBook] = useState([])
    const [type, setType] = useState([])
    const [deleteId, setDeleteId] = useState(0)
    const [deleteName, setDeleteName] = useState('')
    // const [pageCount, setPageCount] = useState(0);
    // const [currentPage, setCurrentPage] = useState(0);


    const listBook = async () => {
        let result = await BookService.getAll()
        setBook(result)
        return book
        // setPageCount(Math.ceil(result.length / 3));



    }
    const swapDelete = (id, name) =>{
        setDeleteId(id)
        setDeleteName(name)
    } 
    const handleDelete = async(deleteId) =>{
        await BookService.remove(deleteId)
    }
    const listType = async () => {
        let result = await BookService.getAllType()

        return setType(result)
    }
    useEffect(() => {
        listType()
        listBook()
    }, [])


    // const handlePageClick = (selectedPage) => {
    //     setCurrentPage(selectedPage.selected);
    //   };




    return (
        <>
            <Formik
                initialValues={{ name: '', typeBook: '' }}
                onSubmit={(values) => {
                    const searchNametype = async () => {
                        const res = await BookService.getAll(values.name, values.typeBook)
                        setBook(res)

                    }
                    searchNametype()
                }}
            >


                <Form>
                    <div>
                        <label >Tên sách</label>
                        <Field name='name' type='text' />
                    </div>
                    <div>
                        <label >Chọn sách </label>

                        <Field as='select' name='typeId'>
                            <option value="">-----------</option>
                            {
                                type.map((typeList, i) => (
                                    <option key={i} value={typeList.id}>{typeList.name}</option>
                                ))
                            }
                        </Field>
                    </div>

                    <div>
                        <button type='submit'>Search</button>
                    </div>




                </Form>
            </Formik>


            <div>
                <NavLink to='/create'>
                    <button style={{ color: "red" }} >Create</button>
                </NavLink>

            </div>
            <div className="container-fluid" style={{ width: '100%' }}>
                <table width='100%' border={1} align='center' className='table table-dark'>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>mã Sách</th>
                            <th>Tên Sách</th>
                            <th>Thể Loại</th>
                            <th>Ngày nhập sách</th>
                            <th>Số lượng</th>
                            <th>Edit</th>
                            <th>Delete</th>

                        </tr>
                    </thead>
                    <tbody>
                        {
                            book
                                // .slice(currentPage * 3, currentPage * 3+3)
                                ?.map((bookList, index) => (
                                    <tr key={index}>
                                        <td>{++index}</td>
                                        <td>{bookList.idName}</td>
                                        <td>{bookList.name}</td>
                                        <td>{
                                            type.filter((typeList) => (typeList?.id == bookList?.typeBook))[0]?.name

                                        }</td>
                                        <td>{bookList.day}</td>
                                        <td>{bookList.soLuong}</td>
                                        <td>
                                            <NavLink to={`/edit/${bookList.id}`}>
                                                Edit
                                            </NavLink>
                                        </td>
                                        <td>
                                            <button onClick={() =>swapDelete(bookList.id, bookList.name)} type="button" className="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                                delete
                                            </button>
                                        </td>

                                    </tr>


                                )
                                )

                        }
                    </tbody>
                </table>
                <div className="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div className="modal-body">
                                <p>Ban co that su mua xoa <span style={{ color: 'red' }}>{deleteName}</span> khong</p>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button onClick={() =>handleDelete(deleteId)} data-bs-dismiss="modal" type="button"  className="btn btn-primary">Delete</button>
                            </div>
                        </div>
                    </div>
                </div>
                {/* <ReactPaginate
                    previousLabel={'previous'}
                    nextLabel={'next'}
                    breakLabel={'...'}
                    pageCount={pageCount}
                    marginPagesDisplayed={2}
                    pageRangeDisplayed={5}
                    onPageChange={handlePageClick}
                    containerClassName={'pagination'}
                    activeClassName={'active'}
                /> */}



            </div>



        </>


    )
}
