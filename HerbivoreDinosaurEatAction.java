package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

public class HerbivoreDinosaurEatAction extends Action {
	private HerbivourDinosaur target;
	
	public HerbivoreDinosaurEatAction(HerbivourDinosaur target) {
		this.target = target;
	}
	public String execute(Actor actor, GameMap map) {
		if (map.locationOf(target).getGround().getClass() == Grass.class) {
			target.addFoodLevel(5);
			map.locationOf(target).setGround(new Dirt());
			return target + "Eat grass!";
		}else if (map.locationOf(target).getGround().getClass() == Tree.class) {
			target.addFoodLevel(10);
			map.locationOf(target).setGround(new Floor());
			return target + "Eat tree";
		}else {
			target.addFoodLevel(50);
			List <Item> location = map.locationOf(actor).getItems();
			for (int i = 0; i < location.size(); i++) {
				if (location.get(i).getClass() == HerbivoreFood.class) {
					map.locationOf(actor).removeItem(location.get(i));
					return "The herbivore food has been eat";
				}
			}
			return null;
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
