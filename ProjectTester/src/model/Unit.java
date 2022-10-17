package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Oct 10, 2022
 */
@Entity
@Table(name="unit")
public class Unit {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="UNITNAME")
	private String unitName; //The name of the unit. Examples: Crisis Battlesuits, Conscipts, Gardsmen, Tactial Marines, ext...
	@Column(name="UNITTYPE")
	private String unitType; //was gunna be "class" but realized that we can't call it that. This is the unit designation: Heavy Support, Troop, HQ, ext...
	@Column(name="UNITCOST")
	int unitCost; //was gunna be unit price, just wanted to make it consistent with the names of the other variables. This will be how much a unit costs.
	/**
	 * 
	 */
	//constructors
	public Unit() {
		super();
	}
	public Unit(int id, String name, String type, int cost) { //constructor with/without id
		this.id = id;
		unitName = name;
		unitType = type;
		unitCost = cost;
	}
	public Unit(String name, String type, int cost) {
		unitName = name;
		unitType = type;
		unitCost = cost;
	}
	
	//getters
	public int getId() {
		return id;
	}
	public String getUnitName() {
		return unitName;
	}
	public String getUnitType() {
		return unitType;
	}
	public int getUnitCost() {
		return unitCost;
	}
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}
	
	//methods
	@Override
	public String toString() {
		return "[Unit Name: " + unitName + ", Unit Type: " + unitType + ", Point Cost: " + unitCost + ", ID: " +  id +"]"; 
	}
	
}
