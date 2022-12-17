package com.memo.model;

import java.util.List;

public interface MemoDAO {
	
	int insertMemo(MemoVO mo);
	List<MemoVO> listMemo();
	int deleteMemo(int idx);
	int updateMemo(MemoVO momo);
	
	int getTotalCount();
	MemoVO getMemo(int idx);
}
