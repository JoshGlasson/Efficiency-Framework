import React from 'react';
import Plot from 'react-plotly.js';

class Sort extends React.Component {
constructor(props) {
  super(props)
    this.state = {x: [], y: []};
    fetch('/api/sorts', {
              method: 'GET',
              headers: {
              'Content-Type': 'application/json',
              },
              credentials: 'same-origin'
              }).then((response) => {
                   if(response.ok) {
                     return response.json();
                   } else {
                     throw new Error('Server response wasn\'t OK');
                   }
                 })
                 .then((json) => {
                   this.setState(state => ({x: json._embedded.sorts[0].arraySize, y: json._embedded.sorts[0].timeTaken}))
                   console.log(this.state.x + this.state.y);
                 });
  }

    render() {
    console.log("x " + this.state.x)
    console.log("y " + this.state.y)
    return (
      <Plot
        data={[
          {
            x: this.state.x,
            y: this.state.y,
            type: 'scatter',
            mode: 'lines+points',
            marker: {color: 'red'},
          },
        ]}
        layout={
        {
            width: 1000,
            height: 500,
            title: 'Sort Algorithm',
            xaxis: {
             title: 'Items in Array',
             titlefont: {
                 family: 'Courier New, monospace',
                 size: 18,
                 color: '#7f7f7f'
             }
            },
            yaxis: {
              title: 'Time Taken (Milliseconds)',
              titlefont: {
                  family: 'Courier New, monospace',
                  size: 18,
                  color: '#7f7f7f'
               }
            },
        }
        }
      />
    );
  }
}

export default Sort;
