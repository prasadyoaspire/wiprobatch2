import { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from "react-router-dom";
import './GetAllProduct.css';

import mobile4 from '../assets/mobile4.jpg';

function GetAllProducts() {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8081/product/all")
            .then(resp => setProducts(resp.data))
    }, []);

    return (
        <div className="row">
            {
                products.map(p =>
                    <div className="col-sm-3">
                        <Link to={`/product/details/${p.productId}`}>
                            <div className="card" style={{ width: "200px" }}>
                                <img className="card-img-top" src={mobile4} alt="Card image" style={{ width: "100%" }} />
                                <div className="card-body">
                                    <h4 className="card-title">{p.productName}</h4>
                                    <p className="card-text">{p.productPrice}</p>
                                </div>
                            </div>
                        </Link>
                    </div>
                )}
        </div>
    )
}

export default GetAllProducts;