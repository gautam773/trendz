package com.trendz.userrole;

import java.util.List;

public interface UserroleService {

public void insert(Userrole ur);
	
	public void update(Userrole ur);
	
	public void delete(int urid);
	
	public Userrole getUserRole(int urid);
	
	public List<Userrole> ListUserrole();
    
}
