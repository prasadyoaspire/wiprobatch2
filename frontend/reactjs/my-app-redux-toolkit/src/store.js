import { configureStore } from '@reduxjs/toolkit'

import counterSlice from './components/counterSlice'
import productSlice from './components/productSlice'

export default configureStore({
  reducer: {
    counter : counterSlice,
    product : productSlice
  }
})