import React from 'react';
import Comment from './comment';
const client = require('../client');

class Post extends React.Component {
//const id = this.props.post._links.self.href.split("/")[this.props.post._links.self.href.split("/").length-1];
  constructor(props) {
    super(props)
    this.state = {comments: [], likes: 0};
    this.getComments = this.getComments.bind(this);
    this.id = this.props.post._links.self.href.split("/")[this.props.post._links.self.href.split("/").length-1];
    this.Likes= this.Likes.bind(this);


  }

  componentDidMount() {
    client({method: 'GET', path: '/api/comments/search/findByPostid?post_id=' + this.id}).then(response => {
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
            <button onClick={this.Likes()}>
             Likes {this.state.likes}
            </button>
             <h5>Comments</h5>
            <div className='comments-item'>
              				{this.getComments()}
              			</div>
            <a href={"post/"+this.id+"/comment"}>Comment!</a>
		</div>
	)
    }

     getComments() {
        return this.state.comments.map(comment =>
    			<Comment key={comment._links.self.href} comment={comment}/>

    		);
      }

      Likes() {
       console.log(this.state.likes);
       return this.setState(state => ({likes: state.likes }));
      }
}
export default Post;


// props.post._links.self.href.split("/").length-1 gives us the 5th element of the array which is our post ID
