import React from 'react'


export default class SelectedHotel extends Card {
  constructor(props) {
    super(props)
  }


  render() {
    return(
      {this.renderInfo()}
      <input type="text" placeholder="First Name" />
      <input type="text" placeholder="Last Name" />
      <input type="text" placeholder="Last Name" />
    )
  }
}
