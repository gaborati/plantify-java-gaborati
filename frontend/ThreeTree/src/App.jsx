import SignUp from './component/SignUp.jsx';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Home from './component/Home.jsx';
import SuccessfullySignedUp from "./component/SuccessFullySignedUp.jsx";
import SuccessfullyOrdered from "./component/SuccessfullyOrdered.jsx";



function App() {
    return (
        <Router>
            <div>
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/signup" element={<SignUp/>}/>
                    <Route path="/successfullySignedUp" element={<SuccessfullySignedUp/>}/>
                    <Route path="/successfullyOrdered" element={<SuccessfullyOrdered/>}/>
                </Routes>
            </div>
        </Router>
    );
}

export default App
