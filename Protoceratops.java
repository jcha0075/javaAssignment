package game;


import edu.monash.fit2099.engine.*;
import java.util.*;


/**
 * A herbivorous dinosaur.
 *
 */
public class Protoceratops extends HerbivourDinosaur {
	// Will need to change this to a collection if Protoceratops gets additional Behaviours.
	private Random rand = new Random();

	/** 
	 * Constructor.
	 * All Protoceratops are represented by a 'd' and have 100 hit points.
	 * 
	 * @param name the name of this Protoceratops
	 */
	public Protoceratops(String name, int FoodLevel) {
		super(name, 'd', 100, FoodLevel);
	}

	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		if (otherActor.getClass() == Player.class) {
			actions.add(new FeedHerbivoreDinosaurAction(this));
		}
		if (this.FoodLevel >= 30 && this.hitPoints >= 80 && otherActor.getClass() == Player.class) {
			actions.add(new TagAction(this));
		}
		if (otherActor.getClass() == Velociraptors.class) {
			actions.add(new AttackAction(this));
		}
		return actions;
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
		}
		else if (FoodLevel <= 10) {
			Location food_source_location = GetFoodSource(this, map);
			Location dino_location = map.locationOf(this);
			int CurrentDistance = distance(food_source_location, dino_location);
			if (CurrentDistance == 0) {
				return new HerbivoreDinosaurEatAction(this);
			}
			for (Exit exit : dino_location.getExits()) {
				Location destination = exit.getDestination();
				if (destination.canActorEnter(this)) {
					int newDistance = distance(destination, food_source_location);
					if (newDistance < CurrentDistance) {
						return new MoveActorAction(destination, exit.getName());
					}
				}
			}
			return new DoNothingAction();
			
		}
		else {
			if (FoodLevel >= 20 && rand.nextFloat() > 0.01 && !HasEgg(map.locationOf(this))) {
				return new LayEggAction(this);
			}
			Action wander = behaviour.getAction(this, map);
			if (wander != null)
				return wander;
			
			return new DoNothingAction();
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