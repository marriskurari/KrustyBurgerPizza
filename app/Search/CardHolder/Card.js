import React from 'react'
import Review from './Review'

import DCtrl from '../DataController'

export default class Card extends React.Component {

	async getReviews() {
		const reviews = await DCtrl.review.getFiltered(this.props.id)
		for(let review in reviwes) {
			review.username = await DCtrl.user.getOne(review.userId)
		}
		this.setState({
			reviews: reviews
		})
	}

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
					<p>Stars: {this.props.stars}</p>
					<button onClick={this.getReviews()}>Show Reviews</button>
					{this.state.reviews.map(review => <Review data={review} />)}
				</div>
		)
	}
}
