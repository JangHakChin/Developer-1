package com.developer.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//DAO를 구현하는 객체
public class Factory {
	private static SqlSessionFactory sqlSessionFactory;
	// 초기화 블록:멤버 변수 초기화하는 블록
	static {
		try {
			String resource = "com/developer/resource/config.xml"; //DB와 관련된 config.xml (DB설정내용)
			Reader reader = Resources.getResourceAsReader(resource); //문자 단위로 읽는 stream

			if (sqlSessionFactory == null) {
				//사용할 sqlSessionFactory 객체 생성
				//	Builder :  객체 생성에 필요한 설정이 가능하고, 설정한 내용으로 객체를 생성해줌
				//	build(): config.xml 의 내용을 설정에 활용하여 설정
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

				//구현할 Mapper 등록
				Class[] mapper = { com.developer.users.UsersDAO.class }; //mapper 여러개를 담을 배열, 여기에 mapper 파일 다 등록 시킴
				for (Class m : mapper) {
					//sqlSessionFactory에 Mapper를 등록
					sqlSessionFactory.getConfiguration().addMapper(m); //배열에 담긴 Mapper를 꺼내서 sqlSessionFactory로 구현체를 만든다.
				}
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory; //sqlSessionFactory 객체를 return
	}
}