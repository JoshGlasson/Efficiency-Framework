const React = require('react');
const ReactDOM = require('react-dom');

import Sort from './graphs/sort'

class App extends React.Component {

  render() {
    return (
        <Sort />
    )
  }
}

ReactDOM.render(
	<App />,
	document.getElementById('app')
)




