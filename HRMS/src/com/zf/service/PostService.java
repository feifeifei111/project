package com.zf.service;

import com.zf.model.Post;

import java.util.List;

public interface PostService {
    boolean add(Post post);
    Post queryById(int id);
    List<Post> queryAll();
}
