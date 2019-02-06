package com.office.media.repository;

import org.springframework.stereotype.Repository;

import com.office.media.entity.Role;
import com.office.media.repositoryInterfaces.IRoleDAO;

@Repository
public class RoleDAO extends DAOAbstrac<Role> implements IRoleDAO{
	
	public RoleDAO() {
		super(Role.class);
	}

}
