package logic;

import java.util.ArrayList;

public class Player {
	private int points;
	private boolean canMove;
	private ArrayList<Bird> birds;
	private Board board;
	
	public Player(int birdsNumber, Board board) {
		super();
		birds = new ArrayList<Bird>();
		this.board = board;
		for(int i = 0; i < birdsNumber; i++) {
			birds.add(new Bird(birdsNumber,board.getRows().get(0)));
		}
		birds.get(0).setActive(true);
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
	
	public ArrayList<Bird> getBirds() {
		return birds;
	}
	
}
