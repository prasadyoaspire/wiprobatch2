import { Formik } from 'formik';

function Login() {
    return (
        <>
            <Formik
                initialValues={{ email: '', pwd: '' }}
                onSubmit={(values) => {
                    alert(JSON.stringify(values, null, 2));
                }}
            >

                {({
                    values,                  
                    handleChange,
                    handleBlur,
                    handleSubmit                                 
                }) => <form onSubmit={handleSubmit}>
                        <input
                            type="email"
                            name="email"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            value={values.email}
                        />
                        <input
                            type="password"
                            name="pwd"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            value={values.pwd}
                        />
                        <button type="submit" className="btn btn-primary">
                            Submit
                        </button>
                    </form>
                }
            </Formik>
        </>
    )
}
export default Login;