package in.pushvas.tests;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.html.*;

public class SwingProgressBar {
	final static int interval = 1000;
	int i;
	JLabel label;
	JProgressBar pb;
	Timer timer;
	JButton button;

	public SwingProgressBar() throws InterruptedException {
		JFrame frame = new JFrame("Swing Progress Bar");
		button = new JButton("Start");
		button.addActionListener(new ButtonListener());

		pb = new JProgressBar(0, 100);
		pb.setValue(10);
		pb.setStringPainted(true);

		label = new JLabel("Roseindia.net");
		String str = "<html>" + "<center>"+"<font color=\"#008000\">" + "<b>" + "Downloading is in process......." + "</b>"
				+ "</font>"+"</center>" + "</html>";
		label.setText(str);

		JPanel panel = new JPanel();
		//panel.add(button);
		panel.add(pb);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(panel, BorderLayout.NORTH);
		panel1.add(label, BorderLayout.CENTER);
		panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		frame.setContentPane(panel1);
		frame.pack();
		frame.setSize(400, 200);
	    frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread.sleep(1000);
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

		/*// Create a timer.
		timer = new Timer(interval, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (i == 20) {
					Toolkit.getDefaultToolkit().beep();
					timer.stop();
					button.setEnabled(true);
					pb.setValue(10);
					String str = "<html>" + "<font align=\"center\" color=\"#FF0000\">" + "<b>" + "Downloading completed." + "</b>"
							+ "</font>" + "</html>";
					label.setText(str);
				}
				i = i + 1;
				pb.setValue(i);
			}
		});*/
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			button.setEnabled(false);
			i = 0;
			String str = "<html>" + "<font color=\"#008000\">" + "<b>" + "Downloading is in process......." + "</b>"
					+ "</font>" + "</html>";
			label.setText(str);
			timer.start();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SwingProgressBar spb = new SwingProgressBar();
	}
}