const React = require('react');
const ReactDOM = require('react-dom');

import Sort from './graphs/sort'
import Test from './graphs/test'

class App extends React.Component {

  render() {
    return (
        <Test />
    )
  }
}

ReactDOM.render(
	<App />,
	document.getElementById('app')
)




