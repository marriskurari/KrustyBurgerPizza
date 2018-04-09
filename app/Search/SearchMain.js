import React from "react"
import DCtrl from "../DataController"

import Jumbotron from "./Components/Jumbotron"
import CardHolder from "./Components/CardHolder/CardHolder"
//insert router here
//then make card and then make a the button execute the Search
//get the data to the parent and make a render, plus needs
//to set some the results always as "DISPLAY" which first timed
//makes an animation to show the results with the data

export default class SearchMain extends React.Component {
  constructor(props) {
    super(props)
    this.getAllAndPushToCardHolder = this.getAllAndPushToCardHolder.bind(this)
    this.makeCardHolder = this.makeCardHolder.bind(this)
    this.state = {
      showResults: false,
      hotels: [],
      cardHolder: null
    }
  }

  async getAllAndPushToCardHolder() {
    console.log("the correct one :)")
    const data = await DCtrl.hotel.getAll()
    this.setState(state => {
      console.log("state is set")
      state.hotels = data
      state.showResults = true
    })
    this.makeCardHolder()
  }

  makeCardHolder() {
    this.setState( this.state.cardHolder = (<CardHolder className="cardHolder" hotels={this.state.hotels} />))
  }

  render() {
    console.log("rerender searchmain")
		return(
      <React.Fragment>
        <Jumbotron className="jumbotron" getAll={this.getAllAndPushToCardHolder}/>
        {this.state.cardHolder}
      </React.Fragment>
    )
  }
}
