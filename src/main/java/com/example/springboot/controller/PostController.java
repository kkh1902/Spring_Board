package com.example.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PostController {

    @GetMapping("/")
    public String main(){
        return "index";
    }

    /* 글 작성 */
    @GetMapping("/posts/write")
    public String write(){
        return "posts/posts-write";
    }

    /* 글 상세보기 */

    /* 글 수정 */

    /* 글 삭제 */

}
