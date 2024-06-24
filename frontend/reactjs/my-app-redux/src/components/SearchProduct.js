import { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchProductDetails } from '../store/actions/productActions';

function SearchProduct() {

    const [productId, setProductId] = useState();
    const product = useSelector(state => state.pReducer.product);
    const msg = useSelector(state => state.pReducer.message);
    const dispatch = useDispatch();

    const handleSubmit = () => {
        //call the api
        dispatch(fetchProductDetails(productId));
    }

    return (
        <>
            <div>
                <label>ProductId</label>
                <input type="text" name="productId" value={productId}
                    onChange={event => setProductId(event.target.value)} />
            </div>
            <button onClick={handleSubmit}>Search</button>

            <div>
                {
                    product !== null && <>
                        <h3>Product Details</h3>
                        <p>Name : {product.productName}</p>
                        <p>Price : {product.productPrice}</p>
                        <p>Mfd : {product.mfd}</p>
                        <p>Category : {product.category}</p>
                    </>
                }
                {msg}
            </div>
        </>
    )
}
export default SearchProduct;