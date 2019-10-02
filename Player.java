package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

/**
 * Class representing the Player.
 */
public class Player extends Actor {

	private Menu menu = new Menu();
	private int balance;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.balance = 1000;
	}

	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		return menu.showMenu(this, actions, display);
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void DeductBalance(int price) {
		this.balance -= price;
	}
	
	public void addBalance(int price) {
		this.balance += price;
	}
	public void addFoodLevel(int amount) {}

	public int getFoodLevel() {
		return 0;
	}
}
