import { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import mobile4 from '../assets/mobile4.jpg';

function FetchProduct() {

    const [product, setProduct] = useState(null);

    const { pid } = useParams();

    useEffect(() => {
        axios.get("http://localhost:8081/product/" + pid)
            .then(resp => setProduct(resp.data));
    }, [pid]);

    return (
        <div>
            {
                product !== null &&
                <div className="row">
                    <div className="col">
                        <img src={mobile4}/>
                    </div>
                    <div className="col">
                        <h3>Product Details</h3>
                        <p>Id : {product.productId}</p>
                        <p>Name : {product.productName}</p>
                        <p>Price : {product.productPrice}</p>
                        <p>MFD : {product.mfd}</p>
                        <p>Category : {product.category}</p>
                    </div>
                </div>
            }

        </div>
    )
}

export default FetchProduct;