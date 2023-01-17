package com.developer.tutor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class TutorVO {
	
	private String userId;
	private String info;
	private String imgPath;
	private int starAvg;
	private int applyOk;

}
