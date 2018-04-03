import React from "react"
import {Router, Route} from "react-router"
import SearchMain from "./Search/SearchMain"
import Contact from "./Contact/Contact"
import About from "./About/About"
import Header from "./Components/Header"
import {createBrowserHistory} from "history"

const history = createBrowserHistory()

export default class Body extends React.Component {
  render() {
    return(
			<Router history={ history }>
        <Route path="/" component={SearchMain} />
			</Router>
    )
	}
}
					//<Route path="results" component={Results}/>
					//<Route path="makeBooking" component={MakeBooking}/>
					//<Route path="payment" component={Payment}/>
					//<Route path="about" component={About}/>
					//<Route path="contact" component={Contact}/>
