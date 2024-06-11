import React from "react";

const PostDetail =(post) =>{
    console.log(post)
    return(
        <div className="detail_content">
            <h3 className='detail-title'>{post.post.title}</h3>
            <h3>{post.post.author}</h3>
            <p>{post.post.content}</p>
            <div className="btn_group">                
                <button onClick={post.post.deleteButtonClicked}>Delete</button>
                <button onClick={post.post.editButtonClicked}>Edit</button>
            </div>
        </div>
    )

}

export default PostDetail;