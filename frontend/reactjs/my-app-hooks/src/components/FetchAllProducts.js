import { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from "react-router-dom";
import Navbar from './Navbar';

function FetchAllProducts() {

    const [products, setProducts] = useState([]);

    //similar to componentDidMount and componentDidUpdate
    useEffect(() => {
        axios.get("http://localhost:8081/product/all")
            .then(resp => setProducts(resp.data))
    }, []);

    return (
        <>
        <Navbar/>
            <h3>All Products</h3>
            <table className="table">
                <thead className="thead-light">
                    <tr>
                        <th>ProductId</th>
                        <th>Name</th>
                        <th>Price</th>
                        {/* <th>MFD</th>
                        <th>Category</th> */}
                    </tr>
                </thead>
                <tbody>
                    {
                        products.map(p => <tr key={p.productId}>
                            <td>{p.productId}</td>
                            <td>{p.productName}</td>
                            <td>{p.productPrice}</td>
                            {/* <td>{p.mfd}</td>
                            <td>{p.category}</td> */}
                            <td><Link to={`/product/details/${p.productId}`}>View</Link></td>
                            <td><Link to={`/product/update/${p.productId}`}>Edit</Link></td>
                            <td><Link to={`/product/delete/${p.productId}`}>Delete</Link></td>
                            
                        </tr>)
                    }
                </tbody>
            </table>

            <div>
                <Link to='/' className="btn btn-dark">Back To Home</Link>
            </div>
        </>
    )
}

export default FetchAllProducts;