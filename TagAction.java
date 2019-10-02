package game;
import java.util.List;

import edu.monash.fit2099.engine.*;

public class TagAction extends Action{
	private Actor target;
	
	public TagAction(Actor target) {
		this.target = target;
	}

	public String execute(Actor actor, GameMap map) {
		List<Item> PlayerInventory = actor.getInventory();
		for (int i = 0; i < PlayerInventory.size(); i++) {
			if (PlayerInventory.get(i).getClass() == DinosaurTag.class) {
				actor.addBalance(100);
				map.removeActor(this.target);
				return this.target + " has been sold!";
			}
		}
		return "player has no tag!";
	}

	public String menuDescription(Actor actor) {
		return "Tag " + this.target;
	}
	
	public String hotkey() {
		return "x";
	}

}
