package com.zf.service.impl;

import com.zf.dao.ResumeMapper;
import com.zf.model.Resume;
import com.zf.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService{
    @Resource
    private ResumeMapper resumeMapper;

    @Override
    public boolean add(Resume resume) {
        return resumeMapper.add(resume);
    }

    @Override
    public boolean update(Resume resume) {
        return resumeMapper.update(resume);
    }

    @Override
    public Resume queryUserId(int userId) {
        return resumeMapper.queryUserId(userId);
    }

    @Override
    public Resume queryById(int id) {
        return resumeMapper.queryById(id);
    }

    @Override
    public List<Resume> queryAll() {
        return resumeMapper.queryAll();
    }

    @Override
    public List<Resume> queryPage(int currentRow, int pageSize) {
        return resumeMapper.queryPage(currentRow,pageSize);
    }
}
