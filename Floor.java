package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

/**
 * A class that represents the floor inside a building.
 */
public class Floor extends Ground {
	private boolean canEnter = true;
	
	public Floor() {
		super('_');
	}
	
	public void EggHatching() {
		this.canEnter = false;
	}
	
	public void EggHatched() {
		this.canEnter = true;
	}
	
	public boolean canActorEnter(Actor actor) {
		return this.canEnter;
	}

}
