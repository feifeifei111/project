package com.zf.dao;

import com.zf.model.CheckOn;

public interface CheckOnMapper {
    boolean add(CheckOn checkOn);
    boolean update(CheckOn checkOn);
    CheckOn queryByToday(String today);
}
