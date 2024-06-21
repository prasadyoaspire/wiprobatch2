const initialState = {
    products : []
}

export function productReduder(state = initialState, action) {

    if(action.type == 'FETCH_ALL_PRODUCTS_SUCCESS') {
        return {
            ...state,
            products : action.payload
        }
    }

    return state;
}