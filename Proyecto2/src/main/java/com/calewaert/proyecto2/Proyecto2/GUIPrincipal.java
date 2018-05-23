package com.calewaert.proyecto2.Proyecto2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Panel;

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
		jramePrincipal.setBounds(100, 100, 1040, 563);
		jramePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jramePrincipal.getContentPane().setBackground(new Color(128, 128, 128));
		jramePrincipal.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		
		// ----------------------------------------------------------------------------- MENU PRINCIPAL -----------------------------------------------------------------
		
		
		
		JLayeredPane lPanelMenuPrincipal = new JLayeredPane();
		jramePrincipal.getContentPane().add(lPanelMenuPrincipal, "name_71769723674401");
		
		JPanel panelTituloMenuPrincipal = new JPanel();
		panelTituloMenuPrincipal.setBackground(new Color(255, 140, 0));
		panelTituloMenuPrincipal.setForeground(Color.WHITE);
		panelTituloMenuPrincipal.setBounds(0, 0, 1034, 94);
		lPanelMenuPrincipal.add(panelTituloMenuPrincipal);
		panelTituloMenuPrincipal.setLayout(null);
		
		JLabel lblGameRecomendationEngine = new JLabel("Game Recomendation Engine");
		lblGameRecomendationEngine.setForeground(Color.WHITE);
		lblGameRecomendationEngine.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblGameRecomendationEngine.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameRecomendationEngine.setBounds(0, 0, 1034, 94);
		panelTituloMenuPrincipal.add(lblGameRecomendationEngine);
		
		Panel panelDatosMenuPrincipal = new Panel();
		panelDatosMenuPrincipal.setBackground(Color.DARK_GRAY);
		panelDatosMenuPrincipal.setBounds(0, 94, 1034, 434);
		lPanelMenuPrincipal.add(panelDatosMenuPrincipal);
		panelDatosMenuPrincipal.setLayout(null);
		
		
		
		// -------------------- BOTON OPCION AGREGAR VIDEOJUEGO --------------------
		
		
		Button btnOpcionAgregarVideojuego = new Button("Agregar videojuego");
		btnOpcionAgregarVideojuego.setBackground(Color.DARK_GRAY);
		btnOpcionAgregarVideojuego.setForeground(Color.WHITE);
		btnOpcionAgregarVideojuego.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOpcionAgregarVideojuego.setBounds(47, 76, 263, 46);
		panelDatosMenuPrincipal.add(btnOpcionAgregarVideojuego);
		
		
		// -------------------- BOTON OPCION ELIMINAR VIDEOJUEGO --------------------
		
		
		Button btnOpcionEliminarVideojuego = new Button("Eliminar videojuego");
		btnOpcionEliminarVideojuego.setForeground(Color.WHITE);
		btnOpcionEliminarVideojuego.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOpcionEliminarVideojuego.setBackground(Color.DARK_GRAY);
		btnOpcionEliminarVideojuego.setBounds(47, 155, 263, 46);
		panelDatosMenuPrincipal.add(btnOpcionEliminarVideojuego);
		
		
		// -------------------- BOTON OPCION AGREGAR USUARIO --------------------
		
		
		Button btnOpcionAgregarUsuario = new Button("Agregar usuario");
		btnOpcionAgregarUsuario.setForeground(Color.WHITE);
		btnOpcionAgregarUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOpcionAgregarUsuario.setBackground(Color.DARK_GRAY);
		btnOpcionAgregarUsuario.setBounds(47, 233, 263, 46);
		panelDatosMenuPrincipal.add(btnOpcionAgregarUsuario);
		
		
		// -------------------- BOTON OPCION ELIMINAR USUARIO --------------------
		
		
		Button btnOpcionEliminarUsuario = new Button("Eliminar usuario");
		btnOpcionEliminarUsuario.setForeground(Color.WHITE);
		btnOpcionEliminarUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOpcionEliminarUsuario.setBackground(Color.DARK_GRAY);
		btnOpcionEliminarUsuario.setBounds(47, 308, 263, 46);
		panelDatosMenuPrincipal.add(btnOpcionEliminarUsuario);
		
		Button btnOpcionRecomendacion = new Button("Obtener recomendacion de videojuego");
		btnOpcionRecomendacion.setForeground(Color.WHITE);
		btnOpcionRecomendacion.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOpcionRecomendacion.setBackground(Color.DARK_GRAY);
		btnOpcionRecomendacion.setBounds(626, 155, 355, 132);
		panelDatosMenuPrincipal.add(btnOpcionRecomendacion);
		

		
		
		
		
		
		
		
	
	
	
	}	
}
