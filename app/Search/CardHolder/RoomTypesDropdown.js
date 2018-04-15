import React from 'react'
import RoomOption from './RoomOption'

export default class RoomTypesDropdown extends React.Component {

  getOptions() {
    return this.props.rooms.map(room => (<RoomOption key={room.id} room={room}/>) )
  }

  render() {
    console.log("Rendering the dropdown")
    console.log(this.props.rooms)
    if(this.props.rooms == null) return null
    return(
      <select name="roomType">
        {this.getOptions()}
    </select>
    )
  }
}
