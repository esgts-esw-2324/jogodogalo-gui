package pt.brunojesus.jogodogalo.gui;

/**
 * Interface to be used for the {@link GameWindow}
 * 
 * @author Bruno Jesus
 * @since 0.1
 * @version 0.1
 */
public interface IBoard {

	/**
	 * Executes a play.
	 * If the last play was an "X", then the subsequent play will be an "O".
	 * The first play is always a "X"
	 *
	 * @param x the x coordinate, from 0 to 2
	 * @param y the y coordinate, from 0 to 2
	 * @throws Exception if play is invalid
	 */
	public void play(int x, int y) throws Exception;

	/**
	 * Gets the item in position.
	 *
	 * @param x the x coordinate, from 0 to 2
	 * @param y the y coordinate, from 0 to 2
	 * @return the item in position: "X", "O" or <b>null</b> if it doesn't exist.
	 */
	public String getItemInPosition(int x, int y);

	/**
	 * Gets the winner.
	 *
	 * @return the winner, or <b>null</b> if there's no winner
	 */
	public String getWinner();

	/**
	 * Resets the game.
	 */
	public void reset();
}
