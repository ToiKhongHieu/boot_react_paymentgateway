import './App.css';
import Navigation from './customer/components/Navigation/Navigation';
import Product from './customer/components/Product/Product';
import ProductDetails from './customer/components/ProductDetails/ProductDetails';
import Footer from './customer/Footer/Footer';
import HomePage from './customer/pages/HomePage/HomePage';
function App() {
  return (
    <div className="">
      <Navigation />
      <div>
      {/* <HomePage /> */}
      {/* <Product /> */}
      <ProductDetails />
      </div>
      <Footer/>
    </div>
  );
}

export default App;
