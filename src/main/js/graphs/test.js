import React from 'react';
import Plot from 'react-plotly.js';

class Test extends React.Component {
    render() {
    return (
      <Plot
        data={[
          {
            x: [1, 2, 3],
            y: [2, 6, 3],
            type: 'scatter',
            mode: 'lines+points',
            marker: {color: 'red'},
          },
        ]}
        layout={ {width: 1000, height: 500, title: 'A Fancy Plot'} }
      />
    );
  }
}

export default Test;
