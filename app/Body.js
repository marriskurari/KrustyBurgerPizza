import React from "react"
import Header from "./Header/Header"
import Main from "./Main/Main"
import Footer from "./Footer/Footer"

export default class Body extends React.Component {
  render() {
    return(
      <React.Fragment>
        <Header className="header" />
        <div className="main">
          <h1>This is Main</h1>
        </div>
        <Footer />
      </React.Fragment>
    )
  }
}
