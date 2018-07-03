package org.deie.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/AuthorizationFilter")
public class AuthorizationFilter implements Filter {

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthorizationFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		this.context.log("Requested Resource::" + uri);

		HttpSession session = req.getSession(false);

		String path = ((HttpServletRequest) request).getRequestURI();

		if (path.endsWith(".html")) {

			if (path.endsWith("/index.html")) {

				chain.doFilter(request, response); // Just continue chain.
			} else {
				// Do your business stuff here for all paths other than
				// /specialpath.

				if (session != null) {
					String userName = (String) session.getAttribute("userName");

					if (userName != null) {
						if (userName.equals("admin")) {
							chain.doFilter(request, response);

						} else {
							this.context.log("Login First");
							res.sendRedirect("index.html");
						}

					} else {

						this.context.log("No user Name");
						res.sendRedirect("index.html");
					}

				} else {

					this.context.log("Unauthorized access request");
					res.sendRedirect("index.html");
				}

			}

		} else {
			chain.doFilter(request, response); // Just continue chain.
		}
	}

	public void destroy() {
		// close any resources here
	}

}