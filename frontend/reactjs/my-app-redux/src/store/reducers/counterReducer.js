const initialState = {
    counterValue : 0
}
export function counterReducer(state = initialState, action) {

    if(action.type == 'INCREMENT') {
        return {
            ...state,
            counterValue : state.counterValue+1
        }
    }
    if(action.type == 'DECREMENT') {
        return {
            ...state,
            counterValue : state.counterValue-1
        }
    }
    if(action.type == 'INCREMENT_BY_VALUE') {
        return {
            ...state,
            counterValue : state.counterValue + action.payload
        }
    }
    return state; 
}
