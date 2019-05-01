import React from 'react';
import Comment from './comment';
const client = require('../client');

class Post extends React.Component {
  constructor(props) {
    super(props)
    this.state = {comments: []};
    this.getComments = this.getComments.bind(this);
  }

  componentDidMount() {
    client({method: 'GET', path: '/api/comments'}).then(response => {
      this.setState({comments: response.entity._embedded.comments});
    });
  }


render () {
	return (
		<div className='post-main'>
			<div className='post-content'>
				{this.props.post.content.split("\n").map((i,key) => {
                                               return <div key={key}>{i}</div>;
                                           })}
			</div>
			<div className='post-time'>
                {this.props.post.time_stamp}
            </div>
            <div className='comments-item'>
              				{this.getComments()}
              			</div>
            <a href={"post/"+this.props.post._links.self.href.split("/")[this.props.post._links.self.href.split("/").length-1]+"/comment"}>Comment!</a>
		</div>
	)
    }

     getComments() {
        return this.state.comments.map(comment =>
    			<Comment key={comment._links.self.href} comment={comment}/>

    		);
      }
}
export default Post;


// props.post._links.self.href.split("/").length-1 gives us the 5th element of the array which is our post ID
