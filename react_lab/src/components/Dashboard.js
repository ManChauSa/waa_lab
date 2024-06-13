import React, { useState,useEffect } from 'react';
import Posts from './post/Posts';
import '../css/post.css';
import PostDetail from './post/PostDetail';
import AddPost from './post/AddPost';

export default function Dashboard() {
    const [fetchFlag, setFetchflag] = useState(true);

    const changeFetchFlag = () => {
        setFetchflag(!fetchFlag);
    }
    useEffect(() => {
        return () => {
          console.log("Something was unmounted");
        };
      }, [fetchFlag]);

      const [selectedState, setSelectedState] = useState(0);
    const setSelected = (id) => {
        setSelectedState(id);
    }

    return (
        <div className='dashboard'>
            <div className='list_post'>        
                <Posts  
                setSelected={setSelected}
                fetchFlag ={fetchFlag}
                />   
            </div>
            <div className='post_detail'>   
                <PostDetail 
                    postId={selectedState} 
                    changeFetchFlag={changeFetchFlag} />
            </div>
            <div className='add_post'>
                <AddPost/>
            </div>
        </div>
    );
};

