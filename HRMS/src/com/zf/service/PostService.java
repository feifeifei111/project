package com.zf.service;

import com.zf.model.Post;

import java.util.List;

public interface PostService {
    boolean add(Post post);
    boolean delete(int id);
    Post queryById(int id);
    List<Post> queryAll();
    List<Post> queryByDeptId(int deptId);
}
