package com.wcig.app.dao.sample;

import com.wcig.app.model.User;

public interface SelectMapper {
    User selectByPk(Long id);
}
