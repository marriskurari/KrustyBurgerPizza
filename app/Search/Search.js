import React from 'react'

import Jumbotron from './Jumbotron'
import CardHolder from './CardHolder/CardHolder'
import Card from './CardHolder/Card'

import DCtrl from './DataController'

export default class Search extends React.Component {
  constructor() {
    super()
    this.state = { show : null }
    this.state.cardHolder = (<h3 className="displayhidden"> HOW DID YOU FIND ME?!? </h3>) //just for a little space
  }

  makeCards(hotels) {
    return hotels.map(hotel => this.makeCard(hotel))
  }

  setHotels(newHotels) {
    this.setState({
      hotels: newHotels
    })
    console.log(this.state.hotels)
    this.makeCardHolder()
    this.scrollToNode("cardHolder")
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
    return data
  }

  scrollToNode(id) {
    console.log("Scrolling to " + id)
    const node = document.querySelector("#" + id)
    const y = node.getBoundingClientRect().top + window.scrollY - 150
    console.log(window.scrollY)
    console.log(y)
    window.scroll({
      top: y,
      behavior: 'smooth'
    })
  }

  selectHotel(hotel) {
    this.setState({
      selectedHotel: hotel
    })
  }

  makeCardHolder(){
    this.setState({ cardHolder: (<CardHolder
      scrollToNode={this.scrollToNode}
      hotels={this.state.hotels}
    />)})
  }

  render() {
    return(
      <React.Fragment>
        <div className="jumbotron">
          <Jumbotron
            getHotels={this.getHotelsByLocation.bind(this)}
            selectHotel={this.selectHotel}
          />
        </div>
        <div className="cardholder">
          {this.state.cardHolder}
        </div>
      </React.Fragment>
    )
  }
}
