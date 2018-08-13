package com.chaves.Heroes.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.chaves.Heroes.dao.HeroRepository;
import com.chaves.Heroes.domain.Heroes;
import com.chaves.Heroes.domain.ResponseTO;

public class HeroesBusinessImpl implements HeroesBusiness{

	@Autowired
	private HeroRepository repository;
	
	/** The Constant LOGGER. */
	static final Logger LOGGER = LoggerFactory.getLogger(HeroesBusinessImpl.class);

	/**
	 * @param hero
	 * @return boolean
	 */
	public ResponseTO insertNewHero(Heroes hero){
		
		LOGGER.info("[Business] Entering in insertNewHero method ----------");
		
		ResponseTO response = new ResponseTO();
		
		try {
			
			repository.save(hero);
			response.setResult(HeroesBusinessConstants.RESULT_OK);
			response.setCode(HeroesBusinessConstants.SUCCESS_CODE);
			
		} catch (Exception e) {
			LOGGER.info("[Business] Hero already exists!");
			response.setResult(HeroesBusinessConstants.RESULT_NOK);
			response.setCode(HeroesBusinessConstants.ERROR_CODE_USER_ALREADY_EXISTS);
			LOGGER.error("[Business] Error adding the new hero: " + e.getMessage());
			throw e;
		}
		
		LOGGER.info("[Business] Hero added with sucess!");
		
		return response;
	}
	
	/**
	 * @return List<Hero>
	 */
	public List<Heroes> getHeroes(){
		
		LOGGER.info("[Business] Entering in getHeroes method ----------");
		
		List<Heroes> heroList = new ArrayList<Heroes>();
		
		try {
			heroList = (List<Heroes>) repository.findAll();
		} catch (Exception e) {
			LOGGER.error("[Business] Error getting the heroes: " + e.getMessage());
			throw e;
		}
		
		LOGGER.info("[Business] Heroes found!");
		
		return heroList;
	}
	
	/**
	 * @param id
	 * @return Hero
	 */
	public Heroes getHeroByName(String name){
		
		LOGGER.info("[Business] Entering in getHeroByName method ----------");
		
		Heroes hero = new Heroes();
		
		try {
			hero = repository.findByName(name);
		} catch (Exception e) {
			LOGGER.error("[Business] Error getting the hero: " + e.getMessage());
			throw e;
		}
		
		LOGGER.info("[Business] Hero found: " + null != hero.getName() ? hero.getName() : null);
		
		return hero;
	}

	

	@Override
	public ResponseTO deleteHero(Heroes hero) {
		
		LOGGER.info("[Business] Entering in deleteHero method. Hero to be deleted: " +hero.getName());
		
		ResponseTO resp = new ResponseTO();
		
		try {
			repository.delete(hero);
			resp.setCode(HeroesBusinessConstants.SUCCESS_CODE);
			resp.setResult(HeroesBusinessConstants.RESULT_OK);
		} catch (Exception e) {
			LOGGER.error("[Business] Error getting the hero: " + e.getMessage());
			resp.setCode(HeroesBusinessConstants.ERROR_CODE_DELETING_USER);
			resp.setResult(HeroesBusinessConstants.RESULT_NOK);
			throw e;
		}
		
		LOGGER.info("[Business] Hero deleted!");
		
		return resp;
	}

	@Override
	public Heroes updateHero(Heroes hero) throws Exception {

		LOGGER.info("[Business] Entering in updateHero method. Hero to be updated: " +hero.getName());
		
		try {

		repository.findById(new Long(hero.getId())).orElseThrow(() -> new Exception("Error finding the Hero!"));
		repository.saveAndFlush(hero);
		
			
		} catch (Exception e) {
			LOGGER.error("[Business] Error updating the hero: " + e.getMessage());
			throw e;
		}
		LOGGER.info("[Business] Hero updated!");
		
		return hero;
	}
	
	@Override
	public List<Heroes> findByName(String name) throws Exception {

		LOGGER.info("[Business] Entering in findByName method. Name: " +name);
		
		List<Heroes> heroesList = new ArrayList<Heroes>(); 
		
		try {

		heroesList = repository.findAllByName(name);
			
		} catch (Exception e) {
			LOGGER.error("[Business] Error updating the hero: " + e.getMessage());
			throw e;
		}
		LOGGER.info("[Business] Hero updated!");
		
		return heroesList;
	}

	/**
	 * @return the repository
	 */
	public HeroRepository getRepository() {
		return repository;
	}

	/**
	 * @param repository the repository to set
	 */
	public void setRepository(HeroRepository repository) {
		this.repository = repository;
	}

}