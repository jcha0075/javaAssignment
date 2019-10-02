package game;


import edu.monash.fit2099.engine.*;
import java.util.*;


/**
 * A herbivorous dinosaur.
 *
 */
public class Velociraptors extends CarnivourDinosaur {
	// Will need to change this to a collection if Protoceratops gets additional Behaviours.
	private Random rand = new Random();

	/** 
	 * Constructor.
	 * All Protoceratops are represented by a 'd' and have 100 hit points.
	 * 
	 * @param name the name of this Protoceratops
	 */
	public Velociraptors(String name, int FoodLevel) {
		super(name, 'D', 100, FoodLevel, 100);
	}

	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		return actions;
	}
	
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(50, "punches");
	}

	/**
	 * Figure out what to do next.
	 * 
	 * FIXME: Protoceratops wanders around at random, or if no suitable MoveActions are available, it
	 * just stands there.  That's boring.
	 * 
	 * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		this.FoodLevel -= 1;
		if (FoodLevel == 0) {
			return new HungryTillDied();
		}else if (FoodLevel >= 50 && rand.nextFloat() > 0.95 && !HasEgg(map.locationOf(this))) {
			return new LayEggAction(this);
		}else {
			if (this.FoodLevel <= 30) {//Velociraptors is hungry 
				//IF current location has corpse or egg eat it
				Location current_location = map.locationOf(this);
				if (hasFood(current_location)) {
					List<Item> current_location_item = current_location.getItems();
					for (int i = 0; i < current_location_item.size(); i ++) {
						if (current_location_item.get(i).getClass() == ProtoceratopsEgg.class ||
								current_location_item.get(i).toString().equals("dead Protoceratops")) {
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
		
	}
	private boolean HasEgg(Location location) {
		List <Item> location_item = location.getItems();
		for (int i = 0; i < location_item.size(); i++) {
			if (location_item.get(i).getClass() == ProtoceratopsEgg.class || location_item.get(i).getClass() == VelociraptorsEgg.class) {
				return true;
			}
		}
		return false;
	}
	public void addBalance(int amount) {};
	
}