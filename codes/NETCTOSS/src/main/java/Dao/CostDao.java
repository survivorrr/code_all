package Dao;

import java.util.List;

import entity.Cost;

public interface CostDao {
	List<Cost> findAll();
	void save(Cost c);
	Cost findById(int id);
	void update(Cost c);
}
