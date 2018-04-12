import React from "react"
import {IndexRoute, Router, Route} from "react-router"
import {createBrowserHistory} from "history"

//mainRoutes
import Search from "./Search/Search"
import Contact from "./Contact/Contact"
import About from "./About/About"
import Header from "./Components/Header"

//module for getting the data

const history = createBrowserHistory()

export default class Body extends React.Component {
  render() {
    return(
      <React.Fragment>
        <Header />
			  <Router history={ history }>
          <div>
            <Route path="/" component={Search} />
            <Route path="/about" component={About} />
            <Route path="/contact" component={Contact} />
          </div>
			  </Router>
      </React.Fragment>
    )
	}
}
