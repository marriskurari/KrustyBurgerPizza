import React from "react"
import {IndexRoute, Router, Route} from "react-router"
import {createBrowserHistory} from "history"

//mainRoutes
import Search from "./Search/Search"

//module for getting the data

const history = createBrowserHistory()

export default class Body extends React.Component {
  render() {
    return(
      <React.Fragment>
			  <Router history={ history }>
          <div>
            <Route path="/" component={Search} />
          </div>
			  </Router>
      </React.Fragment>
    )
	}
}
