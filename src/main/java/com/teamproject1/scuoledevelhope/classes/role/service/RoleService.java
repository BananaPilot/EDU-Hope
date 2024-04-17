package com.teamproject1.scuoledevelhope.classes.role.service;

import com.teamproject1.scuoledevelhope.classes.role.dao.RoleDao;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleDao roleDao;

    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
