package com.developer.users;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class UsersDAOOracle implements UsersDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UsersDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}	

	@Override
	public List<UsersVO> selectAll() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UsersVO> list = session.selectList("com.developer.users.selectAll");
		
		return list;
	}
	
	
	public static void main(String[] args) throws FindException {
		UsersDAOOracle dao = new UsersDAOOracle();
		System.out.println("?");
		System.out.println(dao.selectAll());
		System.out.println("===");
	}

	@Override
	public List<UsersVO> selectTutor() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UsersVO> tList = session.selectList("com.developer.users.selectTutor");
		return tList;
	}

}
