import React from 'react'

export default class Card extends React.Component {

	render() {
		const urlString = `url(${this.props.imageUrl})`
		return(
			<div>
				<p>{"A card"}</p>
				<h3>{this.props.name}</h3>
				<a href={`mailto:${this.props.email}`}>{this.props.email}</a>
				<p>{this.props.numRooms}</p>
				<div className="cardHolder__card__cardImage" style={{backgroundImage: urlString}} />
			</div>
		)
	}
}
