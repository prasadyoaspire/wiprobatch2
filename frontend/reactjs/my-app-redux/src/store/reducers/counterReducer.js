const initialState = {
    counterValue : 0
}
export function counterReducer(state = initialState, action) {

    if(action.type == 'IncrementByOne') {
        return {
            ...state,
            counterValue : state.counterValue+1
        }
    }
    if(action.type == 'DecrementByOne') {
        return {
            ...state,
            counterValue : state.counterValue-1
        }
    }
    return state    
}
