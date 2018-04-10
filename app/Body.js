import React from "react"
import {IndexRoute, Router, Route} from "react-router"
import {createBrowserHistory} from "history"

//mainRoutes
import Contact from "./Contact/Contact"
import About from "./About/About"
import Header from "./Components/Header"

//module for getting the data
import DCtrl from "./DataController"

//searchcomponents
import Layout from "./Search/Layout"
import Jumbotron from "./Search/Jumbotron"
import CardHolder from "./Search/CardHolder/CardHolder"
import SearchForm from "./Search/SearchForm"

const history = createBrowserHistory()

export default class Body extends React.Component {
  constructor(props) {
    super(props)
    this.getAllAndPushToCardHolder = this.getAllAndPushToCardHolder.bind(this)
    this.makeCardHolder = this.makeCardHolder.bind(this)
    this.getHotelsByLocation = this.getHotelsByLocation.bind(this)
    this.state = {
      showResults: false,
      hotels: [],
      cardHolder: null,
      selectedHotel: null
    }
  }

  setHotels(data) {
    console.log(data)
    this.setState(state => {
      console.log("state is set")
      state.hotels = data
      state.showResults = true
    })
    this.makeCardHolder()
  }

  async getAllAndPushToCardHolder() {
    console.log("the correct one :)")
    const data = await DCtrl.hotel.getAll()
    this.setHotels(data)
  }

  async getHotelsByLocation(lat, lng) {
    console.log("blabla")
    const data = await DCtrl.hotel.getHotelsByLocation(lat, lng)
    this.setHotels(data)
  }

  makeLayout() {
    return(
      <div>
        <Jumbotron
          className="jumbotron"
          getHotels={this.getHotelsByLocation}
          getAll={this.getAllAndPushToCardHolder}
        />
        {this.props.children}
      </div>
    )
  }

  makeCardHolder() {
    this.setState( this.state.cardHolder = (<CardHolder className="cardHolder" hotels={this.state.hotels} />))
  }

  makeHotelBookingCard() {
    this.setState( this.state.selectedHotel = (<SelectedHotel className="hotelHolder" />))
  }

  render() {
    return(
			<Router history={ history }>

        <Route path="/" component={<Jumbotron />}>
          <IndexRoute component={this.state.cardHolder} />
          <Route path="hotel" component={this.state.selectedHotel} />
        </Route>
			</Router>
    )
	}
}
