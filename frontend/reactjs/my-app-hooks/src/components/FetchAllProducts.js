import { useEffect, useState } from 'react';
import axios from 'axios';

function FetchAllProducts() {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8081/product/all")
        .then(resp => setProducts(resp.data))
    },[])

    return (
        <div>
            <h3>All Products</h3>
            {
                products.map(p => <div key={p.productId}>
                    {p.productId} {p.productName} {p.productPrice} {p.mfd} {p.category}
                </div>)
            }
        </div>
    )
}

export default FetchAllProducts;