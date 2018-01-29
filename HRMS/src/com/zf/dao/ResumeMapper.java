package com.zf.dao;

import com.zf.model.Resume;

import java.util.List;

public interface ResumeMapper {
    boolean add(Resume resume);
    boolean update(Resume resume);
    Resume queryUserId(int userId);
    Resume queryById(int id);
    List<Resume> queryAll();
    List<Resume> queryPage(int currentRow, int pageSize);
}
