
import React from 'react'
import Card from './Card'
import Reviews from './Reviews'
import DCtrl from '../DataController'
import RoomTypesDropdown from './RoomTypesDropdown'

export default class SelectedHotel extends Card {
  constructor() {
    super()
    this.state = {
      rooms: null,
      reviews: [] }
    this.handleSubmit = this.handleSubmit.bind(this)
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

  componentWillReceiveProps() {
    setTimeout(this.props.scrollToNode("cardHolder"), 300)
  }

  async handleSubmit(e) {
    e.preventDefault()
    const form = e.target

    const first = form.querySelector("#first").value
    const last = form.querySelector("#last").value
    const name = `${first}_${last}`
    const email = form.querySelector("#email").value
    const hotelId = this.props.hotel.id
    const roomId = form.querySelector("#roomType").value
    const from = form.querySelector("#from").value
    const to = form.querySelector("#to").value

    const dateFrom = from
    const dateTo = to

    const cc = form.querySelector("#cc").value
    const bookingId= await DCtrl.user.newUserBooking(name, email, hotelId, roomId, dateFrom, dateTo, cc)
    //swagmode activated
    const hotelName = this.findAndReplace(this.props.hotel.name, "_", " ")
    this.props.bookingCompleted(hotelName, this.props.hotel.imageUrl, bookingId)
  }

	async getReviews() {
		let reviews = await DCtrl.review.getFiltered(this.props.hotel.id)
		for(let key in reviews) {
      let user = await DCtrl.user.getOne(reviews[key].userId)
			reviews[key].username = this.findAndReplace(user.name, "_", " ")
		}
    console.log(reviews)
		this.setState({
			reviews: reviews
		})
    console.log("REviews are set")
	}

  getDescriptionText() {
    const textAsObject = this.props.hotel.description
    let string = ''
    for(let key in textAsObject)
      string += textAsObject[key]
    return string
  }

  renderAmenities() {
    const am = this.props.hotel.amenities
    console.log(am)
    let array = []
    console.log(DCtrl.iconURL["wifi"])
    for(let key in am)
      array.push(<div className="cardHolder__selectedHotel__card__icons" key={key} style={{backgroundImage: `url(${DCtrl.iconURL[am[key]]})`}} />)
    console.log(array)
    return array
  }

  render() {
    if(this.props.hotel ==   null) return null
    const url = `url(${this.props.hotel.imageUrl})`
    const name = this.findAndReplace(this.props.hotel.name, "_", " ")
    console.log(this.props.hotel)
    return(
      <div
        className={
          this.props.hotel == null ?
          "displaynone" :
          "cardHolder__selectedHotel"
        }
        name="selected"
      >
      <div className="cardHolder__selectedHotel__card" id="selected">
        <h1>{name}</h1>
        <div className="cardHolder__selectedHotel__card__cardImage" style={{backgroundImage: url}}/>
				<a href={`mailto:${this.props.hotel.email}`}>{this.props.hotel.email}</a>
        <p className"cardHolder__selectedHotel__form__description">{this.getDescriptionText()}</p>
        <div className="cardHolder__selectedHotel__card__icons__container">{this.renderAmenities()}</div>
			  <button onClick={() => this.getReviews()}>Show Reviews</button>
      </div>
      {this.state.reviews ? (<Reviews reviews={this.state.reviews} />) : null }
      <form className="cardHolder__selectedHotel__form" onSubmit={e => this.handleSubmit(e)}>
        <h3> Book your room Now!! </h3>
        <input className="cardHolder__selectedHotel__form__input" id="first" type="text" placeholder="First Name" />
        <input className="cardHolder__selectedHotel__form__input" id="last"type="text" placeholder="Last Name" />
        <RoomTypesDropdown rooms={this.props.rooms} />
        <input className="cardHolder__selectedHotel__form__input" id="from" type="date" placeholder="from" />
        <input className="cardHolder__selectedHotel__form__input" id="to" type="date" placeholder="until" />
        <input className="cardHolder__selectedHotel__form__input" id="email" type="text" placeholder="Email" />
        <input className="cardHolder__selectedHotel__form__input" id="cc"type="number" placeholder="Credit Card Number" />
        <input className="cardHolder__selectedHotel__form__input" id="exmm"type="number" placeholder="MM" />
        <input className="cardHolder__selectedHotel__form__input" id="exyy"type="number" placeholder="YY" />
        <input type="submit"/>
      </form>
    </div>)
  }
}
