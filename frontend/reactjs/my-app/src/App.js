import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Footer from './components/Footer';
import Main from './components/Main';
import ProductList from './components/ProductList';
import Counter from './components/Counter';
import Greeting from './components/Greeting';
import Dashboard from './components/Dashbaord';
import FetchAllProducts from './components/FetchAllProducts';

function App() {
  const title = "My First React App";
  return (
    <div className="App">
      <h1>{title}</h1>
      <Header />
      {/* <Main /> */}
      {/* <ProductList/> */}
      {/* <Counter/> */}
      {/* <Greeting/> */}
      {/* <Dashboard/> */}
      <FetchAllProducts/>
      <Footer />
    </div>
  );
}

export default App;
