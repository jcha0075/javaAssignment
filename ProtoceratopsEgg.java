package game;

import edu.monash.fit2099.engine.*;

public class ProtoceratopsEgg extends Item {
	private int HatchRound = 5;
	
	public ProtoceratopsEgg(String name, char displayChar, boolean portable) {
		super(name, displayChar, portable);
	}
	
	public void tick(Location currentLocation) {
		this.HatchRound -= 1;
		if (this.HatchRound == 0) {
			currentLocation.removeItem(this);
			currentLocation.addActor(new BabyProtoceratops("Baby Protoceratops"));
			currentLocation.getGround().EggHatched();
		}else if(this.HatchRound == 1) {
			System.out.println("Set to egg hatching");
			currentLocation.getGround().EggHatching();
		}
	}
}
