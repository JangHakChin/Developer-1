package com.developer.users;

import java.util.List;

import com.developer.exception.FindException;

public interface UsersDAO {
	
	//회원목록출력 
	public List<UsersVO> selectAll() throws FindException;
	
	//미승인 튜터 목록 출력
	public List<UsersVO> selectTutor() throws FindException;

}
