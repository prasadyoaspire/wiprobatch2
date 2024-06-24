import { createSlice, createAsyncThunk } from '@reduxjs/toolkit'
import axios from 'axios';


export const getAllProducts = createAsyncThunk('product/fetchAll',
    async () => {
        const response = await axios.get("http://localhost:8081/product/all");
        return response.data;
    })

const productSlice = createSlice({
    name: 'ProductSlice',
    initialState: {
        products: [],
        product: null,
        status: 'idle',
        error: null
    },
    reducers: {

    },
    extraReducers: builder => {
        builder.addCase(getAllProducts.pending, (state, action) => {
            if (state.status === 'idle') {
                state.status = 'loading';
            }
        })
            .addCase(getAllProducts.fulfilled, (state, action) => {
                if (state.status === 'loading') {
                    state.products = action.payload
                    state.msg = ''
                    state.status = 'idle'
                }
            })
            .addCase(getAllProducts.rejected, (state, action) => {
                if (state.status === 'loading') {
                    state.error = 'Error occured'
                    state.status = 'idle'
                }
            });
    }
})

export default productSlice.reducer;