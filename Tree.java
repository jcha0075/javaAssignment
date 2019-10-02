package game;

import edu.monash.fit2099.engine.*;

public class Tree extends Ground {
	private int age = 0;
	private boolean canEnter = true;

	public Tree() {
		super('+');
	}
	
	public void EggHatching() {
		this.canEnter = false;
	}
	
	public boolean canActorEnter(Actor actor) {
		return this.canEnter;
	}
	
	public void EggHatched() {
		this.canEnter = true;
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);

		age++;
		if (age == 10)
			displayChar = 't';
		if (age == 20)
			displayChar = 'T';
	}
}
