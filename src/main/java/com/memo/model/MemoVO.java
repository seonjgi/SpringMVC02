package com.memo.model;
import java.util.Date;

import lombok.*;


@Getter
@Setter
@ToString(includeFieldNames = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemoVO {
	
	private int idx;
	private String name;
	private String msg;
	private Date wdate;
	
}

