import SignUp from './component/SignUp.jsx';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Home from './component/Home.jsx';
import Checkout from "./component/CheckOut.jsx";


function App() {
    return (
        <Router>
            <div>
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/signup" element={<SignUp/>}/>
                    <Route path="/checkout" element={<Checkout/>}/>
                </Routes>
            </div>
        </Router>
    );
}

export default App
