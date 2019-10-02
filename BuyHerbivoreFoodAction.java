package game;

import edu.monash.fit2099.engine.*;

public class BuyHerbivoreFoodAction extends Action{
	private Player player;
	
	public BuyHerbivoreFoodAction(Player player) {
		this.player = player;
	}

	public String execute(Actor actor, GameMap map) {
		int player_balance = this.player.getBalance();
		if (player_balance < 20) {
			return "Player has not enough money!";
		}
		else {
			this.player.addItemToInventory(new HerbivoreFood("Herbivore Food",'f',true));
			this.player.DeductBalance(20);
			return "$20 is deducted! Herbivore Food is added to player's inventory";
		}
	}

	public String menuDescription(Actor actor) {
		return "Buy Herbivore Food";
	}
	
	public String hotkey() {
		return "9";
	}

}
