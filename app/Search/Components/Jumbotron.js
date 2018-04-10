import React from 'react'
import SearchForm from "./SearchForm"

export default class Jumbotron extends React.Component {
	constructor(props) {
		super(props)
		console.log(this.props.getAll)
	}

	formGetAll() {
		this.props.getAll()
	}

	render() {
		console.log(this.props.getAll)
		console.log(this.props.getHotels)
		return(
			<React.Fragment>
				<h2> Jumbotron </h2>
				<SearchForm
					className="jumbotron__form"
					send={this.formGetAll.bind(this)}
					getHotels={this.props.getHotels}
				/>
			</React.Fragment>
		)
	}
}
