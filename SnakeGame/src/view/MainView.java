package view;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import config.Config;
import gameui.GamePanel;
import gameui.NewGamePanel;

public final class MainView {
	
	private final GamePanel game_panel = null;
	private final NewGamePanel newgame_panel = null;
	private final ViewListener view_listener = new ViewListener();
	
	private JFrame frame;
	private JPanel content;
	private final int scale = Config.BLOCK_SIZE;
	private final List<Image> icons = new ArrayList<>();
	
	  public MainView(int width, int height, int scale, Snake snakeBody, Apple apple) {
	        gamePanel = new GamePanel(width, height, scale, snakeBody, apple);
	        newGamePanel = new NewGamePanel(width, height, scale);
	        gameOverPanel = new GameOverPanel(width, height, scale);
	        difficultyPanel = new DifficultyPanel(width, height, scale);
	        gameHeaderPanel = new GameHeaderPanel(width, height, scale);
	        this.scale = scale;
	        initIcons();
	        initGridView();
	    }

	    /**
	     * Initializes GUI.
	     */
	    private void initGridView() {
	        frame = new JFrame("Snake");
	        frame.addKeyListener(viewListener);

	        content = new JPanel();
	        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
	        content.setBorder(BorderFactory.createEmptyBorder(scale, scale, scale, scale));
	        content.setBackground(Color.black);
	        content.add(gameHeaderPanel);
	        content.add(gamePanel);
	        frame.add(content);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(false);
	        frame.pack();
	        newGame();
	        frame.setIconImages(icons);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }

	    public void updateView(Deque<Point> snakeBody, Point apple, String difficulty, int highScore, int applesEaten) {
	        gamePanel.setSnakeBody(snakeBody, apple);
	        gameHeaderPanel.update(difficulty, highScore, applesEaten);
	        gameHeaderPanel.repaint();
	        gamePanel.repaint();
	    }

	    public void gameOver() {
	        System.out.println("GAME OVER");
	        viewListener.setGameOver(true);
	        content.removeAll();
	        content.add(gameOverPanel);
	        content.validate();
	        content.repaint();
	    }

	    public void newGame() {
	        System.out.println("NEW GAME");
	        viewListener.setNewGame(true);
	        content.removeAll();
	        content.add(newGamePanel);
	        content.validate();
	        content.repaint();
	    }

	    public void chooseDifficulty() {
	        System.out.println("CHOOSE DIFFICULTY");
	        viewListener.setChoosingDifficulty(true);
	        content.removeAll();
	        content.add(difficultyPanel);
	        content.validate();
	        content.repaint();
	    }

	    public void continueGame() {
	        System.out.println("CONTINUE GAME");
	        viewListener.setGameOver(false);
	        viewListener.setNewGame(false);
	        viewListener.setChoosingDifficulty(false);
	        content.removeAll();
	        content.add(gameHeaderPanel);
	        content.add(gamePanel);
	        content.validate();
	        content.repaint();
	    }

	    public void update(String difficulty, int applesEaten, int highScore) {
	        gameOverPanel.update(difficulty, applesEaten, highScore);
	    }

	    private void initIcons() {
	        try {
	            URL url = this.getClass().getClassLoader().getResource("icon/Icon_128.png");
	            icons.add((new ImageIcon(url)).getImage());
	        } catch (Exception e) {
	        }
	    }

	}
}
