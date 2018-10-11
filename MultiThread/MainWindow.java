package com.pieropischedda.multithread;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 * @author  Piero Pischedda
 * @version 1.0
 * @since   2012-02-13 
 * @Copyright 2012-2018
 */
public class MainWindow extends JFrame {

	/**   Generated SerialVerionUID   **/
	private static final long serialVersionUID = -8215030929837488987L;

	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JButton jButtonStart1 = null;
	private JButton jButtonStart2 = null;
	private JButton jButtonPause1 = null;
	private JButton jButtonPause2 = null;
	private WindowRunnable1 windowRunnable1 = null;
	private WindowRunnable2 windowRunnable2 = null;
	private Thread t1;
	private Thread t2;
	private JButton jButtonResume1 = null;
	private JButton jButtonResume2 = null;



	/**
	 * This is the default constructor
	 */
	public MainWindow() {
		super();
		initialize();
		windowRunnable1 = new WindowRunnable1();
		windowRunnable2 = new WindowRunnable2();
		windowRunnable1.setVisible(true);
		windowRunnable2.setVisible(true);
		t1 = new Thread(windowRunnable1);
		t2 = new Thread(windowRunnable2);
	}



	/**
	 * This method initializes MainWindow
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 300);
		this.setContentPane(getJContentPane());
		this.setTitle("MultiThread");
	}



	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}



	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.gridy = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints4.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints3.gridy = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints2.gridy = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints.gridy = 0;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getJButtonStart1(), gridBagConstraints);
			jPanel.add(getJButtonStart2(), gridBagConstraints1);
			jPanel.add(getJButtonPause1(), gridBagConstraints2);
			jPanel.add(getJButtonPause2(), gridBagConstraints3);
			jPanel.add(getJButtonResume1(), gridBagConstraints4);
			jPanel.add(getJButtonResume2(), gridBagConstraints5);
		}
		return jPanel;
	}



	/**
	 * This method initializes jButtonStart1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonStart1() {
		if (jButtonStart1 == null) {
			jButtonStart1 = new JButton();
			jButtonStart1.setText("Start Thread 1");
			jButtonStart1.setPreferredSize(new Dimension(150, 50));
			jButtonStart1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					t1.start();		// when this button is pressed thread 1 starts
					jButtonStart1.setEnabled(false);

				}});
		}
		return jButtonStart1;
	}



	/**
	 * This method initializes jButtonStart2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonStart2() {
		if (jButtonStart2 == null) {
			jButtonStart2 = new JButton();
			jButtonStart2.setText("Start Thread 2");
			jButtonStart2.setPreferredSize(new Dimension(150, 50));
			jButtonStart2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					t2.start();		// when this button is pressed thread 1 starts
					jButtonStart2.setEnabled(false);

				}});
		}
		return jButtonStart2;
	}



	/**
	 * This method initializes jButtonPause1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPause1() {
		if (jButtonPause1 == null) {
			jButtonPause1 = new JButton();
			jButtonPause1.setText("Pause Thread 1");
			jButtonPause1.setPreferredSize(new Dimension(150, 50));
			jButtonPause1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					jButtonResume1.setEnabled(true);
					jButtonPause1.setEnabled(false);
					windowRunnable1.run = false;
				}
			});

		}
		return jButtonPause1;
	}



	/**
	 * This method initializes jButtonPause2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPause2() {
		if (jButtonPause2 == null) {
			jButtonPause2 = new JButton();
			jButtonPause2.setText("Pause Thread 2");
			jButtonPause2.setPreferredSize(new Dimension(150, 50));
			jButtonPause2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					jButtonResume2.setEnabled(true);
					jButtonPause2.setEnabled(false);
					windowRunnable2.run = false;
				}
			});
		}
		return jButtonPause2;
	}



	/**
	 * This method initializes jButtonResume1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonResume1() {
		if (jButtonResume1 == null) {
			jButtonResume1 = new JButton();
			jButtonResume1.setEnabled(false);
			jButtonResume1.setText("Resume Thread 1");
			jButtonResume1.setPreferredSize(new Dimension(150, 50));
			jButtonResume1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					jButtonResume1.setEnabled(false);
					jButtonPause1.setEnabled(true);
					windowRunnable1.go();
				}
			});
		}
		return jButtonResume1;
	}



	/**
	 * This method initializes jButtonResume2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonResume2() {
		if (jButtonResume2 == null) {
			jButtonResume2 = new JButton();
			jButtonResume2.setEnabled(false);
			jButtonResume2.setText("Resume Thread 2");
			jButtonResume2.setPreferredSize(new Dimension(150, 50));
			jButtonResume2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					jButtonResume2.setEnabled(false);
					jButtonPause2.setEnabled(true);
					windowRunnable2.go();
				}
			});
		}
		return jButtonResume2;
	}



	/**
	 * Main
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainWindow thisClass = new MainWindow();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

}
