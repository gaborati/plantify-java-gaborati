import './App.css';
import SignUp from './component/SignUp.jsx';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';

import Home from './component/Home.jsx';

function App() {
    return (
        <Router>
            <div>
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/signup" element={<SignUp/>}/>
                </Routes>
            </div>
        </Router>
    );
}

export default App
