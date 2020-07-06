import React, { Component } from "react";
import BankAppService from "../services/bankapp.service";


import AuthService from "../services/auth.service";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";


class UserBalance extends Component {
  constructor(props) {
       super(props);

            this.retrieveBalance  = this.retrieveBalance.bind(this);
            this.refreshList = this.refreshList.bind(this);

            this.state = {
              currentUser: AuthService.getCurrentUser(),
               Balance: []
            };
    }

     componentDidMount() {
            this.retrieveBalance(this.state.currentUser.username);
          }

        retrieveBalance(username) {
            BankAppService.getBalance(username)
              .then(response => {
                this.setState({
                  Balance: response.data
                });
                console.log(response.data);
              })
              .catch(e => {
                console.log(e);
              });
          }

        refreshList() {
            this.retrieveTutorials();
          }

    renderTableData() {
                return this.state.Balance.map((balanceinfo, index) => {
                   const { userId, username, bankaccno, balance } = balanceinfo //destructuring
                   return (
                      <tr key={userId}>
                         <td>{bankaccno}</td>
                         <td>{balance}</td>
                      </tr>
                   )
                })
             }

             render() {
                return (
                   <div>
                      <h1 id='title'>List of Bank Balance</h1>
                      <table id='Balance'>
                        <tr>
                                              <td>   Bank Account Number  </td>

                                              <td>  Bank Balance   </td>
                        </tr>
                         <tbody>
                            {this.renderTableData()}
                         </tbody>
                      </table>
                   </div>
                )
             }
}

export default UserBalance;