package com.ucaitop.tb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ucaitop.tb.dao.CommentDao;
import com.ucaitop.tb.domain.Comment;
import com.ucaitop.tb.util.C3P0Util;
import com.ucaitop.tb.util.DBUtil;

public class CommentDaoImpl implements CommentDao {
	
	//根据id查询所有的id
	@Override
	public List<Comment> selectComments(String proId) throws SQLException {
		//创建dataSource
		QueryRunner qr = new QueryRunner(C3P0Util.getDatasourse());
		//创建操作数据库对象，并接受返回值
		List<Comment> list = qr.query("select * from tb_comm where=?", new BeanListHandler<Comment>(Comment.class),proId);
		//返回值
		return list;
	}
	//根据传递回来的信息，添加一条评论信息
	@Override
	public void insertComments(Comment commet) throws SQLException {
		// TODO Auto-generated method stub
		//创建操作数据库的的对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDatasourse());
		//开始操作数据库
		qr.update("insert into tb_comm values (?,?,?,?,?)",commet.getComid(),commet.getComments(),commet.getComtime(),commet.getUserid(),commet.getProid());
	}

}
