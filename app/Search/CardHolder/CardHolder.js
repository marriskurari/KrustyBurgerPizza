import React from 'react'
import Card from './Card'
import SelectedHotel from './SelectedHotel'

export default class CardHolder extends React.Component {
  constructor() {
    super()
    this.renderHotelList = this.renderHotelList.bind(this)
    this.findAndReplace = this.findAndReplace.bind(this)
    this.state = {selectedHotel: null }
  }

  findAndReplace(string, replaceThis, withThis) {
    return string.split(replaceThis).join(withThis)
  }

  selectHotel(hotel) {
    console.log(hotel)
    this.setState({ selectedHotel: hotel })
  }

  makeCard(hotelObject) {
      return (
        <Card
          hotel={hotelObject}
          selectHotel={this.selectHotel.bind(this)}
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
    console.log(this.state.selectedHotel)
    return(
      <div className="cardHolder">
        <SelectedHotel
          hotel={this.state.selectedHotel}
        />
        <div className="cardHolder__cardContainer">
          {this.renderHotelList()}
        </div>
      </div>
    )
  }
}
