import {useEffect} from 'react';
import { useSelector, useDispatch} from 'react-redux';
import { fetchAllProducts } from '../store/actions/productActions';

function FetchAllProducts() {

    const myProducts = useSelector(state=>state.pReducer.products);
    const dispatch = useDispatch();

    useEffect(()=> {
        dispatch(fetchAllProducts());
    },[])


    return (
        <>
        <h3>All Products</h3>
        {
            myProducts.length > 0 && 

            myProducts.map(p=> <>
            <div>{p.productId} {p.productName} {p.productPrice} {p.mfd} {p.category}</div>
            </>)
        }
        </>
    )
}

export default FetchAllProducts;