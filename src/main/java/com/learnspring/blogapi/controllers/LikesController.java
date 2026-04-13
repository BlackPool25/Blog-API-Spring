package com.learnspring.blogapi.controllers;

import com.learnspring.blogapi.models.Users;
import com.learnspring.blogapi.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/{post_id}/add-like")
    public String addLike(@PathVariable Integer post_id, Authentication authentication) {
        return likesService.addLike(post_id, authentication);
    }

    @GetMapping("/{post_id}/get-likes")
    public long getLikes(@PathVariable Integer post_id) {
        return likesService.getLikes(post_id);
    }

    @PostMapping("{post_id}/remove-like")
    public String removeLike(@PathVariable Integer post_id, Authentication authentication) {
        return likesService.removeLike(post_id, authentication);
    }
}
