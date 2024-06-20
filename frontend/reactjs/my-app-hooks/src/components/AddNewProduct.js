import { Formik, Field, Form, ErrorMessage } from "formik";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Navbar from "./Navbar";

function AddNewProduct() {

    const navigate = useNavigate();
    const mystyle = {
        color: "red",       
        fontFamily: "Arial"
    };
    return (
        <>
        <Navbar/>
            <Formik
                initialValues={
                    {
                        productName: '',
                        productPrice: '',
                        mfd: '',
                        category: ''
                    }
                }

                validate={ values => {
                    const errors = {};
                    if(!values.productName) {
                        errors.productName = "Product Name is required"
                    }
                    if(!values.productPrice) {
                        errors.productPrice = "Product Name is required"
                    }
                    else if(values.productPrice < 0) {
                        errors.productPrice = "Product Price should not be Neagtive"
                    }
                    if(!values.mfd) {
                        errors.mfd = "Date is required"
                    }
                    if(!values.category) {
                        errors.category = "Category is required"
                    }

                    return errors;
                }}

                onSubmit={values => {
                    //api call
                    axios.post("http://localhost:8081/product/save", values)
                        .then(resp => {
                            alert("New Product Saved!");
                            navigate("/product/all")
                        });
                }}
            >
                {({ isSubmitting }) => <Form>
                    <div  className='form-group'>
                        <label>Product Name</label>
                        <Field type="text" name="productName" className="form-control" />
                        <ErrorMessage name="productName" component="div" style={mystyle}/>
                    </div>
                    <div  className='form-group'>
                        <label>Product Price</label>
                        <Field type="text" name="productPrice" className="form-control"  />
                        <ErrorMessage name="productPrice" component="div" style={mystyle}/>
                    </div>
                    <div  className='form-group'>
                        <label>MFD</label>
                        <Field type="date" name="mfd" className="form-control"  />
                        <ErrorMessage name="mfd" component="div" style={mystyle}/>
                    </div>
                    <div  className='form-group'>
                        <label>Category</label>
                        <Field type="text" name="category" className="form-control"  />
                        <ErrorMessage name="category" component="div" style={mystyle} />
                    </div>
                    <button type="submit" disabled={isSubmitting} className="btn btn-primary">
                        Save
                    </button>
                </Form>
                }

            </Formik>
        </>
    )
}

export default AddNewProduct;