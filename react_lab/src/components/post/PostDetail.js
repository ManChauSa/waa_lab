import axios from "axios";
import React, { useState ,useEffect} from 'react';
import Comment from "./Comment";

const PostDetail =(props) =>{
    const [postDetail, setPostDetail] = useState({});

    useEffect (()=>{
        if(props.postId !== 0){
            axios.get('http://localhost:8080/post/' + props.postId)
            .then(response =>{
                setPostDetail(response.data)
            })
            .catch(err => console.log(err.message))
        }
    },
    [props.postId])

    const deletePostClick = (postId)=>{
        axios.delete('http://localhost:8080/post/' + postId)
        .then(response =>{
            window.location.reload();
        })
        .catch(err =>{
            console.error(err);
        })
    }
    if(props.postId !== 0){
        return(
        <div className="detail_content">
            <h3 className='detail-title'>{postDetail.title}</h3> 
            <h3>{postDetail.author}</h3>
            <p>{postDetail.content}</p>
            <div className="list_comment">
                <p>Comments</p>
                {
                    postDetail.comments !=  null ? postDetail.comments.map(comment =>{
                        return <Comment comment = {comment.name} key ={comment.id}/>
                    }) : <p>No comment</p>
                }
            </div>
            <div className="btn_group">                
                <button onClick={()=> {deletePostClick(props.postId)}} >Delete</button>
            </div>
        </div>
    )

    }else return null;   

}

export default PostDetail;