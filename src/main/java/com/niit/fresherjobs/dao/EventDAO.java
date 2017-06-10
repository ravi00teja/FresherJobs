package com.niit.fresherjobs.dao;

import java.util.List;

import com.niit.fresherjobs.model.Event;

public interface EventDAO {

	public boolean saveOrUpdate(Event event);

	public boolean delete(Event event);

	public Event get(int id);

	public List<Event> list();

}
