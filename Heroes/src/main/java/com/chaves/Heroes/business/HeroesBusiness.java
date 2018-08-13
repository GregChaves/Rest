package com.chaves.Heroes.business;

import java.util.List;

import com.chaves.Heroes.domain.Heroes;
import com.chaves.Heroes.domain.ResponseTO;

public interface HeroesBusiness {
	
	/**
	 * @param Heroes
	 * @return ResponseTO
	 */
	public ResponseTO insertNewHero(Heroes hero);

	/**
	 * @return List<Hero>
	 */
	public List<Heroes> getHeroes();

	/**
	 * @param name
	 * @return Hero
	 */
	public Heroes getHeroByName(String name);
	
	/**
	 * @param name
	 * @return ResponseTO
	 */
	public ResponseTO deleteHero(Heroes hero);
	
	/**
	 * @param Heroes
	 * @return Hero
	 * @throws Exception 
	 */
	public Heroes updateHero(Heroes hero) throws Exception;

	/**
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Heroes> findByName(String name) throws Exception;
	
}
