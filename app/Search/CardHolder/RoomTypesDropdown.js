import React from 'react'
import RoomOption from './RoomOption'

export default class RoomTypesDropdown extends React.Component {

  getOptions() {
    let i = 0
    console.log("Getting close to the money")
    console.log(JSON.stringify(this.props.demRooms))
    return null
  }

  render() {
    console.log("Rendering the dropdown")
    console.log(this.props.demRooms)
    if(this.props.demRooms == null) return null
    return(
      <select name="roomType">
        {this.getOptions()}
    </select>
    )
  }
}
