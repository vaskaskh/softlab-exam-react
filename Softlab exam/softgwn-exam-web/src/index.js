import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter, Route, Routes, Outlet} from "react-router-dom";
import Students from "./components/Student/Students";
import Teachers from "./components/Teacher/Teachers";
import Groups from "./components/Groups";


ReactDOM.render(
    <BrowserRouter>
        <Routes>
          <Route path="/" element={<App/>} >Homepage
          <Route path="/students" element={<Students/>}/>
          <Route path="/teachers" element={<Teachers/>}/>
          <Route path="/groups" element={<Groups/>}/>
          </Route>
        </Routes>

    </BrowserRouter>,
  document.getElementById('root')
);
