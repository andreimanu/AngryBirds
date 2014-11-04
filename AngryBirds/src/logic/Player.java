package logic;

import java.util.ArrayList;

public class Player {
	private int points;
	private boolean canMove;
	private ArrayList<Bird> birds;
	private Board board;
	
	public Player(int birdsNumber, Board board) {
		super();
		
		for(int i = 0; i < birdsNumber; i++) {
			do {
			birds.add(new Bird(0,board.getRows().get(0)));
			}
			while(!board.getRows().get(0).getCells().get(i).hasBird());
		}
		canMove = true;
		setPoints(0);
	}
	
	public Bird getActiveBird() {
		for(Bird b : birds) {
			if(b.isActive())
				return b;
		}
		return null;
	}
	public boolean getMove() {
		return canMove;
	}
	
	public void setMove(boolean move) {
		this.canMove = move;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void incrementPoints(int pts) {
		setPoints(getPoints() + pts);
	}
	
}
