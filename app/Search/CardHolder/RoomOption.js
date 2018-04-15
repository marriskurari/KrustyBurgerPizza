import React from 'react'

export default class RoomOption extends React.Component {
  render() {
    return (
      <option value={this.props.room.id}>
        {this.props.room.roomType}
      </option>
      )
  }
}
