import React from 'react'

export default class Card extends React.Component {
	constructor() {
		super()
		this.imgUrl = "https://via.placeholder.com/350x150"
		this.urlString = `url(${this.props.imgUrl})`
	}

	render() {
		return(
			<div>
				<p>{"A card"}</p>
				<h3>{this.props.name}</h3>
				<a href={`mailto:${this.props.email}`}>{this.props.email}</a>
				<p>{this.props.numRooms}</p>
				<div className="cardHolder__card__cardImage" style={{backgroundImage: this.urlString}} />
			</div>
		)
	}
}
