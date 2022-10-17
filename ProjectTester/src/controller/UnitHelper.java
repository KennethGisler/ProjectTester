package controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Unit;

public class UnitHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ProjectTester");
	
	public UnitHelper() {
		super();
	}

	public void insertUnit(Unit u) { //add a unit
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Unit> showAllUnits() { //show all the units in the unit list (roster)
		EntityManager em = emfactory.createEntityManager();
		List<Unit> allUnits = em.createQuery("SELECT i FROM Unit i").getResultList();
		return allUnits;
	}
	
	public void deleteUnit(Unit unitToDelete) { //delete a specific item
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Unit> tq = em.createQuery("select u from Unit u where u.unitName = :selectedUnitName and u.unitType = :selectedUnitType and u.unitCost = :selectedUnitCost",Unit.class);
		
		tq.setParameter("selectedUnitName", unitToDelete.getUnitName());
		tq.setParameter("selectedUnitType", unitToDelete.getUnitType());
		tq.setParameter("selectedUnitCost", unitToDelete.getUnitCost());
		
		tq.setMaxResults(1);
		
		Unit result = tq.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	//search methods
	public List<Unit> searchForUnitByName(String name){ //find units by name
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Unit> tq = em.createQuery("select u from Unit u where u.unitName = :selectedUnitName", Unit.class);
		tq.setParameter("selectedUnitName", name);
		
		List<Unit> foundItems = tq.getResultList();
		em.close();
		
		return foundItems;
		
	}
	
	public List<Unit> searchForUnitByType(String type){ //find units by type
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Unit> tq = em.createQuery("select u from Unit u where u.unitType = :selectedUnitType", Unit.class);
		tq.setParameter("selectedUnitType", type);
		
		List<Unit> foundItems = tq.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public List<Unit> searchForUnitByCost(int cost){ //find Units by cost
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Unit> tq = em.createQuery("select u from Unit u where u.unitCost = :selectedUnitCost", Unit.class);
		tq.setParameter("selectedUnitCost", cost);
		
		List<Unit> foundItems = tq.getResultList();
		em.close();
		
		return foundItems;
		
	}
	
	public Unit searchForUnitById(int idToFind) { //find A unit by ID
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Unit found = em.find(Unit.class, idToFind);
		em.close();
		return found;
	}
	
	//update unit
	public void updateUnit(Unit unitToUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(unitToUpdate);
		em.getTransaction().commit();
		em.close();
	}
	
	//clean up
	public void cleanUp() {
		emfactory.close();
	}
	
}
