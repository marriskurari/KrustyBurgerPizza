import React from 'react'
import Card from './Card'

export default class SelectedHotel extends Card {
  constructor(props) {
    super(props)
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

  render() {
    console.log(this.props)
    console.log(this.props.hotel)
    if(this.props.hotel == null) return null
    const urlString = `url(${this.props.hotel.imageUrl})`
    const name = this.findAndReplace(this.props.hotel.name, "_", " ")
    return(<div
        className={this.props.hotel == null ? "displaynone" : "cardHolder__selectedHotel"}
        name="selected"
      >

      <div className="cardHolder__selectedHotel__card">
        <h1>{name}</h1>
        <div className="cardHolder__selectedHotel__card__cardImage" style={{backgroundImage: urlString}}/>
				<a href={`mailto:${this.props.hotel.email}`}>{this.props.hotel.email}</a>
      </div>
      <form className="cardHolder__selectedHotel__form" onSubmit={console.log("submitted")}>
        <h3> Book your room Now!! </h3>
        <input className="cardHolder__selectedHotel__form__input" type="text" placeholder="First Name" />
        <input className="cardHolder__selectedHotel__form__input" type="text" placeholder="Last Name" />
        <input className="cardHolder__selectedHotel__form__input" type="number" placeholder="Credit Card Number" />
        <input className="cardHolder__selectedHotel__form__input" type="number" placeholder="MM" />
        <input className="cardHolder__selectedHotel__form__input" type="number" placeholder="YY" />
        <input className="cardHolder__selectedHotel__form__input" type="text" placeholder="Email" />
        <input type="submit"/>
      </form>
    </div>)
  }
}
