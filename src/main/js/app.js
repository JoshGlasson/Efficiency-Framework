const React = require('react');
const ReactDOM = require('react-dom');

import Sort from './graphs/sort'
import Test from './graphs/test'
import Reverse from './graphs/reverse'

class App extends React.Component {

  render() {
    return (
    <div>
        <Sort />
        <Reverse />
    </div>
    )
  }
}

ReactDOM.render(
	<App />,
	document.getElementById('app')
)




