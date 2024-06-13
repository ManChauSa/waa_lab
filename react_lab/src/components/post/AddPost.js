import axios from "axios";
import React from "react";
import { useRef } from 'react';

const AddPost =(props)=>{
    const newPostForm = useRef();
    const addPost =()=>{
        const form = newPostForm.current;
        const data ={
            title: form['title'].value,
            content: form['content'].value,
            author: form['author'].value
        }

        axios.post('http://localhost:8080/post',data)
        .then(response =>{
            window.location.reload();
        })
        .catch(err =>{
            console.error(err);
        })
    }

    return (
        <div className="add_post_form">
            <form ref={newPostForm}>
                <h1> Add Post</h1>
                <div className="input_content">
                    <label>Title</label>
                    <input type="text" label={'title'} name={'title'} />

                    <label>Content</label>
                    <input type="text" label={'content'} name={'content'} />

                    <label>Author</label>
                    <input type="text" label={'author'} name={'author'} />
                </div>
            </form>

            <button onClick={addPost} > Add </button>
        </div>
    );
}
export default AddPost