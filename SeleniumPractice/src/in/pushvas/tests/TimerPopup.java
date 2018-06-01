package in.pushvas.tests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerPopup {

	
	public static int getRandomNumber(int minimum, int maximum){
		
		Random rn = new Random();
		int range = maximum - minimum + 1;
		int randomNum =  rn.nextInt(range) + minimum;
		
		return randomNum;
	}
	
	
	public static void main(String[] args) {
	
		
		// Replace JOptionPane.showXxxx(args) with new JOptionPane(args)
		JOptionPane pane = new JOptionPane("Messssssssssssssage");
		final JDialog dialog = pane.createDialog("title");
		Timer timer = new Timer(2000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dialog.setVisible(false);
		        // or maybe you'll need dialog.dispose() instead?
		    }
		});
		timer.setRepeats(false);
		timer.start();
		dialog.setVisible(true);
		
		System.out.println(getRandomNumber(100, 200));

	}

}
