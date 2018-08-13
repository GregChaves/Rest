package com.chaves.Heroes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaves.Heroes.business.HeroesBusiness;
import com.chaves.Heroes.domain.Heroes;
import com.chaves.Heroes.domain.ResponseTO;

/**
 * @author gbritoch
 *
 */
@RestController
public class HeroesController {

	/** The Constant LOGGER. */
	static final Logger LOGGER = LoggerFactory.getLogger(HeroesController.class);
	
	@Autowired
	private HeroesBusiness heroesBusiness;

	/**
	 * @return
	 * @throws ExceptionO
	 */
	@RequestMapping(value = HeroesControllerConstants.GET_HEROES, method = RequestMethod.POST)
	public List<Heroes> getHeroes() throws Exception {
		
		LOGGER.info("[Controller] Entering in getHeroes method!");

		List<Heroes> listHero = this.heroesBusiness.getHeroes();
		
		LOGGER.info("[Controller] Heroes returned with success!");
		
		return listHero;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = HeroesControllerConstants.NEW_HERO, method = RequestMethod.POST)
	public Heroes addNewHero(@RequestBody Heroes hero) throws Exception {
		
		LOGGER.info("[Controller] Entering in addNewHero method. name: " + hero.getName());
		hero.setStatus(0);
		ResponseTO response = new ResponseTO();

		response = this.heroesBusiness.insertNewHero(hero);
		
		LOGGER.info("[Controller] Hero inserted with success: " + response.getResult());
		
		return hero;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = HeroesControllerConstants.GET_HEROES_BY_NAME, method = RequestMethod.POST)
	public Heroes getHeroByName(@PathVariable String name) throws Exception {
		
		LOGGER.info("[Controller] Entering in addNewHero. Name: " + name);
		
		Heroes heroTO = this.heroesBusiness.getHeroByName(name);
		
		LOGGER.info("[Controller] Hero found: " + heroTO.getName());
		
		return heroTO;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = HeroesControllerConstants.DELETE_HERO, method = RequestMethod.POST)
	public ResponseTO deleteHero(@RequestBody Heroes hero) throws Exception {
		
		LOGGER.info("[Controller] Entering in deletehero method. name: " + hero.getName());
		
		ResponseTO responseTO = this.heroesBusiness.deleteHero(hero);
		
		LOGGER.info("[Controller] Hero deleted: " + responseTO.getResult());
		
		return responseTO;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = HeroesControllerConstants.UPDATE_HERO, method = RequestMethod.POST)
	public Heroes updateHero(@RequestBody Heroes hero) throws Exception {
		
		LOGGER.info("[Controller] Entering in updateHero method. Hero: " + hero.getName());
		
		hero = this.heroesBusiness.updateHero(hero);
		
		LOGGER.info("[Controller] Hero updated: " + hero.getName());
		
		return hero;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = HeroesControllerConstants.FIND_TERM, method = RequestMethod.POST)
	public List<Heroes> findByTerm(@PathVariable String name) throws Exception {
		
		LOGGER.info("[Controller] Entering in findByTerm method. Term: " + name);
		
		List<Heroes> listHero = this.heroesBusiness.findByName(name);
		
		return listHero ;
	}

	/**
	 * @return the heroesBusiness
	 */
	public HeroesBusiness getHeroesBusiness() {
		return heroesBusiness;
	}

	/**
	 * @param heroesBusiness the heroesBusiness to set
	 */
	public void setHeroesBusiness(HeroesBusiness heroesBusiness) {
		this.heroesBusiness = heroesBusiness;
	}

}