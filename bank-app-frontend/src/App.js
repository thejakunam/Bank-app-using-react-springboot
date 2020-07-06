import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";


import AuthService from "./services/auth.service";

import Login from "./components/login.component";
import Register from "./components/register.component";
import Profile from "./components/profile.component";
import UserAccounts from "./components/UserAccounts.component";
import Balance from "./components/Balance.component";

class App extends Component {
    constructor(props) {
      super(props);
      this.logOut = this.logOut.bind(this);

      this.state = {
        currentUser: undefined
      };
    }

    componentDidMount() {
      const user = AuthService.getCurrentUser();

      if (user) {
        this.setState({
          currentUser: user,
        });
      }
    }

    logOut() {
      AuthService.logout();
    }

    render() {
      const { currentUser } = this.state;

      return (
        <Router>
          <div>
            <nav className="navbar navbar-expand navbar-dark bg-dark">
              <Link to={"/"} className="navbar-brand">
                Bank Application
              </Link>


              {currentUser ? (
                <div className="navbar-nav ml-auto">
                  <li className="nav-item">
                    <Link to ={"/account"} className = "nav-link">
                        Bank Account
                    </Link>
                  </li>
                  <li className="nav-item">
                     <Link to ={"/balance"} className = "nav-link">
                        Bank Balance
                     </Link>
                  </li>
                  <li className="nav-item">
                    <Link to={"/profile"} className="nav-link">
                      {currentUser.username}
                    </Link>
                  </li>
                  <li className="nav-item">
                    <a href="/login" className="nav-link" onClick={this.logOut}>
                      LogOut
                    </a>
                  </li>
                </div>
              ) : (
                <div className="navbar-nav ml-auto">
                  <li className="nav-item">
                    <Link to={"/login"} className="nav-link">
                      Login
                    </Link>
                  </li>

                  <li className="nav-item">
                    <Link to={"/register"} className="nav-link">
                      Sign Up
                    </Link>
                  </li>
                </div>
              )}
            </nav>

            <div className="container mt-3">
              <Switch>
                <Route exact path="/login" component={Login} />
                <Route exact path="/register" component={Register} />
                <Route exact path="/profile" component={Profile} />
                <Route exact path="/account" component={UserAccounts} />
                <Route exact path="/balance" component={Balance} />

              </Switch>
            </div>
          </div>
        </Router>
      );
    }
  }

 export default App;

