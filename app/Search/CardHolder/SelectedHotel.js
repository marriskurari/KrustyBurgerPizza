import React from 'react'


export default class SelectedHotel extends React.Component {
  render() {
    return(
      <h1> SelectedHotel {this.props.hotel.id}</h1>
    )
  }
}
