package com.ucaitop.tb.dao;

import java.sql.SQLException;
import java.util.List;

import com.ucaitop.tb.domain.Comment;

/**
 * 评论的持久层接口
 * @author AZTQ
 *
 */
public interface CommentDao {
	/**
	 * 查找商品所有评论的方法
	 */
	List<Comment> selectComments(String proId)throws SQLException;
	/**
	 * 添加商品的评价 
	 */
	void insertComments(Comment commet)throws SQLException;
	
	/**
	 * 删除评论
	 * boolean delComment(Comment comment);
	 */
}