package pt.brunojesus.jogodogalo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders;

/**
 * The GameWindow that let's users play the game.
 * Requires a system capable of rendering a Java swing window.
 * 
 * Check {@link IBoard} for more information about the game implementation.
 * 
 * @author Bruno Jesus
 * @since 0.1
 * @version 0.1
 */
public class GameWindow {

    JFrame frame = new JFrame();
    List<JButton> buttons = new ArrayList<JButton>();
    IBoard board;
    
    
    /**
     * Instantiates a new game window.
     *
     * @param title the window title
     * @param board the board implementation
     */
    public GameWindow(String title, IBoard board) {
    	this.board = board;
    	
        this.initWindow(title);
    }
    
    private void initWindow(String title) {
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setTitle(title);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        JPanel titlePanel = new JPanel();
        JPanel btnPanel = new JPanel();

        JLabel titleLabel = new JLabel();
        titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setText(title);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 400, 100);
        btnPanel.setLayout(new GridLayout(3, 3));// setting layout of bt_pannel as gridlayout 
        for (int x = 0; x < 3; x++) {
        	for (int y = 0; y < 3; y++) {
        		JButton btn = createButton(btnPanel, x, y);
        		buttons.add(btn);
        	}
        }
        
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(btnPanel);
    }
    
    private JButton createButton(JPanel panel, int x, int y) {
    	JButton btn = new JButton();
        panel.add(btn);
        btn.setBackground(Color.WHITE);
        btn.setBorder(BasicBorders.getInternalFrameBorder());
        btn.setFont(new Font("Arial", Font.BOLD, 80));
        btn.setFocusable(false);
        btn.addActionListener((e) -> {
        	if (this.play(x, y)) {
        		btn.setText(board.getItemInPosition(x, y));
        	}
        	
        	if (board.getWinner() != null) {
        		JOptionPane.showMessageDialog(frame, board.getWinner() + " Wins!");
        		board.reset();
        		buttons.forEach(t -> t.setText(null));
        	}
        });
        
        return btn;
    }
    
    private boolean play(int x, int y) {
    	try {
			board.play(x, y);
			return true;
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, e1.getMessage());
		}
    	return false;
    }
}
