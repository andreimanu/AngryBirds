package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import logic.Bird;
import logic.Board;
import logic.Pig;
import logic.Player;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.util.Random;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;


public class MainWindow extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int numOfBirds;
	private int numOfCells;
	private MyActionListener firstListener;
	private Board road;
	private int highScore;
	private Player player;
	private String playerName = "None";
	private JPanel pnBoard;
	private JButton btnDice;
	private JLabel lblDice;
	private JPanel pnDice;
	private JPanel pnScore;
	private JLabel lblScore;
	private JLabel lblHighScoreName;
	private JLabel lblHighScore;
	private JLabel lblScore_1;
	private JLabel lblNewLabel;
	private int numPigs;
	private int multiplier;
	private int maxDice;

	/**
	 * Launch the application.
	 */
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/imgs/bird1.png")));
		setResizable(false);
		setTitle("Angry Birds Board Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 636);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGame = new JMenu("Game");
		mnGame.setMnemonic('G');
		menuBar.add(mnGame);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mntmNewGame.setMnemonic('N');
		mntmNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initialize();
			}
		});
		mnGame.add(mntmNewGame);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Set number of pigs...");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("Please enter the number of pigs:");
				if(isInt(input))
					numPigs = Integer.parseInt(input);
			}
		});
		mntmNewMenuItem.setMnemonic('S');
		mnGame.add(mntmNewMenuItem);
		
		JMenuItem mntmSetNumberOf = new JMenuItem("Set number of birds...");
		mntmSetNumberOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("Please enter the number of birds:");
				if(isInt(input))
					numOfBirds = Integer.parseInt(input);
			}
		});
		mntmSetNumberOf.setMnemonic('b');
		mnGame.add(mntmSetNumberOf);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmExit.setMnemonic('x');
		mnGame.add(mntmExit);
		
		JMenu mnDifficulty = new JMenu("Difficulty");
		mnDifficulty.setMnemonic('D');
		menuBar.add(mnDifficulty);

		numPigs = 5;
		numOfBirds = 3;
		multiplier = 1;
		maxDice = 6;
		numOfCells = 25;
		highScore = 0;
		JMenuItem mntmEasy = new JMenuItem("Easy");
		mntmEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfBirds = 3;
				numPigs = 5;
				multiplier = 1;
				maxDice = 6;
			}
		});
		mntmEasy.setMnemonic('E');
		mnDifficulty.add(mntmEasy);
		
		JMenuItem mntmHard = new JMenuItem("Hard");
		mntmHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfBirds = 3;
				numPigs = 7;
				maxDice = 4;
				multiplier = 2;
			}
		});
		mntmHard.setMnemonic('H');
		mnDifficulty.add(mntmHard);
		
		JMenuItem mntmVeryHard = new JMenuItem("Very Hard");
		mntmVeryHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfBirds = 3;
				numPigs = 9;
				maxDice = 3;
				multiplier = 3;
			}
		});
		mntmVeryHard.setMnemonic('V');
		mnDifficulty.add(mntmVeryHard);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		menuBar.add(mnHelp);
		
		JMenuItem mntmHowToPlay = new JMenuItem("How To Play");
		mntmHowToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"The purpose of the game is getting all the birds from one side to the other without them being eaten by the pigs. Whenever you move a bird on a cell, you win points.\n The game has different levels of difficulty:\nEasy: 3 birds, 5 pigs, point multiplier is 1 and the max number you can generate with the dice is 6.\nHard: 3 birds, 7 pigs, point multiplier is 2 and the max number you can generate with the dice is 4.\nVery Hard: 3 birds, 9 pigs, point multiplier is 3 and the max number you can generate with the dice is 3.\nHave fun!","How to play:",JOptionPane.PLAIN_MESSAGE);
			}
		});
		mntmHowToPlay.setMnemonic('w');
		mnHelp.add(mntmHowToPlay);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Created by\nManu Andrei - Y1679344J\nBenjamin Dauchez","About",JOptionPane.PLAIN_MESSAGE);
			}
		});
		mntmAbout.setMnemonic('b');
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnBoard());
		contentPane.add(getPnDice());
		contentPane.add(getPanel_4());
		firstListener = new MyActionListener();
		initialize();
	}
	
	private class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			int number = Integer.parseInt(source.getActionCommand());
			if(!hasBird(number))
				play(number);
			else
				chooseBird(number);
				
		}
	
	}
	
	public void chooseBird(int pos) {
		road.getPlayer().disableBirds();
		for(Bird b : road.getPlayer().getBirds()) {
			if(b.getPosition() == pos)
				b.setActive(true);
		}
	}
	
	public boolean hasBird(int pos) {
		for(Bird b : road.getPlayer().getBirds()) {
			if(b.getPosition() == pos)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		road = new Board(multiplier, numOfBirds, numOfCells, numPigs, maxDice);
		registerEvents();
		paintGameState();
		initializePlayer();
	}
	
	private void paintGameState() {
		lblScore.setText(String.valueOf(road.getPlayer().getPoints()));
		paintPanels(road.isOver());
		if(road.isOver()) {
			JOptionPane.showMessageDialog(null,"Game over!!","Insert coin", JOptionPane.PLAIN_MESSAGE);
			if(road.getPlayer().getPoints() > highScore) {
				highScore = road.getPlayer().getPoints();
				playerName = JOptionPane.showInputDialog("New high score! Give us your name: ");
				this.lblHighScoreName.setText(playerName);
				this.lblHighScore.setText(String.valueOf(highScore));
			}
			btnDice.setEnabled(false);
		}
		else
			btnDice.setEnabled(true);	
	}
	
	private void play(int pos) {
		if(road.validPlay(pos)) {
			road.makePlays();
			paintGameState();
			setPanelState(false);
			road.getPlayer().disableBirds();
		}	
		
	}
	
	private void initializePlayer() {
		player = road.getPlayer();
	}
	
	private void registerEvents() {
		int j = 4;
		for( int i = 0; i < pnBoard.getComponents().length; i++) {
			JButton button = (JButton) pnBoard.getComponents()[i];
			if((i >= 5 && i <= 9) || (i >= 15 && i <= 19)) {
				button.setActionCommand(String.valueOf(i+j));
				button.setText(String.valueOf(i+j));
				j -= 2;
			}
			else {
				button.setActionCommand(String.valueOf(i));
				button.setText(String.valueOf(i));
				j = 4;
			}
			button.addActionListener(firstListener);
		}
	}
	private void paintPanels(boolean over) {
		Random gen = new Random();
		String image;
		String image2;
		for( int i = 0; i < pnBoard.getComponents().length; i++) {
			JButton button = (JButton) pnBoard.getComponents()[i];
			button.setIcon(null);
			button.setDisabledIcon(null);
			for(Bird b : road.getPlayer().getBirds()) {
				if((b.getPosition() == Integer.valueOf(button.getActionCommand()) && (!b.isDead()))) {
					int birdIcon = gen.nextInt(3)+1;
					image = "/imgs/bird" + birdIcon + ".png";
					button.setIcon(new ImageIcon(getClass().getResource(image)));
					button.setDisabledIcon(new ImageIcon(getClass().getResource(image)));
				}
				
			}
			for(Pig p : road.getPigs()) {
				if(p.getPosition() == Integer.valueOf(button.getActionCommand()) && ((!p.isHidden()) || over )) {
					int pigIcon = gen.nextInt(3)+1;
					image2 = "/imgs/pig" + pigIcon + ".png";
					button.setIcon(new ImageIcon(getClass().getResource(image2)));
					button.setDisabledIcon(new ImageIcon(getClass().getResource(image2)));
				}
				
			}
		}
	}
	
	public static boolean isInt(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}
	
	private JPanel getPnBoard() {
		if (pnBoard == null) {
			pnBoard = new JPanel();
			pnBoard.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnBoard.setBounds(55, 148, 666, 401);
			pnBoard.setLayout(new GridLayout(5, 5, 0, 0));
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setBackground(new Color(255, 218, 185));
			pnBoard.add(btnNewButton);
			
			JButton button_4 = new JButton("");
			button_4.setBackground(new Color(255, 218, 185));
			pnBoard.add(button_4);
			
			JButton button = new JButton("");
			button.setBackground(new Color(255, 218, 185));
			pnBoard.add(button);
			
			JButton button_1 = new JButton("");
			button_1.setBackground(new Color(255, 218, 185));
			pnBoard.add(button_1);
			
			JButton button_2 = new JButton("");
			button_2.setBackground(new Color(255, 218, 185));
			pnBoard.add(button_2);
			
			JButton button_5 = new JButton("");
			button_5.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_5);
			
			JButton button_3 = new JButton("");
			button_3.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_3);
			
			JButton button_9 = new JButton("");
			button_9.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_9);
			
			JButton button_7 = new JButton("");
			button_7.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_7);
			
			JButton button_6 = new JButton("");
			button_6.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_6);
			
			JButton button_8 = new JButton("");
			button_8.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_8);
			
			JButton button_11 = new JButton("");
			button_11.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_11);
			
			JButton button_10 = new JButton("");
			button_10.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_10);
			
			JButton button_12 = new JButton("");
			button_12.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_12);
			
			JButton button_14 = new JButton("");
			button_14.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_14);
			
			JButton button_15 = new JButton("");
			button_15.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_15);
			
			JButton button_13 = new JButton("");
			button_13.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_13);
			
			JButton button_16 = new JButton("");
			button_16.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_16);
			
			JButton button_17 = new JButton("");
			button_17.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_17);
			
			JButton button_19 = new JButton("");
			button_19.setBackground(new Color(0, 255, 255));
			pnBoard.add(button_19);
			
			JButton button_18 = new JButton("");
			button_18.setBackground(new Color(255, 218, 185));
			pnBoard.add(button_18);
			
			JButton button_20 = new JButton("");
			button_20.setBackground(new Color(255, 218, 185));
			pnBoard.add(button_20);
			
			JButton button_21 = new JButton("");
			button_21.setBackground(new Color(255, 218, 185));
			pnBoard.add(button_21);
			
			JButton button_22 = new JButton("");
			button_22.setBackground(new Color(255, 218, 185));
			pnBoard.add(button_22);
			
			JButton button_23 = new JButton("");
			button_23.setBackground(new Color(255, 218, 185));
			pnBoard.add(button_23);
		}
		return pnBoard;
	}
	private JButton getBtnDice() {
		if (btnDice == null) {
			btnDice = new JButton("");
			btnDice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					throwDice();
				}
			});
			btnDice.setIcon(new ImageIcon(MainWindow.class.getResource("/imgs/dice.png")));
		}
		return btnDice;
	}
	
	private void throwDice() {
		road.throwDice();
		lblDice.setText(String.valueOf(road.getDice()));
		if(road.checkPlay()) {
			setPanelState(true);
			btnDice.setEnabled(false);
		}
		
	}
	
	private void setPanelState(boolean state) {
		Component[] comps = pnBoard.getComponents();
		for(Component comp : comps) {
			((JButton)comp).setEnabled(state);
		}
	}
	
	private JLabel getLblDice() {
		if (lblDice == null) {
			lblDice = new JLabel("0");
			lblDice.setHorizontalAlignment(SwingConstants.CENTER);
			lblDice.setFont(new Font("Times New Roman", Font.BOLD, 50));
		}
		return lblDice;
	}
	private JPanel getPnDice() {
		if (pnDice == null) {
			pnDice = new JPanel();
			pnDice.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnDice.setBounds(55, 11, 233, 89);
			pnDice.setLayout(new GridLayout(0, 2, 0, 0));
			pnDice.add(getBtnDice());
			pnDice.add(getLblDice());
		}
		return pnDice;
	}
	private JPanel getPanel_4() {
		if (pnScore == null) {
			pnScore = new JPanel();
			pnScore.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnScore.setBounds(353, 11, 523, 89);
			pnScore.setLayout(null);
			pnScore.add(getLblScore());
			pnScore.add(getLblHighScoreName());
			pnScore.add(getLblHighScore());
			pnScore.add(getLblScore_1());
			pnScore.add(getLblNewLabel());
		}
		return pnScore;
	}
	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("0");
			lblScore.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			lblScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore.setBounds(82, 13, 95, 47);
		}
		return lblScore;
	}
	private JLabel getLblHighScoreName() {
		if (lblHighScoreName == null) {
			lblHighScoreName = new JLabel(playerName);
			lblHighScoreName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblHighScoreName.setHorizontalAlignment(SwingConstants.CENTER);
			lblHighScoreName.setBounds(279, 39, 145, 47);
		}
		return lblHighScoreName;
	}
	private JLabel getLblHighScore() {
		if (lblHighScore == null) {
			lblHighScore = new JLabel(String.valueOf(highScore));
			lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblHighScore.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblHighScore.setBounds(411, 39, 102, 47);
		}
		return lblHighScore;
	}
	private JLabel getLblScore_1() {
		if (lblScore_1 == null) {
			lblScore_1 = new JLabel("Score:");
			lblScore_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
			lblScore_1.setBounds(10, 11, 72, 51);
		}
		return lblScore_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("HighScore:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblNewLabel.setBounds(207, 45, 72, 36);
		}
		return lblNewLabel;
	}
}
