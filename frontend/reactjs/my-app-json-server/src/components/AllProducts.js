import { useEffect, useState } from 'react';
import { Form, Formik, Field, ErrorMessage } from 'formik';
import axios from 'axios';
import AddProduct from './AddProduct';
import EditProduct from './EditProduct';

function AllProducts() {
    const [products, setProducts] = useState([]);

    const [isEdit, setIsEdit] = useState(false);
    const [pid, setPid] = useState('');
   
    // useEffect(() => {
    //     axios.get("http://localhost:8000/products").then(resp => setProducts(resp.data));
    // }, [])

    const handleDelete = (id) => {
        axios.delete("http://localhost:8000/products/" + id)
            .then(resp => alert("Product Deleted"));
    }

    const handleEdit = (id) => {
        setIsEdit(true);
        setPid(id);
    }

    return (
        <div>
            {
                !isEdit ? <AddProduct/> : <EditProduct pid = {pid}/>
            }           
            <h3>All Products</h3>
            {
                // products.map(p => <div>
                //     <p>{p.id} {p.productName} {p.productPrice} {p.mfd} {p.category} 
                //         {/* <button>Edit</button>  */}
                //         {/* <button onClick={()=>handleDelete(p.id)}>Delete</button> */}
                //     </p>
                // </div>)
            }
            <Formik
                initialValues={
                    { productName: '' }
                }
                onSubmit={values => {                   
                    axios.get("http://localhost:8000/products?productName=" + values.productName)
                        .then(resp =>setProducts(resp.data));
                }}
            >
                {({ isSubmitting }) => <Form>
                    <div>
                        <label>Name</label>
                        <Field type='text' name="productName" />
                        <ErrorMessage name="productName" component="div" />
                    </div>
                    <button type='submit'>Search</button>
                </Form>
                }
            </Formik>

            {
                products.length > 0 &&
                products.map(p => <div>
                    <p>{p.id} {p.productName} {p.productPrice} {p.mfd} {p.category} 
                        <button onClick={()=>handleEdit(p.id)}>Edit</button> 
                        <button onClick={()=>handleDelete(p.id)}>Delete</button>
                    </p>
                </div>)
            }
        </div>
    )
}

export default AllProducts;