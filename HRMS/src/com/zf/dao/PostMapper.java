package com.zf.dao;

import com.zf.model.Post;

import java.util.List;

public interface PostMapper {
    boolean add(Post post);
    boolean delete(int id);
    boolean deleteByDeptId(int deptId);
    Post queryById(int id);
    List<Post> queryAll();
    List<Post> queryByDeptId(int deptId);
}
