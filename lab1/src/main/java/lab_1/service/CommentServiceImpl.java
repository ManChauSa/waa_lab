package lab_1.service;

import lab_1.entity.Comment;
import lab_1.entity.dto.response.UpdateCommentDto;
import lab_1.repo.CommentRepo;
import lab_1.repo.PostRepo;
import lab_1.service.Interface.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    CommentRepo commentRepo;
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepo commentRepo, PostRepo postRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }

    @Override
    public void addComment(UpdateCommentDto comment) {
        var post = postRepo.findById(comment.getPost_id())
                .orElseThrow(()-> new RuntimeException("Post not found"));
        var newComment = commentRepo.save(modelMapper.map(comment, Comment.class));
        post.getComments().add(newComment);
        postRepo.save(post);
    }


}
