package com.ucaitop.tb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 关于字符集的修改设置一个方便修改的过滤器，剩的每个页面都要修改
 * 过滤器的声明周如下
 * 1，实例化在web.xml中配置过滤器
 * 2，通过init()方法进行初始化
 * 3，执行dofilter()方法中的操作，或者说是符合规定的情况下，执行chain.doFilter()方法放行请求和响应
 * 4，在整个应用结束后执行destroy()方法。
 * @author AZTQ
 *
 */
public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//为了确定过滤器的用法可以在这个方法中试着打印一个字符串
		System.out.println("filter init......");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//我们将在这个方法中设置执行的方法，有一点就是过滤器只能执行到chain.dofilter()方法，之后的任何代码都不会执行。
		//获取到httpServletRequest与httpServletResponse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//设置编码
		res.setContentType("text/html:charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		
		//让chain对象执行dofilter()方法，放行请求与相应
		chain.doFilter(req, res);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// 要确定什么时候程序进行结束，可以在这个方法只能怪试着打印一个字符串
		
		System.out.println("filter destroy......");
	}

}
