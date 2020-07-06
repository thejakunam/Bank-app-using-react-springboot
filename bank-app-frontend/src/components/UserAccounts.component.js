import React, { Component } from "react";
import BankAppService from "../services/bankapp.service";


import AuthService from "../services/auth.service";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";


class UserAccounts extends Component {
  constructor(props) {
      super(props);

      this.retrieveAccounts  = this.retrieveAccounts.bind(this);
      this.refreshList = this.refreshList.bind(this);

      this.state = {
        currentUser: AuthService.getCurrentUser(),
         accounts: []
      };
    }
     componentDidMount() {
        this.retrieveAccounts(this.state.currentUser.username);
      }

    retrieveAccounts(username) {
        BankAppService.getAccount(username)
          .then(response => {
            this.setState({
              accounts: response.data
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
            return this.state.accounts.map((account, index) => {
               const { userId, bankaccno, username, bankname } = account //destructuring
               return (
                  <tr key={userId}>
                     <td>{bankaccno}</td>
                     <td>{bankname}</td>
                  </tr>
               )
            })
         }

         render() {
            return (
               <div>
                  <h1 id='title'>List of Bank Accounts</h1>
                  <table id='accounts'>
                    <tr>
                                          <td>   Bank Account Number  </td>

                                          <td>  Bank Name   </td>
                    </tr>
                     <tbody>
                        {this.renderTableData()}
                     </tbody>
                  </table>
               </div>
            )
         }

}

export default UserAccounts;