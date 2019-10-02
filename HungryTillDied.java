package game;

import edu.monash.fit2099.engine.*;

public class HungryTillDied extends Action{

	public String execute(Actor actor, GameMap map) {
		Item corpse = new PortableDinoItem("dead " + actor, '%');
		map.locationOf(actor).addItem(corpse);

		Actions dropActions = new Actions();
		for (Item item : actor.getInventory())
			dropActions.add(item.getDropAction());
		for (Action drop : dropActions)		
			drop.execute(actor, map);
		map.removeActor(actor);
		return actor + "has died";
	}
	
	public String menuDescription(Actor actor) {
		return null;
	}
	
	public String hotkey() {
		return null;
	}
	
}
