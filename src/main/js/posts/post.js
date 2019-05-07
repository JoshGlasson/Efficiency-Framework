import React from 'react';
import Comment from './comment';
const client = require('../client');

class Post extends React.Component {
  constructor(props) {
    super(props)
    this.state = {comments: [], likes: [], userid: document.getElementById("userid").value, toggle: null, likeid: 0, username: null, commenter: null};
    console.log(this.state.userid);
    this.getComments = this.getComments.bind(this);
    this.sendComment = this.sendComment.bind(this);
    this.id = this.props.post._links.self.href.split("/")[this.props.post._links.self.href.split("/").length-1];
    this.Likes= this.Likes.bind(this);
    client({method: 'GET', path: '/api/likes/search/findByPostid?postid=' + this.id}).then(response => {
              this.setState({likes: response.entity._embedded.likes.map(like => {return like.userid.toString();})});
              console.log(this.state.likes);
              this.state.toggle = this.state.likes.includes(this.state.userid);
         });
     client({method: 'GET', path: '/api/likes/search/findByPostidAndUserid?postid='+ this.id +'&userid='+ this.state.userid}).then(response => {
                    console.log(response.entity._embedded.likes[0]._links.self.href.split("/")[response.entity._embedded.likes[0]._links.self.href.split("/").length-1])
                    this.setState({likeid: response.entity._embedded.likes[0]._links.self.href.split("/")[response.entity._embedded.likes[0]._links.self.href.split("/").length-1]})
                    console.log(this.state.likeid)
                });
     client({method: 'GET', path: '/api/users/'+ this.props.post.userid}).then(response => {
                console.log("USERID"+ this.props.post.userid);
                console.log(response);
                this.setState({username: response.entity.name});
              });


    }

  // response.entity._embedded.likes[0]._links.self.href.split("/")[response.entity._embedded.likes[0]._links.self.href.split("/").length-1]

  componentDidMount() {
    client({method: 'GET', path: '/api/comments/search/findByPostid?post_id=' + this.id}).then(response => {
      this.setState({comments: response.entity._embedded.comments});
    });
  }


render () {
let commentBox;
if(this.state.userid !== "") {
commentBox =
<div class="card">
     <div class="card-header" id={"heading"+this.id}>
         <h2 class="mb-0">
             <button class="btn btn-link" type="button" data-toggle="collapse" data-target={"#collapseTwo"+this.id} aria-expanded="true" aria-controls={"collapseTwo"+this.id}>
                 Add Comment
             </button>
         </h2>
     </div>

     <div id={"collapseTwo"+this.id} class="collapse" aria-labelledby={"heading"+this.id} >
         <div class="card-body">
             <div class="form-group">
             <form onSubmit={this.sendComment} action="/">
                           <input type="text" class="form-control" id={"comment-text"+this.id}  placeholder="What would you like to say?"></input>
                           <a href="/"><button type="button" class="btn btn-primary" onClick={this.sendComment} >Submit</button></a>
               </form>
              </div>
         </div>
     </div>
</div>
}

	return (
		<div className='post-main'>
		    <div className='post-name'>
                <strong>{this.state.username}</strong>
            </div>

			<div className='post-content'>
				{this.props.post.content.split("\n").map((i,key) => {
                       return <div key={key}>{i}</div>;
                   })}
			</div>

			<div className='post-time'>
                <small>{this.props.post.time_stamp}</small>
            </div>

            <div className='post-likes'>
                <button onClick={this.Likes} type="button" class={this.state.toggle ? "btn btn-primary" : "btn btn-light"}>
                 {this.state.toggle ? 'Unlike' : 'Like'} {this.state.likes.length}
                </button>
            </div>

            <br />
            <div className='comments-item'>
                <div class="card">
                     <div class="card-header" id={"comments"+this.id}>
                         <h2 class="mb-0">
                             <button class="btn btn-link" type="button" data-toggle="collapse" data-target={"#collapse"+this.id} aria-expanded="true" aria-controls={"collapse"+this.id}>
                                 <h5>View Comments</h5>
                             </button>
                         </h2>
                     </div>

                     <div id={"collapse"+this.id} class="collapse" aria-labelledby={"comments"+this.id}>
                         <div class="card-body">
                             {this.getComments()}
                         </div>
                     </div>
                {commentBox}
                </div>
            </div>
        </div>
	)
    }

     getComments() {
        console.log(this.state.toggle);

        return this.state.comments.map(comment =>
            <Comment key={comment._links.self.href} comment={comment}/>
    		);
      }

      sendComment() {
          if(this.state.userid !== "") {
              const date = new Date();
              console.log(document.getElementById("comment-text"+this.id).value);
              console.log("Begining fetch comment");
              console.log(this.id);
              fetch('/api/comments', {
                        method: 'POST',
                        headers: {
                          'Accept': 'application/json',
                          'Content-Type': 'application/json',
                        },
                        body: JSON.stringify({
                          content: document.getElementById("comment-text"+this.id).value ,
                          time_stamp: date.getFullYear() + "/" + ((date.getMonth() + 1) > 9 ? date.getMonth() + 1 : '0' + (date.getMonth() + 1)) + "/" + (date.getDate() > 9 ? date.getDate() : '0' + date.getDate()) + " " + (date.getHours() > 9 ? date.getHours() : '0' + date.getHours()) + ":" + (date.getMinutes() > 9 ? date.getMinutes() : '0' + date.getMinutes()) + ":" + (date.getSeconds() > 9 ? date.getSeconds() : '0' + date.getSeconds()) ,
                          postid: this.id,
                          userid: this.state.userid,
                        })
                      })
           }
      }

//let formatted_date = date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate() + " " + date.datetime.getHours() + ":" + date.datetime.getMinutes() + ":" + date.datetime.getSeconds()

      Likes() {

      if(this.state.userid !== "") {
      if(this.state.toggle) {
      console.log("Pre Fetch")
      client({method: 'GET', path: '/api/likes/search/findByPostidAndUserid?postid='+ this.id +'&userid='+ this.state.userid}).then(response => {
               console.log(response.entity._embedded.likes[0]._links.self.href.split("/")[response.entity._embedded.likes[0]._links.self.href.split("/").length-1])
               this.setState({likeid: response.entity._embedded.likes[0]._links.self.href.split("/")[response.entity._embedded.likes[0]._links.self.href.split("/").length-1]})
               console.log(this.state.likeid)
               fetch('/api/likes/'+ this.state.likeid, {
                               method: 'DELETE',
                               headers: {
                                 'Accept': 'application/json',
                                 'Content-Type': 'application/json',
                               },
                             })
           });


              console.log("Post Fetch")
        this.state.likes.splice(this.state.likes.indexOf(this.state.userid));
      } else {
      console.log("Pre Fetch")

        fetch('/api/likes', {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            postid: this.id,
            userid: this.state.userid,
          })
        })
        console.log("Post Fetch")

        this.state.likes.push(this.state.userid);
      }
      return this.setState(state => ({toggle: !state.toggle}));
      }
      }


}
export default Post;


// props.post._links.self.href.split("/").length-1 gives us the 5th element of the array which is our post ID
