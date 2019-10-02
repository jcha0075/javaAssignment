package game;

import edu.monash.fit2099.engine.*;

public class Shop extends Ground {
	private Player player;
	private Actions actions = new Actions();
	
	public Shop(Player player) {
		super('S');
		this.player = player;
		this.actions.add(new BuyHerbivoreFoodAction(this.player));
		this.actions.add(new BuyProtoceratopsEggsAction(this.player));
		this.actions.add(new GiveDinosaurTagAction(this.player));
		this.actions.add(new SellProtoceratopsEggsAction(this.player));
		this.actions.add(new SellProtoceratopsCorpseAction(this.player));
		this.actions.add(new BuyVelociraptorsEggAction(this.player));
	}
	
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	public Actions allowableActions(Actor actor, Location location, String direction){
		if (actor.getClass() != Player.class) {
			return new Actions();
		}
		return actions;
	}
	public void EggHatching() {}
	public void EggHatched() {}
	
}
