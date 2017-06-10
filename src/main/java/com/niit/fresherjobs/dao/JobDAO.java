package com.niit.fresherjobs.dao;

import java.util.List;

import com.niit.fresherjobs.model.Job;

public interface JobDAO {
	public boolean saveOrUpdate(Job job);

	public boolean delete(Job job);

	public List<Job> list();
}
