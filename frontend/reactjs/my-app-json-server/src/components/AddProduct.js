import { useEffect, useState } from "react";
import { Form, Formik,Field,ErrorMessage } from 'formik';
import axios from 'axios';
import * as Yup from "yup";
import { useParams } from "react-router-dom";

function AddProduct() {

    const productSchema = Yup.object().shape({
        id : Yup.string().required("Id is required"),
        productName : Yup.string().required("Product Name is required"),
        productPrice : Yup.string().required("Product Price is required"),
        mfd : Yup.date().required("Manufacture Date is required"),
        category : Yup.string().required("Product Category is required"),
    }) 

    return (
        <div>
            <h4>Add Product Form</h4>
            <Formik
                initialValues={
                    {
                        id: '',
                        productName: '',
                        productPrice: '',
                        mfd: '',
                        category: ''
                    }
                }
                
                validationSchema={productSchema} 
                
                onSubmit={ values => {
                    axios.post("http://localhost:8000/products", values)
                    .then(resp=>alert("New Product Added"));
                }}
                >

                { ({isSubmitting, isValid, dirty}) => <Form>
                    <div>
                        <label>Id</label>
                        <Field type='text' name="id"/>
                        <ErrorMessage name="id" component="div" />
                    </div>
                    <div>
                        <label>Name</label>
                        <Field type='text' name="productName"/>
                        <ErrorMessage name="productName" component="div" />
                    </div>
                    <div>
                        <label>Price</label>
                        <Field type='number' name="productPrice"/>
                        <ErrorMessage name="productPrice" component="div" />
                    </div>
                    <div>
                        <label>Mfd</label>
                        <Field type='date' name="mfd"/>
                        <ErrorMessage name="mfd" component="div" />
                    </div>
                    <div>
                        <label>Category</label>
                        <Field type='text' name="category"/>
                        <ErrorMessage name="category" component="div" />
                    </div>
                    <button type='submit' disabled={!(dirty && isValid)}>Save</button>
                </Form>
                }
            </Formik>
        </div>
    )
}
export default AddProduct;