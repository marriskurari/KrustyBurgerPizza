import React from 'react'
import Review from './Review'


//todo bua til nytt component til ad rendera reviews

export default class Reviews extends React.Component {


  render() {
    console.log(this.props)
    return(
      <div className="review__container">
        {this.props.reviews.map(review => <Review key={review.id} data={review} />)}
      </div>
    )
  }
}
