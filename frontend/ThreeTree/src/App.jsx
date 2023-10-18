import SignUp from './component/SignUp.jsx';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Home from './component/Home.jsx';
import Products from './component/Products.jsx';
import SuccessfullySignedUp from "./component/SuccessFullySignedUp.jsx";
import SuccessfullyOrdered from "./component/SuccessfullyOrdered.jsx";



function App() {
    return (
        <Router>
            <div>
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/signup" element={<SignUp/>}/>
<<<<<<< HEAD
                    <Route path="/products" element={<Products/>}/>
=======
                    <Route path="/successfullySignedUp" element={<SuccessfullySignedUp/>}/>
                    <Route path="/successfullyOrdered" element={<SuccessfullyOrdered/>}/>
>>>>>>> a8abd4b3689f104fe17b2b359ea0a0e8aff5805e
                </Routes>
            </div>
        </Router>
    );
}

export default App
