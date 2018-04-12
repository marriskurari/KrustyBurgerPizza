import React from 'react'
import SearchForm from "./SearchForm"

export default class Jumbotron extends React.Component {
	render() {
		console.log(this.props.getHotels)
		return(
			<React.Fragment>
				<h2> Jumbotron </h2>
				{this.props.children}
				<SearchForm
					className="jumbotron__form"
					getAll={this.getAll}
					getHotels={this.props.getHotels}
				/>
			</React.Fragment>
		)
	}
}
