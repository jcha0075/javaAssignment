package game;

import edu.monash.fit2099.engine.*;

public class EvolveAction extends Action {
	private Actor target;
	
	public EvolveAction(Actor target) {
		this.target = target;
	}
	
	public String execute(Actor actor, GameMap map) {
		if (this.target.getClass() == BabyProtoceratops.class) {
			Location actor_location = map.locationOf(target);
			int target_food_level = target.getFoodLevel();
			map.removeActor(target);
			map.addActor(new Protoceratops("Protoceratops", target_food_level), actor_location);
			return "Baby protoceratops is grown";
		}else {
			Location actor_location = map.locationOf(target);
			int target_food_level = target.getFoodLevel();
			map.removeActor(target);
			map.addActor(new Velociraptors("Velociraptors", target_food_level), actor_location);
			return "Baby velociraptors is grown";
		}
	}

	public String menuDescription(Actor actor) {
		return null;
	}
	
	public String hotkey() {
		return null;
	}
	
	public Action getNextAction() {
		return null;
	}
}
