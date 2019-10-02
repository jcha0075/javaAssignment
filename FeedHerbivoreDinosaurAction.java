package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

public class FeedHerbivoreDinosaurAction extends Action {
	private Actor target;
	
	public FeedHerbivoreDinosaurAction(Actor target) {
		this.target = target;
	}
	
	public String execute(Actor actor, GameMap map) {
		List <Item> PlayerInventory = actor.getInventory();
		for (int i = 0 ; i < PlayerInventory.size(); i++) {
			if (PlayerInventory.get(i).getClass() == HerbivoreFood.class) {
				actor.removeItemFromInventory(PlayerInventory.get(i));
				this.target.addFoodLevel(50);
				return "The food had been feed.";
			}
		}
		return "There is no food.";
	}

	public String menuDescription(Actor actor) {
		return "Feed " + this.target;
	}
	
	public String hotkey() {
		return "f";
	}

}
