import './App.css';
import Counter from './components/Counter';
import FetchAllProducts from './components/FetchAllProducts';
import AddProduct from './components/AddProduct';

import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import FetchProduct from './components/FetchProduct';
import UpdateProduct from './components/UpdateProduct';
import DeleteProduct from './components/DeleteProduct';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path={"/"} element={<Home />} />
        <Route path='/counter' element={<Counter />} />
        <Route path='/product/all' element={<FetchAllProducts />} />
        <Route path='/product/add' element={<AddProduct />} />
        <Route path='/product/details/:pid' element={<FetchProduct />} />
        <Route path='/product/update/:id' element={<UpdateProduct />} />
        <Route path='/product/delete/:id' element={<DeleteProduct />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
