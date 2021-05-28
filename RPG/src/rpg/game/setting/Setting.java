package rpg.game.setting;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import rpg.game.GameStart;

public class Setting extends JFrame implements ActionListener {
	Container contentPane;
	private ImageIcon backgroundImage;
	private JLabel levelL;
	private JComboBox levelR;
	private JLabel musicL;
	private JToggleButton musicR;
	private JPanel settingPanel;
	private JButton back;
	private String levels[] = { "Easy", "Difficult" };
	private final int WIDTH = 130;
	private final int HEIGHT = 30;
	private final int PAD = 5;
	private final int WEST_PAD = 290;
	private final int NORTH_PAD = 310;
	public static boolean musicable = true;
	public static int level = 0;

	public Setting() {
		backgroundImage = new ImageIcon("src/Assets/start_game.png");
		setSize(851, 470);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Setting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		settingPanel = new JPanel() {

			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundImage != null) {
					g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
				}
			}
		};
		setContentPane(settingPanel);
		SpringLayout layout = new SpringLayout();
		settingPanel.setLayout(layout);

		Font font = new Font("Comic Sans MS", Font.BOLD, 25);

		levelL = new JLabel("Level");
		levelL.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		levelL.setFont(font);
		levelL.setForeground(Color.WHITE);
		settingPanel.add(levelL);

		levelR = new JComboBox(levels);
		levelR.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		if (level == 0)
			levelR.setSelectedIndex(0);
		else
			levelR.setSelectedIndex(1);
		levelR.setFont(font);
		levelR.addActionListener(this);
		settingPanel.add(levelR);

		layout.putConstraint(SpringLayout.WEST, levelL, WEST_PAD, SpringLayout.WEST, settingPanel);
		layout.putConstraint(SpringLayout.NORTH, levelL, NORTH_PAD, SpringLayout.NORTH, settingPanel);
		layout.putConstraint(SpringLayout.WEST, levelR, PAD, SpringLayout.EAST, levelL);
		layout.putConstraint(SpringLayout.NORTH, levelR, NORTH_PAD, SpringLayout.NORTH, settingPanel);

		musicL = new JLabel("Music");
		musicL.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		musicL.setFont(font);
		musicL.setForeground(Color.WHITE);
		settingPanel.add(musicL);

		musicR = new JToggleButton("ON");
		if (musicable == false)
			musicR.setText("OFF");
		musicR.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		musicR.setFont(font);
		musicR.addActionListener(this);
		settingPanel.add(musicR);

		layout.putConstraint(SpringLayout.WEST, musicL, WEST_PAD, SpringLayout.WEST, settingPanel);
		layout.putConstraint(SpringLayout.NORTH, musicL, PAD, SpringLayout.SOUTH, levelR);
		layout.putConstraint(SpringLayout.WEST, musicR, PAD, SpringLayout.EAST, musicL);
		layout.putConstraint(SpringLayout.NORTH, musicR, PAD, SpringLayout.SOUTH, levelR);

		back = new JButton("Back");
		back.setFont(font);
		back.setForeground(new Color(0, 11, 38));
		back.setBackground(new Color(180, 223, 252));
		back.addActionListener(this);
		settingPanel.add(back);

		layout.putConstraint(SpringLayout.WEST, back, 0, SpringLayout.WEST, settingPanel);
		layout.putConstraint(SpringLayout.NORTH, back, 390, SpringLayout.NORTH, settingPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == levelR) {
			level = levelR.getSelectedIndex();
		}
		if (e.getSource() == back) {
			this.dispose();
			new GameStart();
		}
		if (musicR.isSelected()) {
			musicR.setText("OFF");
			musicable = false;
		} else {
			musicR.setText("ON");
			musicable = true;
		}

	}

}
