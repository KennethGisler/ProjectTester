package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Player;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Oct 11, 2022
 */
public class PlayerHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ProjectTester");
	/**
	 * 
	 */
	public PlayerHelper() {
		super();
	}

	//insert a Player
	public void insertPlayer(Player p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	//show all players
	public List<Player> showAllPlayers(){
		EntityManager em = emfactory.createEntityManager();
		List<Player> allPlayers = em.createQuery("SELECT s FROM Player s").getResultList();
		return allPlayers;
	}
	
	//search Methods
	public Player findPlayer(String name, String army) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Player> tq = em.createQuery("select p from Player p where p.playerName = :selectedPlayerName and p.army = :selectedArmy",Player.class);
		tq.setParameter("selectedPlayerName", name);
		tq.setParameter("selectedArmy", army);
		
		tq.setMaxResults(1);
		
		Player playerFound;
		try {
			playerFound = tq.getSingleResult();
		} catch (NoResultException ex) {
			playerFound = new Player(name,army);
		}
		
		em.close();
		return playerFound;
	}
}
