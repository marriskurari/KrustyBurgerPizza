import React from 'react'

export default class Card extends React.Component {

	render() {
		const urlString = `url(${this.props.imageUrl})`
		return(
				<div
					className="cardHolder__card"
      	  onClick={() => this.props.selectHotel(this.props.hotel)}
				>
					<div className="cardHolder__card__cardImage" style={{backgroundImage: urlString}} />
					<h3>{this.props.name}</h3>
					<a href={`mailto:${this.props.email}`}>{this.props.email}</a>
				</div>
		)
	}
}
