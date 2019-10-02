package game;

import edu.monash.fit2099.engine.*;
import java.util.*;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {

	private Random rand = new Random();
	private boolean change = false;
	private boolean canEnter = true;
	
	public Dirt() {
		super('.');
	}
	public void EggHatching() {
		this.canEnter = false;
	}
	
	public void EggHatched() {
		this.canEnter = true;
	}
	
	public boolean canActorEnter(Actor actor) {
		return this.canEnter;
	}
	
	public void tick(Location location) {
		GameMap locationMap = location.map();
		int current_x = location.x();
		int current_y = location.y();
//		System.out.printf("%d, %d",current_x, current_y);
		
		
		
		
		float ranNum = rand.nextFloat();
		if (change) {
			location.setGround(new Tree());
			return;
		}
		if (current_x != 0 && current_x != 79 && current_y != 0 && current_y != 24) {
			if (locationMap.at(current_x + 1, current_y).getDisplayChar() == '+' || 
					locationMap.at(current_x + 1, current_y).getDisplayChar() == 't' ||
					locationMap.at(current_x + 1, current_y).getDisplayChar() == 'T' ||
					locationMap.at(current_x, current_y + 1).getDisplayChar() == '+' ||
					locationMap.at(current_x, current_y + 1).getDisplayChar() == 't' ||
					locationMap.at(current_x, current_y + 1).getDisplayChar() == 'T' ||
					locationMap.at(current_x, current_y - 1).getDisplayChar() == '+' || 
					locationMap.at(current_x, current_y - 1).getDisplayChar() == 't' ||
					locationMap.at(current_x, current_y - 1).getDisplayChar() == 'T' ||
					locationMap.at(current_x - 1, current_y).getDisplayChar() == '+' || 
					locationMap.at(current_x - 1, current_y).getDisplayChar() == 't' ||
					locationMap.at(current_x - 1, current_y).getDisplayChar() == 'T' ) {
					//If beside has tree then do:
				if (ranNum < 0.005) {
					change = true;
				}
			}
			else {
				if (ranNum < 0.005) {
					location.setGround(new Grass());
				}			
			}
		}
		else {
			if (current_x == 0) {
				if (current_y == 0) {
					if (locationMap.at(current_x + 1, current_y).getDisplayChar() == '+' || 
						locationMap.at(current_x + 1, current_y).getDisplayChar() == 't' ||
						locationMap.at(current_x + 1, current_y).getDisplayChar() == 'T' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == '+' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == 't' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == 'T') {
						//If beside has tree then do:
						if (ranNum < 0.005) {
							change = true;
						}
					}
					else {
						if (ranNum < 0.005) {
							location.setGround(new Grass());
						}			
					}
				}
				else if (current_y == 24) {
					if (locationMap.at(current_x + 1, current_y).getDisplayChar() == '+' || 
						locationMap.at(current_x + 1, current_y).getDisplayChar() == 't' ||
						locationMap.at(current_x + 1, current_y).getDisplayChar() == 'T' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == '+' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == 't' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == 'T') {
						//If beside has tree then do:
						if (ranNum < 0.005) {
							change = true;	
						}
					}
					else {
						if (ranNum < 0.05) {
							location.setGround(new Grass());
						}			
					}
				}
				else {
					if (locationMap.at(current_x + 1, current_y).getDisplayChar() == '+' || 
						locationMap.at(current_x + 1, current_y).getDisplayChar() == 't' ||
						locationMap.at(current_x + 1, current_y).getDisplayChar() == 'T' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == '+' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == 't' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == 'T' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == '+' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == 't' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == 'T') {
						//If beside has tree then do:
						if (ranNum < 0.005) {
							change = true;	
						}
					}
					else {
						if (ranNum < 0.005) {
							location.setGround(new Grass());
						}
					}
				}
			}
			else if (current_x == 79) {
				if (current_y == 0) {
					if (locationMap.at(current_x - 1, current_y).getDisplayChar() == '+' || 
						locationMap.at(current_x - 1, current_y).getDisplayChar() == 't' ||
						locationMap.at(current_x - 1, current_y).getDisplayChar() == 'T' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == '+' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == 't' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == 'T') {
						//If beside has tree then do:
						if (ranNum < 0.005) {
							change = true;	
						}
					}
					else {
						if (ranNum < 0.005) {
							location.setGround(new Grass());
						}
					}
				}
				else if (current_y == 24) {
					if (locationMap.at(current_x - 1, current_y).getDisplayChar() == '+' || 
						locationMap.at(current_x - 1, current_y).getDisplayChar() == 't' ||
						locationMap.at(current_x - 1, current_y).getDisplayChar() == 'T' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == '+' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == 't' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == 'T') {
						//If beside has tree then do:
						if (ranNum < 0.005) {
							change = true;	
						}
					}
					else {
						if (ranNum < 0.005) {
							location.setGround(new Grass());
						}
					}
				}
				else {
					if (locationMap.at(current_x - 1, current_y).getDisplayChar() == '+' || 
						locationMap.at(current_x - 1, current_y).getDisplayChar() == 't' ||
						locationMap.at(current_x - 1, current_y).getDisplayChar() == 'T' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == '+' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == 't' ||
						locationMap.at(current_x, current_y - 1).getDisplayChar() == 'T' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == '+' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == 't' ||
						locationMap.at(current_x, current_y + 1).getDisplayChar() == 'T') {
						//If beside has tree then do:
						if (ranNum < 0.005) {
							change = true;	
						}
					}
					else {
						if (ranNum < 0.005) {
							location.setGround(new Grass());
						}
					}	
				}
			}
			else if (current_y == 0 && (current_x != 0 && current_x != 79)) {
				if (locationMap.at(current_x - 1, current_y).getDisplayChar() == '+' || 
					locationMap.at(current_x - 1, current_y).getDisplayChar() == 't' ||
					locationMap.at(current_x - 1, current_y).getDisplayChar() == 'T' ||
					locationMap.at(current_x + 1, current_y).getDisplayChar() == '+' || 
					locationMap.at(current_x + 1, current_y).getDisplayChar() == 't' ||
					locationMap.at(current_x + 1, current_y).getDisplayChar() == 'T' ||
					locationMap.at(current_x, current_y + 1).getDisplayChar() == '+' ||
					locationMap.at(current_x, current_y + 1).getDisplayChar() == 't' ||
					locationMap.at(current_x, current_y + 1).getDisplayChar() == 'T') {
					//If beside has tree then do:
					if (ranNum < 0.005) {
						change = true;
					}
				}
				else {
					if (ranNum < 0.005) {
						location.setGround(new Grass());
					}
				}
			}
			else if (current_y == 24 && (current_x != 0 && current_x != 79)) {
				if (locationMap.at(current_x - 1, current_y).getDisplayChar() == '+' || 
					locationMap.at(current_x - 1, current_y).getDisplayChar() == 't' ||
					locationMap.at(current_x - 1, current_y).getDisplayChar() == 'T' ||
					locationMap.at(current_x + 1, current_y).getDisplayChar() == '+' || 
					locationMap.at(current_x + 1, current_y).getDisplayChar() == 't' ||
					locationMap.at(current_x + 1, current_y).getDisplayChar() == 'T' ||
					locationMap.at(current_x, current_y - 1).getDisplayChar() == '+' ||
					locationMap.at(current_x, current_y - 1).getDisplayChar() == 't' ||
					locationMap.at(current_x, current_y - 1).getDisplayChar() == 'T') {
					//If beside has tree then do:
					if (ranNum < 0.005) {
						change = true;
					}
				}
				else {
					if (ranNum < 0.005) {
						location.setGround(new Grass());
					}
				}
			}
		}
	}
}
