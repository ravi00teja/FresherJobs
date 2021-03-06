package com.niit.fresherjobs.daoimpl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.fresherjobs.dao.ForumDAO;
import com.niit.fresherjobs.model.Forum;

@SuppressWarnings("deprecation")
@Repository(value="forumDAO")
public class ForumDAOImpl implements ForumDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(Forum forum) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<Forum> list() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Forum.class);
		@SuppressWarnings("unchecked")
		List<Forum> list=c.list();
		return list;
	}
@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Forum getforum(int id) {
		String hql = "from Forum where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
@Transactional
public List<Forum> userlist() {
	String hql= "from Forum where status='a'";
	@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Forum> list=query.list();
	if(list==null){
	return null;
	}
	else{
		return list;
	}
}

@Transactional
public Forum get(int id) {
	String hql = "from Forum where id='"+ id+"'" ;
	@SuppressWarnings("rawtypes")
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Forum>list= query.list();
	
	if(list==null)
	{
		return null;
	}
	else
	{
		return list.get(0);
	}
}
}
