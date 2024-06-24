import logo from './logo.svg';
import './App.css';
import Counter from './components/Counter';
import Counter2 from './components/Counter2';
import FetchAllProducts from './components/FetchAllProducts';
import SearchProduct from './components/SearchProduct';

function App() {
  return (
    <>
      {/* <Counter /> */}
      <Counter2/>
      <hr></hr>
      <FetchAllProducts/>
      <hr></hr>
      <SearchProduct/>
    </>
  );
}

export default App;
