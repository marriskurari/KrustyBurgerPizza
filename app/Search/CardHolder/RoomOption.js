import React from 'react'

export default class RoomOption extends React.Component {
  render() {
    console.log("Nuna er thetta ordid sma retarted lol")
    return (
      <option value={this.props.value}>
        {this.props.roomType}
      </option>
      )
  }
}
