package com.zf.dao;

import com.zf.model.Resume;

public interface ResumeMapper {
    boolean add(Resume resume);
    boolean update(Resume resume);
    Resume queryUserId(int userId);
}
