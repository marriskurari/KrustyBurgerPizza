import React from 'react'

import Jumbotron from './Jumbotron'
import CardHolder from './CardHolder/CardHolder'
import Card from './CardHolder/Card'

import DCtrl from './DataController'

export default class Search extends React.Component {
  constructor() {
    super()
    this.state = { show : null }
    this.state.cardHolder = (<p>Cards go here</p>)
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

  selectHotel(hotel) {
    this.setState({
      selectedHotel: hotel
    })
  }

  makeCardHolder(){
    this.setState({ cardHolder: (<CardHolder hotels={this.state.hotels} />)})
  }

  makeCard(hotelObject) {
      console.log("MAking dem cards bro")
      return
        (<Card
          className="cardHolder__card"
          key={hotelObject.id}
          name={this.findAndReplace(hotelObject.name, "_", " ")}
          email={hotelObject.email}
          latitude={hotelObject.latitude}
          longitude={hotelObject.longitude}
          imageUrl={hotelObject.imageUrl}
          numRooms={hotelObject.numRooms}
        />)
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
