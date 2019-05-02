import React from 'react';
import Comment from './comment';
const client = require('../client');

class Post extends React.Component {
  constructor(props) {
    super(props)
    this.state = {comments: [], likes: [], userid: document.getElementById("userid").value, toggle: null};
    console.log(this.state.userid);
    this.getComments = this.getComments.bind(this);
    this.id = this.props.post._links.self.href.split("/")[this.props.post._links.self.href.split("/").length-1];
    this.Likes= this.Likes.bind(this);
    client({method: 'GET', path: '/api/likes/search/findByPostid?postid=' + this.id}).then(response => {
              this.setState({likes: response.entity._embedded.likes.map(like => {return like.userid.toString();})});
              console.log(this.state.likes);
              this.state.toggle = this.state.likes.includes(this.state.userid);
         });
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
            <div className='post-likes'>
                <button onClick={this.Likes}>
                 {this.state.toggle ? 'Dislike' : 'Like'} {this.state.likes.length}
                </button>
            </div>
             <h5>Comments</h5>
            <div className='comments-item'>
              				{this.getComments()}
              			</div>
            <a href={"post/"+this.id+"/comment"}>Comment!</a>
		</div>
	)
    }

     getComments() {

    console.log(this.state.toggle);

        return this.state.comments.map(comment =>
    			<Comment key={comment._links.self.href} comment={comment}/>

    		);
      }

      Likes() {



      if(this.state.toggle) {

      }

      }


}
export default Post;


// props.post._links.self.href.split("/").length-1 gives us the 5th element of the array which is our post ID
