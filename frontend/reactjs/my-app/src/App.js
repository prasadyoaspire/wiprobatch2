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
import AddProduct from './components/AddProduct';
import Basic from './components/Basic';
import RegForm from './components/RegForm';
import MyComponent from './components/MyComponent';
import { MyContext } from './components/MyContext';

function App() {
  const title = "My First React App";

  const loggedInUser = { name: 'raj', role: 'admin' };


  return (
    <div className="App">
      <h1>{title}</h1>
      {/* <Header /> */}
      {/* <Main /> */}
      {/* <ProductList/> */}
      {/* <Counter/> */}
      {/* <Greeting/> */}
      {/* <Dashboard/> */}
      {/* <AddProduct/> */}
      {/* <FetchAllProducts/> */}
      {/* <RegForm/> */}
      {/* <Basic/> */}
      {/* <Footer /> */}
      {/* <MyComponent  currentUser = {loggedInUser}/> */}

      <MyContext.Provider value={loggedInUser}>

        <MyComponent/>

      </MyContext.Provider>

    </div>
  );
}

export default App;
