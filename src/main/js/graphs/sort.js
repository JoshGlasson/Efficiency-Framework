import React from 'react';

class Sort extends React.Component {
  constructor(props) {
  super(props)
    this.state = {x: [], y: []};
  }

	render() {
	console.log(this.getData())
		return (
      <h1>Hi</h1>
		)
	}

	getData(){
	var data = fetch('/api/sorts', {
              method: 'GET',
              headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
              },
            })
            return data;
    }
}

export default Sort;
