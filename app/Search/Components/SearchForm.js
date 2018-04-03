import React from 'react'

export default class SearchForm extends React.Component {
	handleClick() {
		this.props.getAll()
	}

	render() {
		return(
			<button onClick={this.handleClick.bind(this)}> Get All </button>
		)
	}
}
