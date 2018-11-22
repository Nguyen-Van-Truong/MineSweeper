package edu.sjsu.cs.cs151.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs.cs151.Message;
import edu.sjsu.cs.cs151.model.Cell;
import edu.sjsu.cs.cs151.model.Model;
import edu.sjsu.cs.cs151.view.View;

/**
 * Controls the game
 * 
 */
public class Controller {
	BlockingQueue<Message> queue;
	Model model;
	View view;
	GameInfo gameInfo;
	private List<Valve> valves = new LinkedList<Valve>();

	/**
	 * Initialize game controller
	 * 
	 * @param view
	 *            GUI representation of the game
	 * @param model
	 *            model of the game
	 */
	public Controller(View view, Model model, BlockingQueue<Message> queue) {
		this.view = view;
		this.model = model;
		this.queue = queue;
		this.gameInfo = new GameInfo(model);
		
	}

	/**
	 * Iterates through messageQueue and updates the model and the view
	 */
	public void mainLoop() {

	}
	
	/**
	 * update Gameinfo
	 * closed cell: -2
	 * mine cell: -1
	 * opened empty cell: 0
	 * open cell with surrounding mine: adjacentMnes
	 * flagged cell: 10
	 */
	public void updateGameInfo() {
		Cell[][] currentCells = model.getMineField().getCell();//get the cells info from model
		int h = model.getHeight();
		int w = model.getWidth();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (currentCells[i][j].isFlagged()) { //if the cells has been flagged
					gameInfo.gameInfoUpdate(i, j, gameInfo.flag()); //change gameinfo Matrix
				} else {
					int currCell = currentCells[i][j].adjacentMines();
					gameInfo.gameInfoUpdate(i, j, currCell);
				}
			}
		}
	}

	/**
	 * Method to stop a game. Stops timer.
	 */
	void endGame() {

	}

}
