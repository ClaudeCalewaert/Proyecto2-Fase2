package com.calewaert.proyecto2.Proyecto2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;

public class GUIPrincipal {

	private JFrame jramePrincipal;

 	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPrincipal window = new GUIPrincipal();
					window.jramePrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jramePrincipal = new JFrame();
		jramePrincipal.setResizable(false);
		jramePrincipal.setFont(new Font("Arial", Font.PLAIN, 20));
		jramePrincipal.setTitle("GRU");
		jramePrincipal.setBounds(100, 100, 1038, 563);
		jramePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jramePrincipal.getContentPane().setBackground(new Color(128, 128, 128));
		jramePrincipal.getContentPane().setLayout(new CardLayout(0, 0));
		

		
		
		
		
		
		
		
	
	
	
	}	
}
