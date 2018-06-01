package in.pushvas.tests;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


import java.awt.*;
import javax.swing.*;


public class ProgressDialog {
	
	 public static void main(String[] args) throws InterruptedException {
	        final int MAX = 100;
	        final JFrame frame = new JFrame("JProgress Demo");
	        
	        // creates progress bar
	        final JProgressBar pb = new JProgressBar();
	        pb.setStringPainted(true);
	        pb.setLocation(150, 200);
	        
	        // add progress bar
	        frame.setLayout(new FlowLayout());
	        frame.getContentPane().add(pb);
	 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(300, 300);
	        frame.setVisible(true);
	        
	       /* frame.setLayout(new GridLayout(4,1));
	         
	        //JLabel label1 = new JLabel(" Left Label "); 
	        JLabel label2 = new JLabel(" Center Label ",
	             JLabel.CENTER);
	         
	        JLabel label3 = new JLabel(" Right Label",
	             JLabel.RIGHT); 
	         
	        JLabel label4 = new JLabel(" Image Label", 
	            new ImageIcon("c:\\smile.jpg"),JLabel.CENTER);
	         
	        //frame.add(label1); 
	        frame.add(label2); 
	        frame.add(label3); 
	        frame.add(label4);
	        frame.setTitle("Welcome to Hubberspot!.");
	        frame.setSize(500,300);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	        
	        //JPanel main = new JPanel();
	        JLabel label = new JLabel("<html> <br><br><br><br> CSR  REDDY </html>",JLabel.RIGHT);
	        frame.setLocationRelativeTo(null);
	        frame.getContentPane().add(label);
	        frame.add(label).setLocation(700, -100);
	        frame.setVisible(true);
	        
	        
	     
	        
	        // update progressbar
	        for (int i = 0; i <= MAX; i++) {
	        	
	            final int currentValue = 10;//i;
	            try {
	                SwingUtilities.invokeLater(new Runnable() {
	                    public void run() {
	                        pb.setValue(currentValue);
	                    }
	                });
	                java.lang.Thread.sleep(100);
	            } catch (InterruptedException e) {
	                JOptionPane.showMessageDialog(frame, e.getMessage());
	            }
	            Thread.sleep(1000);
	            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	            //Thread.sleep(1000);
	        }
	 
	    }
	
	
}

