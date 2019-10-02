package game;

import edu.monash.fit2099.engine.*;

public class BuyProtoceratopsEggsAction extends Action {
	private Player player;
	
	public BuyProtoceratopsEggsAction(Player player) {
		this.player = player;
	}

	public String execute(Actor actor, GameMap map) {
		int player_balance = this.player.getBalance();
		if (player_balance < 50) {
			return "Player has not enough money!";
		}else {
			this.player.addItemToInventory(new ProtoceratopsEgg("Protoceratops Egg",'e',true));
			this.player.DeductBalance(50);
			return "$50 is deducted! Protoceratops Egg is added to player's inventory";
		}
	}

	public String menuDescription(Actor actor) {
		return "Buy Protoceratops Egg";
	}
	
	public String hotkey() {
		return "l";
	}

}
