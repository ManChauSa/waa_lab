// import React from 'react';
import React, { useState ,useEffect} from 'react';
import axios from 'axios';
import Post from './Post';

const Posts = (props) => {
    console.log(props)
    const [postsState, setPostsState]= useState(
        [
            { id: 1, title: "Post 1", author: "Author 1",content:"This is content of post 1"},
            { id: 2, title: "Post 2", author: "Author 2",content:"This is content of post 2" },
            { id: 3, title: "Post 3", author: "Author 3",content:"This is content of post 3" }
        ]
    )
    
    const fetchPosts = () => {
        axios.get('http://localhost:8080/post')
            .then(response => {
                setPostsState(response.data);
            })
            .catch(error => {
                console.log(error.message)
            })
        }
    useEffect(() => {
        fetchPosts()
    },
    [props.fetchFlag]) 

   const posts = postsState.map(post =>{
     return <Post 
     id={post.id} 
     title={post.title}  
     author={post.author} 
     key={post.id}
     setSelected={() => { props.setSelected(post.id) }}/>
    });
    return posts;
};

export default Posts;
