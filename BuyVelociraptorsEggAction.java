
package game;

import edu.monash.fit2099.engine.*;

public class BuyVelociraptorsEggAction extends Action {
	private Player player;
	
	public BuyVelociraptorsEggAction(Player player) {
		this.player = player;
	}

	public String execute(Actor actor, GameMap map) {
		int player_balance = this.player.getBalance();
		if (player_balance < 1000) {
			return "Player has not enough money!";
		}else {
			this.player.addItemToInventory(new VelociraptorsEgg("Velociraptors Egg",'E',true));
			this.player.DeductBalance(1000);
			return "$1000 is deducted! Velociraptors Egg is added to player's inventory";
		}
	}

	public String menuDescription(Actor actor) {
		return "Buy Velociraptors Egg";
	}
	
	public String hotkey() {
		return "]";
	}

}
