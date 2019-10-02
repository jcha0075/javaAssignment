package game;


import edu.monash.fit2099.engine.*;

public class CarnivourDinosaurEatAction extends Action {
	private Item Meat;
	
	public CarnivourDinosaurEatAction(Item Meat) {
		this.Meat = Meat;
	}
	public String execute(Actor actor, GameMap map) {
		if (this.Meat.getClass() == CarnivourFood.class) {
			actor.addFoodLevel(100);
		}else if (this.Meat.getClass() == ProtoceratopsEgg.class) {
			actor.addFoodLevel(10);
		}else {
			actor.addFoodLevel(50);
		}
		return actor + " has eaten " + this.Meat;
	}
	
	public String menuDescription(Actor actor) {
		return null;
	}
	
	public String hotkey() {
		return null;
	}
}
