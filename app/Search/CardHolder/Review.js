import React from 'react'

export default class Review extends React.Component {

  getReviewText() {

  }

  render() {
    console.log(this.props.data)
    return(
      <div className="review">
        <h3 className="review__subject">{this.props.data.subject}</h3>
        <p className="review__username">{this.props.data.userName}</p>
        <p className="rating">{ (this.props.data.rating + "").substring(0, 3) }</p>
        <p className="review__text">{this.props.data.reviewText}</p>
      </div>
    )
  }
}
