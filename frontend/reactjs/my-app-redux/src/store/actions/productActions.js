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

export function fetchProductDetails(productId) {

    return (dispatch) => {
        return axios.get("http://localhost:8081/product/"+productId)
        .then(resp=>dispatch(fetchProductSuccess(resp.data)))
        .catch(error=>dispatch(fetchProductNotFound(error.response.data)));
    }
}

function fetchProductSuccess(data) {
    return {
        type : 'FETCH_PRODUCT_BY_ID_SUCCESS',
        payload : data
    }
}
function fetchProductNotFound(data) {
    return {
        type : 'FETCH_PRODUCT_BY_ID_NOTFOUND',
        payload : data
    }
}