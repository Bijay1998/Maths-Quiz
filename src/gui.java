import java.awt.EventQueue;

import javax.swing.JFrame;
import java.util.Timer;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;


public class gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 708, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Button buttonA = new Button("A");
		buttonA.setBounds(10, 60, 70, 22);
		frame.getContentPane().add(buttonA);
		
		Button button_B = new Button("B");
		button_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_B.setBounds(10, 117, 70, 22);
		frame.getContentPane().add(button_B);
		
		Button button_C = new Button("C");
		button_C.setBounds(10, 169, 70, 22);
		frame.getContentPane().add(button_C);
		
		Button button_3 = new Button("D");
		button_3.setBounds(10, 225, 70, 22);
		frame.getContentPane().add(button_3);
		
		Label label = new Label("answerLevelA");
		label.setBounds(101, 60, 102, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("New label");
		label_1.setBounds(101, 117, 102, 22);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("New label");
		label_2.setBounds(101, 169, 102, 22);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("New label");
		label_3.setBounds(101, 225, 102, 22);
		frame.getContentPane().add(label_3);
	}
}
