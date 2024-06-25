import { useEffect, useState } from 'react';
import axios from 'axios';

function AllProducts() {
    const [products, setProducts] = useState([]);

    useEffect(() => {       
        axios.get("http://localhost:8000/products").then(resp => setProducts(resp.data));
    }, [])

    const handleDelete = (id) => {      
        axios.delete("http://localhost:8000/products/"+id)
        .then(resp=> alert("Product Deleted"));
    }

    return (
        <div>
            <h3>All Products</h3>
            {
                products.map(p => <div>
                    <p>{p.id} {p.productName} {p.productPrice} {p.mfd} {p.category} 
                        <button>Edit</button> 
                        <button onClick={()=>handleDelete(p.id)}>Delete</button>
                    </p>
                </div>)
            }
        </div>
    )
}

export default AllProducts;