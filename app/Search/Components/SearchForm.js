import React from 'react'

//ekki taka burt, function verdur ad vera til

export default class SearchForm extends React.Component {

	handleSubmit(e) {
		console.log(this)
		e.preventDefault()
		console.log(this.props.getAll)
		console.log(this.props)
	}

	getLatLong() {
		googlemarker.then(a => {
			const lat = a.position.lat()
			const lng = a.position.lng()
			this.props.getHotels(lat, lng)
		})
	}

	render() {
		return(
			<form id="container" ref={c => this.form = c}  onSubmit={console.log("blablabla")}>
				<label>
					Location:
					<input onChange={console.log("locationAPI goes here")} type="text" id="address" placeholder="Location" />
				</label>
				<button id="submit" onClick={(e) => {e.preventDefault(); this.getLatLong()}} />
				<div id="googlemap" />
			</form>
		)
	}
}
