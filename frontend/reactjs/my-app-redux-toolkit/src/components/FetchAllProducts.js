import { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getAllProducts } from './productSlice';

function FetchAllProducts() {

    const products = useSelector(state => state.product.products);
    const status = useSelector(state => state.product.status);
    const error = useSelector(state => state.product.error);

    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(getAllProducts());
    }, [])

    if (status === 'loading') {
        return <div>Loading......</div>
    }
    if (error !== null) {
        return <div>{error}</div>
    }
    if (status === 'idle') {
        return (
        <>
            <h3>All Products</h3>
            {
                products.map(p => <>
                    <p key={p.productId}>{p.productId} {p.productName} {p.productPrice} {p.mfd} {p.category}</p>
                </>)
            }
        </>
        )
    }
}
export default FetchAllProducts;