import { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

function DeleteProduct() {

    const [product, setProduct] = useState(null);

    const {id} = useParams();

    useEffect(() => {
        axios.get("http://localhost:8081/product/" + id)
        .then(resp => setProduct(resp.data));
    }, [id]);

    const deleteProductHandler = () => {
        axios.delete("http://localhost:8081/product/" + id)
        .then(resp=>alert("product deleted"));
    }

    return(
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

            <button onClick={deleteProductHandler}>Delete</button>
            <button>Cancel</button>

        </div>
    )
}

export default DeleteProduct;