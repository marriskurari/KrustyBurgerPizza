import React from 'react'
import Card from './Card'
import SelectedHotel from './SelectedHotel'
import DCtrl from '../DataController'

export default class CardHolder extends React.Component {
  constructor() {
    super()
    this.renderHotelList = this.renderHotelList.bind(this)
    this.findAndReplace = this.findAndReplace.bind(this)
    this.state = {
      selectedHotel: null,

    }
  }

  findAndReplace(string, replaceThis, withThis) {
    return string.split(replaceThis).join(withThis)
  }

  //vaeri kannski kul ad fa ser getAllRoomsByHotel unction, thad vaeri maera clean ad fa
  //eitt iterable thannig
  async getRooms(hotel) {
    if(hotel == null) return null
    let rooms = {}
    const ids = hotel.roomIds
    console.log("SOme ids n shit")
    console.log(ids)
    Object.keys(ids).map(async key => {
      const a = await DCtrl.room.getOne(ids[key])
      rooms[key] = a
    })
    console.log(rooms)
    this.setState({
      rooms: rooms,
      selectedHotel: hotel
    })
  }

  selectHotel(hotel) {
    console.log(hotel)
    this.getRooms(hotel)
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
        <div className="selected__selectedContainer">
          <SelectedHotel rooms={this.state.rooms} hotel={this.state.selectedHotel} />
        </div>
        <div className="cardHolder__cardContainer"> {this.renderHotelList()} </div>
      </div>
    )
  }
}
