package com.ucaitop.tb.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ucaitop.tb.dao.CommentDao;
import com.ucaitop.tb.dao.impl.CommentDaoImpl;
import com.ucaitop.tb.domain.Comment;

import com.ucaitop.tb.service.CommentService;
import com.ucaitop.tb.util.GetGson;

public class CommentServiceImpl implements CommentService {
	//创建comment数据层对象
	CommentDao cd = new CommentDaoImpl();
	@Override
	public String findComments(String proid) {
		//调用持久层查找数据的方法。
		List<Comment> commList = null;
		try {
			commList = cd.selectComments(proid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//调用工具类，转成json数据
		String commJson = GetGson.getJson(commList);
		//将转换好的json数据返回
		return commJson;
	}

	@Override
	public void addComment(String comm, String user, String product,Date comDate) {
		// TODO Auto-generated method stub
		//创建一个评论对象
		Comment comment = new Comment();
		//将数据存入对象comment.
		comment.setComid(UUID.randomUUID().toString());
		comment.setComtime(comDate);
		comment.setUserid(user);
		comment.setProid(product);
		comment.setComments(comm);
		
		//调用底层的插入数据库的方法
		try {
			cd.insertComments(comment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
