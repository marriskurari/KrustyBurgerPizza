import React from 'react'

export default class Card extends React.Component {

	render() {
		const urlString = `url(${this.props.imageUrl})`
		return(
			<div className="cardHolder__card">
				<h3>{this.props.name}</h3>
				<a href={`mailto:${this.props.email}`}>{this.props.email}</a>
				<div className="cardHolder__card__cardImage" style={{backgroundImage: urlString}} />
			</div>
		)
	}
}
