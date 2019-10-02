package game;

import edu.monash.fit2099.engine.*;

public class Grass extends Ground {
	
	private boolean canEnter = true;
	public Grass() {
		super('*');
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
