package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

public class BabyVelociraptors extends CarnivourDinosaur{
	private int Turns = 30;

	public BabyVelociraptors(String name) {
		super("BabyVelociraptors", 'P', 50, 10, 50);
	}
	
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		FoodLevel -= 1;
		Turns -= 1;
		if (FoodLevel == 0) {
			return new HungryTillDied();
		}
		if (Turns == 0 && FoodLevel > 0) {
			return new EvolveAction(this);
		}
		else if (FoodLevel <= 20) {
			Location current_location = map.locationOf(this);
			if (hasFood(current_location)) {
				List<Item> current_location_item = current_location.getItems();
				for (int i = 0; i < current_location_item.size(); i ++) {
					if (current_location_item.get(i).getClass() == ProtoceratopsEgg.class ||
							current_location_item.get(i).equals("dead Protoceratops")) {
						Item meat = current_location_item.get(i);
						current_location.removeItem(current_location_item.get(i));
						return new CarnivourDinosaurEatAction(meat);
					}
				}
				return new DoNothingAction();
			}else {//If there is no food
				//Loop through actions
				for (int i = 0; i < actions.size(); i++) {
					if (actions.get(i).getClass() == AttackAction.class) {
						return actions.get(i);
					}
				}
				Action wander = behaviour.getAction(this, map);
				if (wander != null) {
					return wander;
				}
				return new DoNothingAction();
				
			}
			
		}else {//Velociraptors is not hungry
			for (int i = 0; i < actions.size(); i++) {
				if (actions.get(i).getClass() == AttackAction.class) {
					return actions.get(i);
				}
			}
			Action wander = behaviour.getAction(this, map);
			if (wander != null) {
				return wander;
			}
			return new DoNothingAction();
		}
	}
	
	public void addBalance(int amount) {};
}
