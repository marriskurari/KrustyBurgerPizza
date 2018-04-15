import React from 'react'

export default class BookingCompleted extends React.Component {

  render() {
    console.log(this.props)
    return (
      <div className="completed" id="completed">
        <div className="completed__image" style={{backgroundImage : `url(${this.props.imageUrl})` }}/>
        <h1 className="completed__heading"> Thank you for booking your room at {this.props.hotelName}</h1>
        <p> Your bookig ID is {this.props.bookingId}</p>
      </div>
    )
  }
}
