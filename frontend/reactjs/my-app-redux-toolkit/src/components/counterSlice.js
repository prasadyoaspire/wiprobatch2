import { createSlice } from '@reduxjs/toolkit'

const counterSlice = createSlice({
    name : 'CounterSlice',
    initialState : {
        counterValue : 0
    },
    reducers : {
        increment :  state => {
            state.counterValue = state.counterValue+1
        },
        decrement : state => {
            state.counterValue = state.counterValue-1
        }
    }
})

export const { increment, decrement} = counterSlice.actions;

export default counterSlice.reducer;