package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

public class SellProtoceratopsEggsAction extends Action {
	private Player player;
	
	public SellProtoceratopsEggsAction(Player player) {
		this.player = player;
	}
	
	public String execute(Actor actor, GameMap map) {
		List <Item> PlayerInventory = this.player.getInventory();
		for (int i = 0; i < PlayerInventory.size(); i++) {
			if (PlayerInventory.get(i).getClass() == ProtoceratopsEgg.class) {
				this.player.removeItemFromInventory(PlayerInventory.get(i));
				this.player.addBalance(10);
				return "$10 is added! Protoceratops Egg is removed from player's inventory";
			}
		}
		return "Player has no protoceratops egg";
	}

	public String menuDescription(Actor actor) {
		return "Sell Protoceratops Egg";
	}
	
	public String hotkey() {
		return "s";
	}

}
