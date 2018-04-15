import React from 'react'
import Card from './Card'
import DCtrl from '../DataController'
import RoomTypesDropdown from './RoomTypesDropdown'

export default class SelectedHotel extends Card {
  constructor() {
    super()
    this.state = { rooms: null }
  }

  //not sure if works
  display() {
    return (
      this.props.selectHotel == null ?
      "displaynone"                   :
      "cardHolder__selectedHotel"
    )
  }

  findAndReplace(string, replaceThis, withThis) {
    return string.split(replaceThis).join(withThis)
  }

  handleSubmit(e) {
    e.preventDefault()
    const form = e.target

    const first = form.getElementsByName("first").value
    const last = form.getElementsByName("last").value
    const email = form.getElementsByName("email").value
    const hotelId = this.props.hotel.id
    const roomId = form.getElementsByName("roomType").value
    const dateFrom = form.getElementsByName("dateFrom").value
    const dateTo = form.getElementsByName("dateTo").value
    const cc = form.getElementsByName("cc").value
    DCtrl.user.newUserBooking()
  }

  logit() {
    console.log(this.props.rooms)
    if(this.props.rooms == undefined) return
    console.log(Object.keys(this.props.rooms))
  }

  render() {
    console.log("Stage 1")
    if(this.props.hotel ==   null) return null
    console.log(this.props.rooms)
    const url = `url(${this.props.hotel.imageUrl})`
    const name = this.findAndReplace(this.props.hotel.name, "_", " ")
    console.log("Stage 2")
    console.log("Stage 3")
    this.logit()
    return(
      <div
        className={
          this.props.hotel == null ?
          "displaynone" :
          "cardHolder__selectedHotel"
        }
        name="selected"
      >

      <div className="cardHolder__selectedHotel__card">
        <h1>{name}</h1>
        <div className="cardHolder__selectedHotel__card__cardImage" style={{backgroundImage: url}}/>
				<a href={`mailto:${this.props.hotel.email}`}>{this.props.hotel.email}</a>
      </div>
      <form className="cardHolder__selectedHotel__form" onSubmit={e => this.handleSubmit(e).bind(this)}>
        <h3> Book your room Now!! </h3>
        <input className="cardHolder__selectedHotel__form__input" name="first" type="text" placeholder="First Name" />
        <input className="cardHolder__selectedHotel__form__input" name="last"type="text" placeholder="Last Name" />
        <RoomTypesDropdown rooms={this.props.rooms} />
        <input className="cardHolder__selectedHotel__form__input" name="email"type="text" placeholder="Email" />
        <input className="cardHolder__selectedHotel__form__input" name="cc"type="number" placeholder="Credit Card Number" />
        <input className="cardHolder__selectedHotel__form__input" name="exmm"type="number" placeholder="MM" />
        <input className="cardHolder__selectedHotel__form__input" name="exyy"type="number" placeholder="YY" />

        <input type="submit"/>
      </form>
    </div>)
  }
}
