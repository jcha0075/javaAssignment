package game;

import edu.monash.fit2099.engine.*;

public class GiveDinosaurTagAction extends Action {
	private Player player;

	public GiveDinosaurTagAction(Player player) {
		this.player = player;
	}
	
	public String execute(Actor actor, GameMap map) {
		this.player.addItemToInventory(new DinosaurTag("Dinosaur Tag", 'y', true));
		return "Dinosaur tag has added to player's inventory";
	}

	public String menuDescription(Actor actor) {
		return "Get Dinosaur tag.";
	}

	public String hotkey() {
		return "g";
	}
	
}
