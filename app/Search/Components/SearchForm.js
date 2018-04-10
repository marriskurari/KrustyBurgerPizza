import React from 'react'
import LocationApi from '../LocationHelper'

//ekki taka burt, function verdur ad vera til
let locApi = () => console.log("locApi was not set in 'SearchForm'")

export default class SearchForm extends React.Component {

	handleSubmit() {
		this.props.getAll()
		this.map = null
		this.form = null
	}



	componentWillMount() {
		console.log("Component is mounting")
		locApi = LocationApi(this.form, this.map)
		console.log("Component mounted")
	}

	render() {
		return(
			<Form ref={c => this.form = c}  onSubmit={this.handleSubmit.bind(this)}>
				<Label>
					Location:
					<input onChange={locApi()} type="text" id="#address" placeholder="Location" />
					<div ref={gglmap => this.map = gglmap} id="map"/>
				</Label>



				<input />
			</Form>
		)
	}
}
