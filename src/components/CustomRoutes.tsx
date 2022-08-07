import React, {Suspense, lazy} from 'react';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";

const Chat = lazy(() => import('./routes/Grid'));
const Login = lazy(() => import('./routes/login/Login'));
function CustomRoutes() {
    return (
        <Router>
            <Suspense fallback={<div>Loading...</div>}>
                <Routes>
                    <Route path="/" element={<Login/>}/>
                </Routes>

                <Routes>
                    <Route path="/home" element={<Chat/>}/>
                </Routes>
            </Suspense>
        </Router>
    );
}

export default CustomRoutes;