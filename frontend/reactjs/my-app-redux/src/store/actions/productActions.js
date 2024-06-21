import axios from 'axios';

export function fetchAllProducts() {

    return (dispatch) => {
        return axios.get("http://localhost:8081/product/all")
        .then(resp=>dispatch(getAllProductsSuccess(resp.data)));
    }
}

function getAllProductsSuccess(data) {
    return {
        type : 'FETCH_ALL_PRODUCTS_SUCCESS',
        payload : data
    }
}