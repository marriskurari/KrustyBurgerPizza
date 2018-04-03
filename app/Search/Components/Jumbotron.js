import React from 'react'
import SearchForm from "./SearchForm"

export default class Jumbotron extends React.Component {
	render() {
		return(
			<React.Fragment>
				<h2> Jumbotron </h2>
				<SearchForm className="jumbotron__form" getAll={this.props.getAll.bind(this)}/>
			</React.Fragment>
		)
	}
}
