
package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

public class VelociraptorsEgg extends Item {
	private int HatchRound = 5;
	
	
	public VelociraptorsEgg(String name, char displayChar, boolean portable) {
		super(name, displayChar, portable);
	}
	
	public void tick(Location currentLocation) {
		this.HatchRound -= 1;
		if (this.HatchRound == 0) {
			currentLocation.removeItem(this);
			currentLocation.addActor(new BabyVelociraptors("Baby Velociraptors"));
			currentLocation.getGround().EggHatched();
		}else if(this.HatchRound == 1) {
			System.out.println("Set to egg hatching");
			currentLocation.getGround().EggHatching();
		}
	}
	public List<Action> getAllowableActions() {
		return allowableActions.getUnmodifiableActionList();
	}
}
