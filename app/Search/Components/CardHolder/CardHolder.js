import React from 'react'
import Card from './Card'

export default class CardHolder extends React.Component {
  constructor() {
    super()
    this.renderHotelList = this.renderHotelList.bind(this)
    this.state = { hotels: [] }
  }

  findAndReplace(string, replaceThis, withThis) {
    return string.split(replaceThis).join(withThis)
  }

  makeCard(hotelObject) {
      return (<Card
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

  renderHotelList() {
    return this.props.hotels.map(hotel => this.makeCard(hotel))
  }

  render() {
    return(
      <React.Fragment>
        <p>{"shocker"}</p>
        {this.renderHotelList()}
      </React.Fragment>
    )
  }
}
