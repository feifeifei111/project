package com.zf.service.impl;

import com.zf.dao.PostMapper;
import com.zf.model.Post;
import com.zf.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Resource
    private PostMapper postMapper;

    @Override
    public boolean add(Post post) {
        return postMapper.add(post);
    }

    @Override
    public boolean delete(int id) {
        return postMapper.delete(id);
    }

    @Override
    public Post queryById(int id) {
        return postMapper.queryById(id);
    }

    @Override
    public List<Post> queryAll() {
        return postMapper.queryAll();
    }

    @Override
    public List<Post> queryByDeptId(int deptId) {
        return postMapper.queryByDeptId(deptId);
    }
}
