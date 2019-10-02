package game;
import java.util.List;

import edu.monash.fit2099.engine.*;

public abstract class HerbivourDinosaur extends Actor{
	protected int FoodLevel;
	protected int MaxFoodLevel = 50;
	protected Behaviour behaviour;
	
	public HerbivourDinosaur(String name, char DisplayChar, int Hitpoint, int StartingFoodLevel) {
		super(name, DisplayChar, Hitpoint);
		this.FoodLevel = StartingFoodLevel;
		behaviour = new WanderBehaviour();
	}
	
	
	protected Location GetFoodSource(Actor actor, GameMap map) {
		Location actor_location = map.locationOf(actor);
		int actor_location_x = actor_location.x();
		int actor_location_y = actor_location.y();
		int[] x_cood = {0,-1,1,0,0,-1,1,-1,1};
		int[] y_cood = {0,0,0,-1,1,-1,-1,1,1};
		while (true) {
			for (int i = 0; i<9; i++) {
				int x_target = actor_location_x + x_cood[i];
				int y_target = actor_location_y + y_cood[i];
				if ((x_target <= 79) && (x_target >= 0) && (y_target <= 24) && (y_target >= 0)) {
					if (map.at(x_target, y_target).getGround().getClass() == Tree.class || map.at(x_target, y_target).getGround().getClass() == Grass.class
							|| hasFood(map.at(x_target, y_target))) {
						return (map.at(x_target, y_target));
					}
				}
			}
			for (int i = 0; i<9; i++) {
				if (x_cood[i] < 0) {
					x_cood[i] -= 1;
				}else if (x_cood[i] > 0) {
					x_cood[i] += 1;
				}
				
				if (y_cood[i] < 0) {
					y_cood[i] -= 1;
				}else if (y_cood[i] > 0) {
					y_cood[i] += 1;
				}
			}
		}
		
	}
	private boolean hasFood(Location location) {
		List<Item> LocationInventory = location.getItems();
		for (int i = 0; i < LocationInventory.size(); i++) {
			if (LocationInventory.get(i).getClass() == HerbivoreFood.class) {
				return true;
			}
		}
		return false;
	}
	
	protected int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
	
	public void addFoodLevel(int amount) {
		this.FoodLevel += amount;
		if (this.FoodLevel > MaxFoodLevel) {
			this.FoodLevel = MaxFoodLevel;
		}		
	}
	public int getFoodLevel() {
		return this.FoodLevel;
	}
	
	public void addBalance(int amount) {}
	
}
