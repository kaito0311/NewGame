package rpg.game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rpg.game.setting.Setting;

public class GameStart extends JFrame implements ActionListener {
    public static float MAX_WIDTH = 800;
    public static float MAX_HEIGHT = 640;
    private ImageIcon startGameBackground;
    private JPanel panel;
    private JButton newGame;
    private JButton setting;
    private JButton aboutUs;
    public String game_mode;

    public GameStart() {

        startGameBackground = new ImageIcon("src/Assets/start_game.png");
        if (startGameBackground == null) {
            System.out.println("hmmm, loi background");
        }
        try {
            setSize(851, 470);
            setVisible(true);
            setResizable(false);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            // panel = new JPanel();
            try {
                panel = new JPanel() {

                    protected void paintComponent(Graphics g) {
                        System.out.println("hmmm, background");

                        super.paintComponent(g);
                        if (startGameBackground != null) {
                            g.drawImage(startGameBackground.getImage(), 0, 0, getWidth(), getHeight(), null);
                        }
                    }
                };
            } catch (Exception e) {
                System.out.println("GameLoi");
            }
            setContentPane(panel);

            this.setLayout(null);
            setControl();

        } catch (Exception e) {
            System.out.println("choi tam");
            Game game = new Game("Game", (int) MAX_WIDTH, (int) MAX_HEIGHT);
            game.start();
        }
    }

    public void setControl() {
        newGame = new JButton("Start Game");
        add(newGame);

        newGame.setSize(120, 35);
        newGame.setLocation(350, 310);
        newGame.addActionListener(this);

        setting = new JButton("Setting");
        setting.setSize(120, 35);
        setting.setLocation(350, 350);
        setting.addActionListener(this);
        add(setting);

        aboutUs = new JButton("About Us");
        add(aboutUs);

        aboutUs.setSize(120, 35);
        aboutUs.setLocation(350, 390);
        aboutUs.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if (btn == newGame) {
            this.dispose();
            Game game = new Game("Game", (int) MAX_WIDTH, (int) MAX_HEIGHT);
            game.start();
        }
        if (btn == setting) {
            this.dispose();
            new Setting();
        }

        if (btn == aboutUs) {
            JOptionPane.showMessageDialog(null,
                    "Nhom xx: " + "\n- Dinh Tan Minh" + "\n- Tran Doan Hiep" + "\n- Nguyen Van Linh"
                            + "\n- Duong Van Tuyen" + "\n- Dao Minh Tien" + "\n GVHD:",
                    "Information of us", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
