import { useEffect, useState } from "react";
import { Formik, Field, Form, ErrorMessage } from "formik";
import axios from 'axios';

function EditProduct({ pid }) {

    const [product, setProduct] = useState(null);

    useEffect(() => {
        axios.get("http://localhost:8000/products/" + pid)
            .then(resp => {
                setProduct(resp.data);
            });
    }, [pid]);

    return (
        <div>
            <h3>Edit Product Form</h3>
            {
                product !== null &&
                <Formik
                    initialValues={
                        {
                            id: product.id,
                            productName: product.productName,
                            productPrice: product.productPrice,
                            mfd: product.mfd,
                            category: product.category
                        }
                    }
                    onSubmit={values => {
                        //api call
                        axios.put("http://localhost:8000/products/"+values.id, values)
                            .then(resp => {
                                alert("Product Updated!");
                            });
                    }}
                >
                    {({ isSubmitting, isValid, dirty }) => <Form>
                        <div>
                            <label>Id</label>
                            <Field type='text' name="id" />
                            <ErrorMessage name="id" component="div" />
                        </div>
                        <div>
                            <label>Name</label>
                            <Field type='text' name="productName" />
                            <ErrorMessage name="productName" component="div" />
                        </div>
                        <div>
                            <label>Price</label>
                            <Field type='number' name="productPrice" />
                            <ErrorMessage name="productPrice" component="div" />
                        </div>
                        <div>
                            <label>Mfd</label>
                            <Field type='date' name="mfd" />
                            <ErrorMessage name="mfd" component="div" />
                        </div>
                        <div>
                            <label>Category</label>
                            <Field type='text' name="category" />
                            <ErrorMessage name="category" component="div" />
                        </div>
                        <button type='submit' disabled={!(dirty && isValid)}>Update</button>
                    </Form>
                    }
                </Formik>
            }
        </div>
    )
}
export default EditProduct;