import React, { Component } from "react";
import AuthService from "../services/auth.service";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

import UserAccounts from "../components/UserAccounts.component";
import Balance from "../components/Balance.component";


class Profile extends Component {
  constructor(props) {
    super(props);

    this.state = {
      currentUser: AuthService.getCurrentUser()
    };
  }

  render() {
    const { currentUser } = this.state;

    return (
    <Router>
      <div className="container">
        <header className="jumbotron">
          <h3>
            <strong>{currentUser.username}</strong> 's Home Page
          </h3>
        </header>
        <nav>

        </nav>
        <Link to={"/accounts"} className="container">
             View Bank Accounts
        </Link>
        <Link to={"/balance"} className="container">
             View Balance
        </Link>

                <div className="container mt-3">
                    <Switch>
                      <Route exact path="/accounts" component={UserAccounts} />
                      <Route exact path="/balance" component={Balance} />

                    </Switch>
                </div>


      </div>
      </Router>

    );
  }
}
export default Profile;