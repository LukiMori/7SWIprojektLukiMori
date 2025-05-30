import './App.css'
import {useState} from "react";
import {Route, Routes} from "react-router-dom";
import Signup from "./components/Signup.tsx";
import Home from "./components/Home.tsx";


function App() {

    const [user, setUser] = useState(getUserToken())

    function getUserToken() {
        let userToken = JSON.parse(localStorage.getItem('userToken') || '""');

        return userToken;
    }

    function setUserToken(userToken: any) {
        localStorage.setItem('userToken', JSON.stringify(userToken));
        setUser(userToken);
    }

    return (
        <div className="App">
            <Routes>
                <Route path='/' element={<Home user={user} setUserToken={setUserToken} />} />
                <Route path='/signup' element={<Signup />} />
            </Routes>
        </div>
    )
}

export default App
