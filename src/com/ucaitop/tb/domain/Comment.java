package com.ucaitop.tb.domain;

import java.util.Date;

/**
 * 评论实体类
 * @author AZTQ
 *
 */
public class Comment {
	
	private String comid;//评价id
	private Date comtime;//存储评论时间
	private String  userid;//绑定用户的id
	private String proid;//绑定商品id
	private int count;//评价数量
	private String comments;//评论
	
	
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public Date getComtime() {
		return comtime;
	}
	public void setComtime(Date comtime) {
		this.comtime = comtime;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getProid() {
		return proid;
	}
	public void setProid(String proid) {
		this.proid = proid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
}
