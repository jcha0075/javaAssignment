package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

public class SellProtoceratopsCorpseAction extends Action{
	private Player player;
	
	public SellProtoceratopsCorpseAction(Player player) {
		this.player = player;
	}

	public String execute(Actor actor, GameMap map) {
		List <Item> PlayerInventory = this.player.getInventory();
		for (int i = 0; i < PlayerInventory.size(); i++) {
			if (PlayerInventory.get(i).toString().equals("dead Protoceratops")) {
				this.player.removeItemFromInventory(PlayerInventory.get(i));
				this.player.addBalance(15);
				return "Protoceratops corpse has been sold!";
			}
		}
		return "Player has no protoceratops corpse";
	}

	public String menuDescription(Actor actor) {
		return "Sell Protoceratops Corpse";
	}
	
	public String hotkey() {
		return "0";
	}

}
