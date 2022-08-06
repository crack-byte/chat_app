import React, {Suspense, lazy} from 'react';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";

const Grid = lazy(() => import('./routes/Grid'));

function CustomRoutes() {
    return (
        <Router>
            <Suspense fallback={<div>Loading...</div>}>
                <Routes>
                    <Route path="/" element={<Grid/>}/>
                </Routes>
            </Suspense>
        </Router>
    );
}

export default CustomRoutes;