package com.pieropischedda.multithread;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


/**
 * @author  Piero Pischedda
 * @version 1.0
 * @since   2012-02-13 
 * @Copyright 2012-2018
 */
public class WindowRunnable1 extends JFrame implements Runnable {


	/**   Generated SerialVerionUID   **/
	private static final long serialVersionUID = -5368710628436095235L;

	private JPanel jContentPane = null;
	private Integer i = 0;
	public boolean run = true;
	private JPanel jPanel = null;
	private JLabel jLabelDX = null;
	private JLabel jLabelSX = null;



	/**
	 * This is the default constructor
	 */
	public WindowRunnable1() {
		super();
		initialize();
	}



	/**
	 * This method initializes WindowRunnable1
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setLocation(410, 0);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Thread1");
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
	 * This method is launched when is invoked "t1.start()"
	 */
	@Override
	public void run() {
		while(true) {
			checkPause();
			Integer millis = (int) (i % 1000 );
			Integer seconds = (int) (i / 1000 % 60);
			Integer minutes = (int) (i / 60000 % 60);
			if(millis<100)
				jLabelDX.setText("0"+millis.toString());
			else
				jLabelDX.setText(millis.toString());
			jLabelSX.setText(minutes.toString()+":"+seconds.toString()+".");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}



	/**
	 * Pause the thread until "run" is false
	 */
	private synchronized void checkPause() {
		//	wait until "run" boolean is false
		while(!run) {
			try {
				wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}//end while
	}



	/**
	 * Resume the thread
	 */
	public synchronized void go() {
		run = true;
		notify();
	}



	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 0;
			jLabelSX = new JLabel();
			jLabelSX.setText("0:0.");
			jLabelSX.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			jLabelSX.setPreferredSize(new Dimension(100, 30));
			jLabelSX.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.insets = new Insets(0, 00, 0, 0);
			gridBagConstraints.gridy = 0;
			jLabelDX = new JLabel();
			jLabelDX.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			jLabelDX.setHorizontalAlignment(SwingConstants.LEFT);
			jLabelDX.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelDX.setText("000");
			jLabelDX.setVerticalTextPosition(SwingConstants.CENTER);
			jLabelDX.setPreferredSize(new Dimension(80, 30));
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabelDX, gridBagConstraints);
			jPanel.add(jLabelSX, gridBagConstraints1);
		}
		return jPanel;
	}

}
