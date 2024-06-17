import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Footer from './components/Footer';
import Main from './components/Main';
import ProductList from './components/ProductList';

function App() {
  const title = "My First React App";
  return (
    <div className="App">
      <h1>{title}</h1>
      <Header />
      <Main />
      {/* <ProductList/> */}
      <Footer />
    </div>
  );
}

export default App;
