package com.zf.dao;

import com.zf.model.Post;

import java.util.List;

public interface PostMapper {
    boolean add(Post post);
    Post queryById(int id);
    List<Post> queryAll();
}
