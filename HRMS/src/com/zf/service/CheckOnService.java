package com.zf.service;

import com.zf.model.CheckOn;

public interface CheckOnService {
    boolean add(CheckOn checkOn);
    boolean update(CheckOn checkOn);
    CheckOn queryByToday(String today);
}
