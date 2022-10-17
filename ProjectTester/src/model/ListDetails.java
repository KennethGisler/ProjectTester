package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Oct 10, 2022
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	private String listName; //we had this penned as "name", changing it to listName for a bit more specificity.
	private LocalDate dateAdded; //the date that the list was added or built
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Player player; //the player
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	private List<Unit> roster; //the army list player is useing or has.
	
	//private int totalPoints; Let's think about adding this cause it could be a nice touch. Tally up the total cost of the army that the player has.
	
	/**
	 * 
	 */
	//constructors
	public ListDetails() {
		super();
	}
	public ListDetails(int id, String name, LocalDate ld, Player player, List<Unit> ul) {  //defalut no arg followed by the three I think we will need. One has all, the next all but id, the last, all but id and list
		this.id = id;
		listName = name;
		dateAdded = ld;
		this.player = player;
		roster = ul;
	}
	public ListDetails(String name, LocalDate ld, Player player, List<Unit> ul) {
		listName = name;
		dateAdded = ld;
		this.player = player;
		roster = ul;
	}
	public ListDetails(String name, LocalDate ld, Player player) {
		listName = name;
		dateAdded = ld;
		this.player = player;
	}
	
	//getters
	public int getId() {
		return id;
	}
	public String getListName() {
		return listName;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public Player getPlayer() {
		return player;
	}
	public List<Unit> getRoster() {
		return roster;
	}
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void setRoster(List<Unit> roster) {
		this.roster = roster;
	}
	
	//methods
	@Override
	public String toString() {
		return "[List Name: " + listName + ", Date Added: " + dateAdded + ", Player Info: " + player.toString() + ", Roster:" + roster + "]";
	}
}
