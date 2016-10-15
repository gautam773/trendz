package com.trendz.userrole;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserroleServiceImpl implements UserroleService {

	@Autowired
	UserroleDAO udao;

	@Override
	public void insert(Userrole ur) {
		// TODO Auto-generated method stub
		udao.insert(ur);
	}

	@Override
	public void update(Userrole ur) {
		// TODO Auto-generated method stub
		udao.update(ur);
	}

	@Override
	public void delete(int urid) {
		// TODO Auto-generated method stub
		udao.delete(urid);
	}

	@Override
	public Userrole getUserRole(int urid) {
		// TODO Auto-generated method stub
		return udao.getUserRole(urid);
	}

	@Override
	public List<Userrole> ListUserrole() {
		// TODO Auto-generated method stub
		return udao.ListUserrole();
	}
	
	
	
		
	}

	
