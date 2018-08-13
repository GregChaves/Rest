package com.chaves.Heroes.controller;

/**
 * The Class ControllerConstant.
 *
 * @author gbritoch
 *
 */
public class HeroesControllerConstants {
	
	/**
	 * The Constant NEW_HERO
	 */
	public static final String NEW_HERO = "/newhero";
	
	/**
	 *  The Constant GET_HEROES
	 */
	public static final String GET_HEROES = "/getHeroes";
	
	/**
	 *  The Constant GET_HEROES_BY_ID
	 */
	public static final String GET_HEROES_BY_NAME = "/getHero/{name}";
	
	public static final String DELETE_HERO = "/deletehero";
	
	public static final String UPDATE_HERO = "/updatehero";
	
	public static final String FIND_TERM = "/findByTerm/{name}";
	
	/**
	 * The Constant CONSUMES_APPLICATION_JSON
	 */
	public static final String CONSUMES_APPLICATION_JSON = "application/json";
	
	/** The Constant VIEW_JSON */
	public static final String VIEW_JSON = "jsonView";

	/** The Constant APPLICATION_JSON */
	public static final String APPLICATION_JSON = "application/json";

	/** The Constant HEADER_NAME_CONTENT_DISPOSITION */
	public static final String HEADER_NAME_CONTENT_DISPOSITION = "content-disposition";

	/** The Constant URL_REQUEST_RESPONSE_INTERNAL_ERROR */
	public static final Integer URL_REQUEST_RESPONSE_INTERNAL_ERROR = 500;

	/** The Constant URL_REQUEST_RESPONSE_BAD_REQUEST */
	public static final Integer URL_REQUEST_RESPONSE_BAD_REQUEST = 400;
	
	/**
	 * The Constant CACHE_CONTROL
	 */
	public static final String CACHE_CONTROL = "Cache-Control";
	
	/**
	 * The Constant NO_CACHE 
	 */
	public static final String NO_CACHE = "no-cache";
	
	/**
	 * The Constant HEADER_CONTENT_TYPE_WITH_CHARSET_UTF8
	 */
	public static final String HEADER_CONTENT_TYPE_WITH_CHARSET_UFT8 = "application/json;charset=UTF-8";

}
