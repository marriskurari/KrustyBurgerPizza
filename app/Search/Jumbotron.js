import React from 'react'
import SearchForm from "./SearchForm"

export default class Jumbotron extends React.Component {
	render() {
		console.log(this.props.getHotels)
		return(
			<React.Fragment>
				{this.props.children}
				<SearchForm
					getAll={this.getAll}
					getHotels={this.props.getHotels}
				/>
			</React.Fragment>
		)
	}
}
