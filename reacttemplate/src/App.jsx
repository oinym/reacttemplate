import React, {useContext} from 'react';
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import Navbar from "./component/Navbar";
import About from './pages/About';
import Contact from './pages/Contact';
import './App.css';
import Home from "./pages/Home";
import {UserContext} from "./jsutils/Authentication";
import PageNotFound from "./pages/PageNotFound";
import FAQ from "./pages/FAQ";


function App() {
   const {user}=useContext(UserContext);
console.log(`user: ${user}`);
    return (

        <Router>
            <div>
                <Navbar/>
            {user?

                   <Switch>
                       <Route exact path="/" component={About}/>
                       <Route path="/about" component={About}/>
                       <Route path="/contact" component={Contact}/>
                       <Route path="/faq" component={FAQ}/>
                       <Route path="/*" component={PageNotFound}/>
                   </Switch>

                :
                <Switch>
                    <Route exact path="/" component={Home}/>
                    <Route path="/*" component={PageNotFound}/>
                </Switch>
            }
            </div>
        </Router>

    );
}


export default App;
