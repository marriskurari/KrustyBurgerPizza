import React from 'react'
import Card from './Card'

export default class CardHolder extends React.Component {
  constructor() {
    super()
    this.renderHotelList = this.renderHotelList.bind(this)
    this.findAndReplace = this.findAndReplace.bind(this)
  }

  findAndReplace(string, replaceThis, withThis) {
    return string.split(replaceThis).join(withThis)
  }

  makeCard(hotelObject) {
      return (
        <Card
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
    console.log("Rendering")
    if(this.props.hotels == undefined) return (<React.Fragment/>)
    return this.props.hotels.map(hotel => this.makeCard(hotel))
  }

  render() {
    console.log(this)
    return(
      <React.Fragment>
        <p>{"not shocking bro"}</p>
        {this.renderHotelList()}
      </React.Fragment>
    )
  }
}
