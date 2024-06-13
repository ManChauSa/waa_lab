import axios from "axios";
import React, { useState ,useEffect, useContext} from 'react';
import Comment from "./Comment";
import { SelectedPostId } from "../../context/SelectedPostId";

const PostDetail =(props) =>{
    const [postDetail, setPostDetail] = useState({});
    const selectedPostId = useContext(SelectedPostId);

    console.log(selectedPostId.selectedPostIdState)

    useEffect (()=>{
        if(selectedPostId.selectedPostIdState !== 0){
            axios.get('http://localhost:8080/post/' + selectedPostId.selectedPostIdState)
            .then(response =>{
                setPostDetail(response.data)
            })
            .catch(err => console.log(err.message))
        }
    },
    [selectedPostId.selectedPostIdState])

    const deletePostClick = (postId)=>{
        axios.delete('http://localhost:8080/post/' + postId)
        .then(response =>{
            window.location.reload();
        })
        .catch(err =>{
            console.error(err);
        })
    }
    if(selectedPostId.selectedPostIdState !== 0){
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
                <button onClick={()=> {deletePostClick(selectedPostId.selectedPostIdState)}} >Delete</button>
            </div>
        </div>
    )

    }else return null;   

}

export default PostDetail;