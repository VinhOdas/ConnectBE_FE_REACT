import axios from 'axios'

export const getAll = async (name = "" , typeId= "" ) =>{
        try {
            let result  = await axios.get(`http://localhost:8080/book?name_like=${name}&typeId_like=${typeId}` )
            return result.data
        } catch (error) {
            
        }
}

export const getAllType = async () =>{
    try {
        let result  = axios.get(`http://localhost:8080/typeBook`)
        return (await result).data
    } catch (error) {
        console.log(error);
        
    }
}

export const save = async (values) =>{
    try {
        await axios.post(`http://localhost:8080/book/create/`, {...values})
        return values
    } catch (error) {
        console.log(error);
    }
}

export const saveEdit = async (values) =>{
    try {
        await axios.put(`http://localhost:8080/book/edit/${values.id}`, {...values})
        return values
    } catch (error) {
        console.log(error);
    }
}

export const findById = async (id) =>{
    try {
        await axios.get(`http://localhost:8080/book/${id}`)
        return values
    } catch (error) {
        console.log(error);
    }
}




export const remove = async(id) =>{
    try {
         await axios.delete(`http://localhost:8080/book/delete/${id}`)
    } catch (error) {
        console.log(error);
        
    }
}


