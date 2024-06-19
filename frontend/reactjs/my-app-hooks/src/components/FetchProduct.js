import { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";

function FetchProduct() {

    const [product, setProduct] = useState(null);

    const {pid} = useParams();

    useEffect(() => {

        axios.get("http://localhost:8081/product/" + pid).then(resp => setProduct(resp.data));

    }, []);

    return (
        <div>
            {
                product !== null &&
                <div>
                    <h3>Product Details</h3>
                    <p>Id : {product.productId}</p>
                    <p>Name : {product.productName}</p>
                    <p>Price : {product.productPrice}</p>
                    <p>MFD : {product.mfd}</p>
                    <p>Category : {product.category}</p>
                </div>
            }

        </div>
    )
}

export default FetchProduct;