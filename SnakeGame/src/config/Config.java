package config;

import util.Mode;

public class Config {
	
	private final static int DEFAULT_BLOCK_SIZE = 20;
	
	private final static Mode DEFAULT_MODE = Mode.EASY;
	
	public final static int BOARD_ROWS = 20, BOARD_COLUMNS = 20;
	
	public static int BLOCK_SIZE = DEFAULT_BLOCK_SIZE;
	
	public static Mode MODE = DEFAULT_MODE;
	
	public void setBlockSize(int s) {
		Config.BLOCK_SIZE = s;
	}
	
	public void setMode(Mode m) {
		Config.MODE = m;
	}
	
}
