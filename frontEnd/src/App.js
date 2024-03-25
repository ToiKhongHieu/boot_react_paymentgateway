import { Route, Routes } from 'react-router-dom';
import './App.css';
import CustomerRouters from './Routers/CustomerRouters';
function App() {
  return (
    <div className="">
      <Routes>
        <Route path='/*' element={<CustomerRouters/>}></Route>
      </Routes>
      <div>
      </div>
    </div>
  );
}

export default App;
