import React from 'react';

const Post = (props) => {
	return (
		<div className='post-main'>
			<div className='post-content'>
				{props.post.content.split("\n").map((i,key) => {
                                               return <div key={key}>{i}</div>;
                                           })}
			</div>
			<div className='post-time'>
                {props.post.time_stamp}
            </div>
            <a href={"post/"+props.post._links.self.href.split("/")[props.post._links.self.href.split("/").length-1]+"/comment"}>Comment!</a>
		</div>
	)
}

export default Post;


// props.post._links.self.href.split("/").length-1 gives us the 5th element of the array which is our post ID
