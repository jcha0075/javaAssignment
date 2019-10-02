package game;

import edu.monash.fit2099.engine.*;

public class LayEggAction extends Action{
	
	private Item dinasour_egg;
	
	public LayEggAction(Actor target) {
		if (target.getClass() == Protoceratops.class) {
			this.dinasour_egg = new ProtoceratopsEgg("Protoceratops Egg", 'e', true);
		}else {
			this.dinasour_egg = new VelociraptorsEgg("Velociraptors Egg", 'E', true);
		}
	}

	public String execute(Actor actor, GameMap map) {
		map.locationOf(actor).addItem(this.dinasour_egg);
		return actor + " lay an egg!";
	}

	@Override
	public String menuDescription(Actor actor) {
		return null;
	}

}
