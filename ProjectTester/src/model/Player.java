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
@Table(name="player")
public class Player {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="PLAYERNAME")
	private String playerName; //the players name. Ted Smith, Jhon Doe, ext...
	@Column(name="ARMY")
	private String army; //this would be the name of the faction being played. An example being Space Marines, Imperial Guard, Chaos, ext...
	//we were gunna call army armyName, but I think army is fine. less letters easy to type.
	/**
	 * 
	 */
	//constructors
	public Player() {
		super();
	}
	public Player(int id, String name, String army) {
		this.id = id;
		playerName = name;
		this.army = army;
	}
	public Player(String name, String army) {
		playerName = name;
		this.army = army;
	}
	
	//getters
	public int getId() {
		return id;
	}
	public String getPlayerName() {
		return playerName;
	}
	public String getArmy() {
		return army;
	}
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public void setArmy(String army) {
		this.army = army;
	}

	//methods
	@Override
	public String toString() {
		return "[Player Name: " + playerName + ",Army Name: " + army + ", ID: " + id +"]";
	}
}
