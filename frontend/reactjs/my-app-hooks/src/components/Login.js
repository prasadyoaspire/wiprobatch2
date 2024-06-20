import { Formik, ErrorMessage, Form, Field } from 'formik';
import * as Yup from "yup";

function Login() {
    
    const LoginSchema = Yup.object().shape({
        email: Yup.string()
            .email("Invalid email address format")
            .required("Email is required"),
        pwd: Yup.string()
            .min(3, "Password must be 3 characters at minimum")
            .required("Password is required"),
    });

    return (
        <>
            <Formik
                initialValues={{ email: '', pwd: '' }}

                validationSchema={LoginSchema}

                // validate={values => {
                //     const errors = {};
                //     if (!values.email) {
                //         errors.email = 'Email Required';
                //     } else if (
                //         !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
                //     ) {
                //         errors.email = 'Invalid email address';
                //     }
                //     if(!values.pwd) {
                //        errors.pwd = 'Password Required' ;
                //     }
                //     return errors;
                // }}

                onSubmit={(values) => {
                    alert(JSON.stringify(values, null, 2));
                    //alert(JSON.stringify(values));
                }}
            >
                {({isSubmitting}) => <Form>
                        <Field type="email" name="email" />
                        <ErrorMessage name="email" component="div" />
                        <Field type="password" name="pwd" />
                        <ErrorMessage name="pwd" component="div" />
                        <button type="submit" disabled={isSubmitting}>
                            Submit
                        </button>
                    </Form>
                }
            </Formik>
        </>
    )
}
export default Login;