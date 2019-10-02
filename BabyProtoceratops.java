package game;

import edu.monash.fit2099.engine.*;

public class BabyProtoceratops extends HerbivourDinosaur{
	private int Turns = 30;

	public BabyProtoceratops(String name) {
		super("BabyProtoceratops", 'p', 50, 10);
	}
	
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		if (otherActor.getClass() == Player.class) {
			actions.add(new FeedHerbivoreDinosaurAction(this));
		}
		if (otherActor.getClass() == Velociraptors.class) {
			actions.add(new AttackAction(this));
		}
		return actions;
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
			Action wander = behaviour.getAction(this, map);
			if (wander != null)
				return wander;
			
			return new DoNothingAction();
		}
	}
	
	public void addBalance(int amount) {};
}
