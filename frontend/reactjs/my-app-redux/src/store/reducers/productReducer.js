const initialState = {
    products : [],
    product : null,
    message : null
}

export function productReduder(state = initialState, action) {

    if(action.type === 'FETCH_ALL_PRODUCTS_SUCCESS') {
        return {
            ...state,
            products : action.payload
        }
    }

    if(action.type === 'FETCH_PRODUCT_BY_ID_SUCCESS') {       
        return {
            ...state,
            product : action.payload,
            message : null
        }
    }
    if(action.type === 'FETCH_PRODUCT_BY_ID_NOTFOUND') {       
        return {
            ...state,
            message : action.payload,
            product:null
        }
    }

    return state;
}