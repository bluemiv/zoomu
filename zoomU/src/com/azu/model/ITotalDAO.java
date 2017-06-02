package com.azu.model;

public interface ITotalDAO {
	public boolean insert(Object obj) throws Exception;
	public boolean delete(Object obj) throws Exception;
	public boolean update(Object obj) throws Exception;	
}
