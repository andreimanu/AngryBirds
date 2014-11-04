package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;

import logic.Board;
import logic.Player;


public class MainWindow extends JFrame {
 
	private JPanel contentPane;
	private JPanel pnOuter1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel pnOuter2;
	private JButton btn04;
	private JButton btn03;
	private JButton btn02;
	private JButton btn01;
	private JButton btn00;
	private JButton btn10;
	private JButton btn11;
	private JButton btn12;
	private JButton btn13;
	private JButton btn14;
	private JButton btn24;
	private JButton btn23;
	private JButton btn22;
	private JButton btn21;
	private JButton btn20;
	private JButton btn30;
	private JButton btn31;
	private JButton btn32;
	private JButton btn33;
	private JButton btn34;
	private JButton btn44;
	private JButton btn43;
	private JButton btn42;
	private JButton btn41;
	private JButton btn40;
	private Player player;
	private int numOfBirds = 3;
	private int numOfRows = 5;
	private int numOfCells = 5;
	private MyActionListener firstListener;
	private Board road;
	/**
	 * Launch the application.
	 */

	private class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			int number = Integer.parseInt(source.getActionCommand());
			play(number);
		}
	
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
	private int innerPn = 3;
	private void initialize() {
		paintGameState();
		registerEvents();
		initializePlayer();
	}
	
	private void paintGameState() {
		paintOuterPanels();
		paintInnerPanels();		
	}
	
	private void play(int pos) {
		if(road.validPlay(pos)) {
			road.makePlays();
			paintGameState();
		}
	}
	
	private void initializePlayer() {
		player = new Player(numOfBirds);
	}
	
	private void registerEvents() {
		for( int i = 0; i < pnOuter1.getComponents().length; i++) {
			JButton button = (JButton) pnOuter1.getComponents()[i];
			button.setActionCommand(String.valueOf(i));
			button.addActionListener(firstListener);
		}
	}
	private void paintOuterPanels() {
		String image = "/imgs/sky.png";
		Component[] buttons = pnOuter1.getComponents();
		for(Component but: buttons) {
			JButton button = (JButton)but;
			button.setIcon(new ImageIcon(getClass().getResource((image))));
		}
		buttons = pnOuter2.getComponents();
		for(Component but: buttons) {
			JButton button = (JButton)but;
			button.setIcon(new ImageIcon(getClass().getResource((image))));
		}
	}
	
	private void paintInnerPanels() {
		for(int i = 1; i <= innerPn; i++) {
			String panelName = "panel_" + i;
			Component[] cpComp = contentPane.getComponents();
			for(Component cp : cpComp) {
				if(cp.getName() == null)
					continue;
				if(cp.getName().equals(panelName)) {
					JPanel pan = (JPanel) cp;
					Component[] buttons1 = pan.getComponents();
					for(Component but: buttons1) {
						String image = "/imgs/grass.png";
						JButton button = (JButton)but;
						button.setIcon(new ImageIcon(getClass().getResource((image))));
					}
				}
			}
		}
	}
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnOuter1());
		contentPane.add(getPanel_1());
		contentPane.add(getPanel_2());
		contentPane.add(getPanel_3());
		contentPane.add(getPnOuter2());
		firstListener = new MyActionListener();
		road = new Board(1, numOfBirds, numOfRows, numOfCells);
		initialize();
	}
	private JPanel getPnOuter1() {
		if (pnOuter1 == null) {
			pnOuter1 = new JPanel();
			pnOuter1.setBounds(10, 11, 414, 43);
			pnOuter1.setLayout(new GridLayout(1, 0, 0, 0));
			pnOuter1.add(getBtn00());
			pnOuter1.add(getBtn01());
			pnOuter1.add(getBtn02());
			pnOuter1.add(getBtn03());
			pnOuter1.add(getBtn04());
		}
		return pnOuter1;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(10, 65, 414, 43);
			panel_1.setLayout(new GridLayout(1, 0, 0, 0));
			panel_1.add(getBtn14());
			panel_1.add(getBtn13());
			panel_1.add(getBtn12());
			panel_1.add(getBtn11());
			panel_1.add(getBtn10());
			panel_1.setName("panel_1");
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(10, 119, 414, 43);
			panel_2.setLayout(new GridLayout(1, 0, 0, 0));
			panel_2.add(getBtn20());
			panel_2.add(getBtn21());
			panel_2.add(getBtn22());
			panel_2.add(getBtn23());
			panel_2.add(getBtn24());
			panel_2.setName("panel_2");
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBounds(10, 173, 414, 43);
			panel_3.setLayout(new GridLayout(1, 0, 0, 0));
			panel_3.add(getBtn34());
			panel_3.add(getBtn33());
			panel_3.add(getBtn32());
			panel_3.add(getBtn31());
			panel_3.add(getBtn30());
			panel_3.setName("panel_3");
		}
		return panel_3;
	}
	private JPanel getPnOuter2() {
		if (pnOuter2 == null) {
			pnOuter2 = new JPanel();
			pnOuter2.setBounds(10, 227, 414, 43);
			pnOuter2.setLayout(new GridLayout(1, 0, 0, 0));
			pnOuter2.add(getBtn40());
			pnOuter2.add(getBtn41());
			pnOuter2.add(getBtn42());
			pnOuter2.add(getBtn43());
			pnOuter2.add(getBtn44());
		}
		return pnOuter2;
	}
	private JButton getBtn04() {
		if (btn04 == null) {
			btn04 = new JButton("");
		}
		return btn04;
	}
	private JButton getBtn03() {
		if (btn03 == null) {
			btn03 = new JButton("");
		}
		return btn03;
	}
	private JButton getBtn02() {
		if (btn02 == null) {
			btn02 = new JButton("");
		}
		return btn02;
	}
	private JButton getBtn01() {
		if (btn01 == null) {
			btn01 = new JButton("");
		}
		return btn01;
	}
	private JButton getBtn00() {
		if (btn00 == null) {
			btn00 = new JButton("");
		}
		return btn00;
	}
	private JButton getBtn10() {
		if (btn10 == null) {
			btn10 = new JButton("");
		}
		return btn10;
	}
	private JButton getBtn11() {
		if (btn11 == null) {
			btn11 = new JButton("");
		}
		return btn11;
	}
	private JButton getBtn12() {
		if (btn12 == null) {
			btn12 = new JButton("");
		}
		return btn12;
	}
	private JButton getBtn13() {
		if (btn13 == null) {
			btn13 = new JButton("");
		}
		return btn13;
	}
	private JButton getBtn14() {
		if (btn14 == null) {
			btn14 = new JButton("");
		}
		return btn14;
	}
	private JButton getBtn24() {
		if (btn24 == null) {
			btn24 = new JButton("");
		}
		return btn24;
	}
	private JButton getBtn23() {
		if (btn23 == null) {
			btn23 = new JButton("");
		}
		return btn23;
	}
	private JButton getBtn22() {
		if (btn22 == null) {
			btn22 = new JButton("");
		}
		return btn22;
	}
	private JButton getBtn21() {
		if (btn21 == null) {
			btn21 = new JButton("");
		}
		return btn21;
	}
	private JButton getBtn20() {
		if (btn20 == null) {
			btn20 = new JButton("");
		}
		return btn20;
	}
	private JButton getBtn30() {
		if (btn30 == null) {
			btn30 = new JButton("");
		}
		return btn30;
	}
	private JButton getBtn31() {
		if (btn31 == null) {
			btn31 = new JButton("");
		}
		return btn31;
	}
	private JButton getBtn32() {
		if (btn32 == null) {
			btn32 = new JButton("");
		}
		return btn32;
	}
	private JButton getBtn33() {
		if (btn33 == null) {
			btn33 = new JButton("");
		}
		return btn33;
	}
	private JButton getBtn34() {
		if (btn34 == null) {
			btn34 = new JButton("");
		}
		return btn34;
	}
	private JButton getBtn44() {
		if (btn44 == null) {
			btn44 = new JButton("");
		}
		return btn44;
	}
	private JButton getBtn43() {
		if (btn43 == null) {
			btn43 = new JButton("");
		}
		return btn43;
	}
	private JButton getBtn42() {
		if (btn42 == null) {
			btn42 = new JButton("");
		}
		return btn42;
	}
	private JButton getBtn41() {
		if (btn41 == null) {
			btn41 = new JButton("");
		}
		return btn41;
	}
	private JButton getBtn40() {
		if (btn40 == null) {
			btn40 = new JButton("");
		}
		return btn40;
	}
}
