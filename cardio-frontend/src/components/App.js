import React, { Component } from 'react';
import logo from '../logo.svg';
import '../css/App.css';
import PatientsList from "./PatientsList";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";


class App extends Component {
    render() {
        return (
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={PatientsList}/>
                </Switch>
            </Router>
        )
    }
}

export default App;
