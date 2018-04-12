import React from 'react'


export default class Layout extends React.Component {
  render() {
    return(
      <React.Fragment>
        <h1>CHILDREN!!!!</h1>
        {this.props.children}
      </React.Fragment>
    )
  }
}
