package in.pushvas.tests;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class ProgressSample {

	public static void executionProgressGraph(String testCasename, String testcaseDescription, int percentage) {
		try {
			JFrame f = new JFrame(testCasename);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container content = f.getContentPane();
			JProgressBar progressBar = new JProgressBar();
			progressBar.setSize(400, 400);
			progressBar.setValue(percentage);
			progressBar.setStringPainted(true);
			Border border = BorderFactory.createTitledBorder("");
			progressBar.setBorder(border);
			content.add(progressBar, BorderLayout.NORTH);

			JPanel panel = new JPanel();
			// panel.add(button);
			panel.add(progressBar);
			JPanel panel1 = new JPanel();
			panel1.setLayout(new BorderLayout());
			panel1.add(panel, BorderLayout.NORTH);
			// panel1.add(label, BorderLayout.CENTER);
			panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			f.setContentPane(panel1);
			f.pack();

			f.setSize(400, 150);
			f.setVisible(true);
			f.setLocationRelativeTo(null);

			JLabel label = new JLabel("Roseindia.net");
			String str = "<html>" + "<font align=\"center\" color=\"#008000\">" + "<b>" + testcaseDescription+", Execution is in process..." + "</b>"
					+ "</font>" + "</html>";
			label.setText(str);

			f.add(label);
			f.setVisible(true);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		executionProgressGraph("TC001", " ABCDEF", 20);
	}
}
