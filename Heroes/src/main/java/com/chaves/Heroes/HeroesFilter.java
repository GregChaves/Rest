package com.chaves.Heroes;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HeroesFilter implements Filter {

	/** The Constant LOGGER. */
	static final Logger LOGGER = LoggerFactory.getLogger(HeroesFilter.class);
	
	private static final String PRAGMA_NO_CACHE = "no-cache";

	private static final String ZERO_EXPIRES = "0";

	/** The Constant REQUEST_PRAGMA. */
	private static final String REQUEST_PRAGMA = "Pragma";

	/** The Constant REQUEST_EXPIRES. */
	private static final String REQUEST_EXPIRES = "Expires";

	/** The Constant REQUEST_CACHE_CONTROL. */
	private static final String REQUEST_CACHE_CONTROL = "Cache-Control";

	/** The Constant REQUEST_ACCESS_CONTROL_ALLOW_CREDENTIALS. */
	private static final String REQUEST_ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";

	/** The Constant REQUEST_ACCESS_CONTROL_ALLOW_ORIGIN. */
	private static final String REQUEST_ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		LOGGER.info("Entering in doFilter");

		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest resquestHttp = (HttpServletRequest) request;

		res.addHeader(REQUEST_ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		res.addHeader(REQUEST_ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
		res.addHeader(REQUEST_CACHE_CONTROL, "no-cache, no-store, must-revalidate");
		res.addHeader(REQUEST_EXPIRES, ZERO_EXPIRES);
		res.addHeader(REQUEST_PRAGMA, PRAGMA_NO_CACHE);
		res.addHeader("Content-Type", "application/json");

		// CorsFilter
		if (resquestHttp.getMethod().equalsIgnoreCase("OPTIONS")) {
			res.setHeader("Access-Control-Allow-Headers", resquestHttp.getHeader("Access-Control-Request-Headers"));
		}
		
		LOGGER.info(resquestHttp.getHeaderNames().toString());
		res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS");
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}