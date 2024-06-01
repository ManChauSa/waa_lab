package lab_1.controller;

import lab_1.entity.dto.response.UpdateCommentDto;
import lab_1.service.Interface.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addComment(@RequestBody UpdateCommentDto param){
        commentService.addComment(param);
    }
}
