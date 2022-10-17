import java.time.LocalDate;
import java.util.List;

import controller.ListDetailsHelper;
import controller.PlayerHelper;
import controller.UnitHelper;
import model.ListDetails;
import model.Player;
import model.Unit;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unit test1 = new Unit("Guardsmen","Troop",50);
		Unit test2 = new Unit("Company Commander", "HQ",30);
		Unit test3 = new Unit ("Leman Russ", "Heavy Support", 150);
		
		UnitHelper uh = new UnitHelper();
		
		uh.insertUnit(test1);
		uh.insertUnit(test2);
		uh.insertUnit(test3);
		
		List<Unit> test = uh.showAllUnits();
		
		for(int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i).toString());
		}
		
		Player play1 = new Player("Ken","IG");
		Player play2 = new Player("Hunter","Chaos Knights");
		
		PlayerHelper ph = new PlayerHelper();
		
		//ph.insertPlayer(play1);
		//ph.insertPlayer(play2);
		
		//List<Player> players = ph.showAllPlayers();
		
		//for(int i = 0; i < players.size(); i++) {
		//	System.out.println(players.get(i).toString());
		//}
		
		LocalDate ld = null;
		ListDetails myList = new ListDetails("Army 1", ld.now(),play1,test);
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ldh.insertListDetails(myList);
		
		List<ListDetails> theLists = ldh.getLists();
		
		for(int i = 0; i < theLists.size(); i++) {
			System.out.println(theLists.get(i).toString());
		}
	}

}
