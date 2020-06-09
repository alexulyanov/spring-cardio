import React, { Component } from 'react';
import logo from '../logo.svg';
import '../css/App.css';
import PatientsList from "./PatientsList";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import PatientEdit from "./PatientEdit";


class App extends Component {
    render() {
        return (
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={PatientsList}/>
                    <Route path='/patients/:id' exact={true} component={PatientEdit}/>
                </Switch>
            </Router>
        )
    }
}

export default App;
