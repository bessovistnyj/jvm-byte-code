package ru.napadovskiu.tracker;

/**
 *
 */
public interface UserAction {

	/**
	 *
	 * @return
	 */
	int key();

	/**
	 *
	 * @param input
	 * @param tracker
	 */
	void execute(Input input, Tracker tracker);

	/**
	 *
	 * @return
	 */
	String info();
}