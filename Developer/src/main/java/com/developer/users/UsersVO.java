package com.developer.users;

import com.developer.tutor.TutorVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class UsersVO{
	
	private String userId;
	private int role;
	private String pwd;
	private String nickname;
	private String name;
	private String email;
	private String tel;
	private String addr;
	private TutorVO tutorVO;

}
