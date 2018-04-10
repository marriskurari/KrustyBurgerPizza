import React from 'react'

//ekki taka burt, function verdur ad vera til

export default class SearchForm extends React.Component {

	handleSubmit(e) {
		console.log(this)
		e.preventDefault()
		console.log(this.props.getAll)
		console.log(this.props)
	}


	componentWillMount() {
		console.log("Component is mounting")
		console.log("Component mounted")
	}

	render() {
		return(
			<form ref={c => this.form = c}  onSubmit={console.log("blablabla")}>
				<label>
					Location:
					<input onChange={console.log("locationAPI goes here")} type="text" id="#address" placeholder="Location" />
					<div ref={gglmap => this.map = gglmap} id="map"/>
				</label>
				<button onClick={(e) => {e.preventDefault();   this.props.send()}} />


				<input />
			</form>
		)
	}
}
