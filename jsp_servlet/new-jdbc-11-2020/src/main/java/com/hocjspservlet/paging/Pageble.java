package com.hocjspservlet.paging;

import com.hocjspservlet.sort.Sorter;

public interface Pageble {
	Integer getPage();

	Integer getOffset();

	Integer getLimit();
	
	Sorter getSorter();
}
