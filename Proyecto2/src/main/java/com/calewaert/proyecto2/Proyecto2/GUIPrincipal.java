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

import org.neo4j.graphdb.GraphDatabaseService;

import javax.swing.JButton;
import java.awt.Button;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIPrincipal {

	private JFrame jramePrincipal;
	private JTextField txtTituloVideojuego;
	private JTextField txtAnoLanzamiento;
	private JTextField txtRating;

	
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
	
		// -------------------------------------------------------------- CONEXION Y OPERACIONES CON BASE DE DATOS -------------------------------------------------------------
		
		// Crear la clase de operaciones
		OperacionesDb operaciones = new OperacionesDb();
		
		// Asignar la conexion a la base de datos a una variable
		
		GraphDatabaseService graphDb = operaciones.crearConexionDb();
		
		// ----------------------------------------------------------------------------- MENU PRINCIPAL -------------------------------------------------------------
		
		
		
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

		Button btnOpcionAgregarVideojuego = new Button("Agregar videojuego");
		btnOpcionAgregarVideojuego.setBackground(Color.DARK_GRAY);
		btnOpcionAgregarVideojuego.setForeground(Color.WHITE);
		btnOpcionAgregarVideojuego.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOpcionAgregarVideojuego.setBounds(47, 76, 263, 46);
		panelDatosMenuPrincipal.add(btnOpcionAgregarVideojuego);
	
		Button btnOpcionEliminarVideojuego = new Button("Eliminar videojuego");
		btnOpcionEliminarVideojuego.setForeground(Color.WHITE);
		btnOpcionEliminarVideojuego.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOpcionEliminarVideojuego.setBackground(Color.DARK_GRAY);
		btnOpcionEliminarVideojuego.setBounds(47, 155, 263, 46);
		panelDatosMenuPrincipal.add(btnOpcionEliminarVideojuego);
		
		Button btnOpcionAgregarUsuario = new Button("Agregar usuario");
		btnOpcionAgregarUsuario.setForeground(Color.WHITE);
		btnOpcionAgregarUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		btnOpcionAgregarUsuario.setBackground(Color.DARK_GRAY);
		btnOpcionAgregarUsuario.setBounds(47, 233, 263, 46);
		panelDatosMenuPrincipal.add(btnOpcionAgregarUsuario);
		
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
		
		
		
		// ----------------------------------------------------------------------------- INGRESAR VIDEOJUEGO -------------------------------------------------------------
		
		
		
		JLayeredPane lPanelAgregarVideojuego = new JLayeredPane();
		jramePrincipal.getContentPane().add(lPanelAgregarVideojuego, "name_73136025245994");
		
		Panel panelTituloIngresarVideojuego = new Panel();
		panelTituloIngresarVideojuego.setBackground(new Color(255, 140, 0));
		panelTituloIngresarVideojuego.setBounds(0, 0, 1034, 46);
		lPanelAgregarVideojuego.add(panelTituloIngresarVideojuego);
		panelTituloIngresarVideojuego.setLayout(null);
		
		Label label = new Label("Agregar Videojuego");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 0, 1034, 46);
		panelTituloIngresarVideojuego.add(label);
		
		JPanel panelDatosIngresarVideojuego = new JPanel();
		panelDatosIngresarVideojuego.setBackground(Color.DARK_GRAY);
		panelDatosIngresarVideojuego.setBounds(0, 46, 1034, 482);
		lPanelAgregarVideojuego.add(panelDatosIngresarVideojuego);
		panelDatosIngresarVideojuego.setLayout(null);
		
		Label lblTituloVideojuego = new Label("Titulo videojuego:");
		lblTituloVideojuego.setForeground(Color.WHITE);
		lblTituloVideojuego.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTituloVideojuego.setBounds(10, 30, 127, 24);
		panelDatosIngresarVideojuego.add(lblTituloVideojuego);
		
		txtTituloVideojuego = new JTextField();
		txtTituloVideojuego.setHorizontalAlignment(SwingConstants.CENTER);
		txtTituloVideojuego.setBackground(Color.DARK_GRAY);
		txtTituloVideojuego.setForeground(Color.WHITE);
		txtTituloVideojuego.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTituloVideojuego.setBounds(154, 32, 274, 22);
		panelDatosIngresarVideojuego.add(txtTituloVideojuego);
		txtTituloVideojuego.setColumns(10);
		
		Label lblAnoLanzamiento = new Label("Año de lanzamiento:");
		lblAnoLanzamiento.setForeground(Color.WHITE);
		lblAnoLanzamiento.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAnoLanzamiento.setBounds(548, 30, 155, 24);
		panelDatosIngresarVideojuego.add(lblAnoLanzamiento);
		
		txtAnoLanzamiento = new JTextField();
		txtAnoLanzamiento.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnoLanzamiento.setForeground(Color.WHITE);
		txtAnoLanzamiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAnoLanzamiento.setColumns(10);
		txtAnoLanzamiento.setBackground(Color.DARK_GRAY);
		txtAnoLanzamiento.setBounds(709, 30, 39, 22);
		panelDatosIngresarVideojuego.add(txtAnoLanzamiento);
		
		Label lblRating = new Label("Rating:");
		lblRating.setForeground(Color.WHITE);
		lblRating.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRating.setBounds(864, 30, 63, 24);
		panelDatosIngresarVideojuego.add(lblRating);
		
		txtRating = new JTextField();
		txtRating.setHorizontalAlignment(SwingConstants.CENTER);
		txtRating.setForeground(Color.WHITE);
		txtRating.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRating.setColumns(10);
		txtRating.setBackground(Color.DARK_GRAY);
		txtRating.setBounds(933, 32, 31, 22);
		panelDatosIngresarVideojuego.add(txtRating);
		
		Label lblGeneros = new Label("Generos:");
		lblGeneros.setForeground(Color.WHITE);
		lblGeneros.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGeneros.setBounds(10, 107, 127, 24);
		panelDatosIngresarVideojuego.add(lblGeneros);
		
		JCheckBox chAccion = new JCheckBox("Acción");
		chAccion.setForeground(Color.WHITE);
		chAccion.setBackground(Color.DARK_GRAY);
		chAccion.setBounds(156, 106, 113, 25);
		panelDatosIngresarVideojuego.add(chAccion);
		
		JCheckBox chAventura = new JCheckBox("Aventura");
		chAventura.setForeground(Color.WHITE);
		chAventura.setBackground(Color.DARK_GRAY);
		chAventura.setBounds(274, 106, 113, 25);
		panelDatosIngresarVideojuego.add(chAventura);
		
		JCheckBox chRPG = new JCheckBox("RPG");
		chRPG.setForeground(Color.WHITE);
		chRPG.setBackground(Color.DARK_GRAY);
		chRPG.setBounds(395, 106, 113, 25);
		panelDatosIngresarVideojuego.add(chRPG);
		
		JCheckBox chSimulacion = new JCheckBox("Simulación");
		chSimulacion.setForeground(Color.WHITE);
		chSimulacion.setBackground(Color.DARK_GRAY);
		chSimulacion.setBounds(504, 106, 113, 25);
		panelDatosIngresarVideojuego.add(chSimulacion);
		
		JCheckBox chShooter = new JCheckBox("Shooter");
		chShooter.setForeground(Color.WHITE);
		chShooter.setBackground(Color.DARK_GRAY);
		chShooter.setBounds(621, 106, 113, 25);
		panelDatosIngresarVideojuego.add(chShooter);
		
		JCheckBox chEstrategia = new JCheckBox("Estrategia");
		chEstrategia.setForeground(Color.WHITE);
		chEstrategia.setBackground(Color.DARK_GRAY);
		chEstrategia.setBounds(732, 106, 113, 25);
		panelDatosIngresarVideojuego.add(chEstrategia);
		
		JCheckBox chHackAndSlash = new JCheckBox("Hack & Slash");
		chHackAndSlash.setForeground(Color.WHITE);
		chHackAndSlash.setBackground(Color.DARK_GRAY);
		chHackAndSlash.setBounds(864, 106, 113, 25);
		panelDatosIngresarVideojuego.add(chHackAndSlash);
		
		JCheckBox chPlataforma = new JCheckBox("Plataforma");
		chPlataforma.setForeground(Color.WHITE);
		chPlataforma.setBackground(Color.DARK_GRAY);
		chPlataforma.setBounds(156, 134, 113, 25);
		panelDatosIngresarVideojuego.add(chPlataforma);
		
		JCheckBox chFantasia = new JCheckBox("Fantasía");
		chFantasia.setForeground(Color.WHITE);
		chFantasia.setBackground(Color.DARK_GRAY);
		chFantasia.setBounds(274, 134, 113, 25);
		panelDatosIngresarVideojuego.add(chFantasia);
		
		JCheckBox chArcade = new JCheckBox("Arcade");
		chArcade.setForeground(Color.WHITE);
		chArcade.setBackground(Color.DARK_GRAY);
		chArcade.setBounds(395, 134, 113, 25);
		panelDatosIngresarVideojuego.add(chArcade);
		
		JCheckBox chSupervivencia = new JCheckBox("Supervivencia");
		chSupervivencia.setForeground(Color.WHITE);
		chSupervivencia.setBackground(Color.DARK_GRAY);
		chSupervivencia.setBounds(504, 134, 113, 25);
		panelDatosIngresarVideojuego.add(chSupervivencia);
		
		JCheckBox chHorror = new JCheckBox("Horror");
		chHorror.setForeground(Color.WHITE);
		chHorror.setBackground(Color.DARK_GRAY);
		chHorror.setBounds(621, 134, 113, 25);
		panelDatosIngresarVideojuego.add(chHorror);
		
		JCheckBox chPuzzle = new JCheckBox("Puzzle");
		chPuzzle.setForeground(Color.WHITE);
		chPuzzle.setBackground(Color.DARK_GRAY);
		chPuzzle.setBounds(732, 134, 113, 25);
		panelDatosIngresarVideojuego.add(chPuzzle);
		
		JCheckBox chMundoAbierto = new JCheckBox("Mundo Abierto");
		chMundoAbierto.setForeground(Color.WHITE);
		chMundoAbierto.setBackground(Color.DARK_GRAY);
		chMundoAbierto.setBounds(864, 134, 113, 25);
		panelDatosIngresarVideojuego.add(chMundoAbierto);
		
		Label lblPlataformas = new Label("Plataformas:");
		lblPlataformas.setForeground(Color.WHITE);
		lblPlataformas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPlataformas.setBounds(10, 199, 127, 24);
		panelDatosIngresarVideojuego.add(lblPlataformas);
		
		JCheckBox chPc = new JCheckBox("Pc");
		chPc.setForeground(Color.WHITE);
		chPc.setBackground(Color.DARK_GRAY);
		chPc.setBounds(156, 199, 113, 25);
		panelDatosIngresarVideojuego.add(chPc);
		
		JCheckBox chMac = new JCheckBox("Mac");
		chMac.setForeground(Color.WHITE);
		chMac.setBackground(Color.DARK_GRAY);
		chMac.setBounds(156, 229, 113, 25);
		panelDatosIngresarVideojuego.add(chMac);
		
		JCheckBox chLinux = new JCheckBox("Linux");
		chLinux.setForeground(Color.WHITE);
		chLinux.setBackground(Color.DARK_GRAY);
		chLinux.setBounds(156, 259, 113, 25);
		panelDatosIngresarVideojuego.add(chLinux);
		
		JCheckBox chFamicom = new JCheckBox("Famicom");
		chFamicom.setForeground(Color.WHITE);
		chFamicom.setBackground(Color.DARK_GRAY);
		chFamicom.setBounds(156, 291, 113, 25);
		panelDatosIngresarVideojuego.add(chFamicom);
		
		JCheckBox chDreamcast = new JCheckBox("Dreamcast");
		chDreamcast.setForeground(Color.WHITE);
		chDreamcast.setBackground(Color.DARK_GRAY);
		chDreamcast.setBounds(156, 321, 113, 25);
		panelDatosIngresarVideojuego.add(chDreamcast);
		
		JCheckBox chPlayStation4 = new JCheckBox("Play Station 4");
		chPlayStation4.setForeground(Color.WHITE);
		chPlayStation4.setBackground(Color.DARK_GRAY);
		chPlayStation4.setBounds(274, 199, 113, 25);
		panelDatosIngresarVideojuego.add(chPlayStation4);
		
		JCheckBox chPlayStation3 = new JCheckBox("Play Station 3");
		chPlayStation3.setForeground(Color.WHITE);
		chPlayStation3.setBackground(Color.DARK_GRAY);
		chPlayStation3.setBounds(274, 229, 113, 25);
		panelDatosIngresarVideojuego.add(chPlayStation3);
		
		JCheckBox chPlayStation2 = new JCheckBox("Play Station 2");
		chPlayStation2.setForeground(Color.WHITE);
		chPlayStation2.setBackground(Color.DARK_GRAY);
		chPlayStation2.setBounds(274, 259, 113, 25);
		panelDatosIngresarVideojuego.add(chPlayStation2);
		
		JCheckBox chPlayStation1 = new JCheckBox("Play Station 1");
		chPlayStation1.setForeground(Color.WHITE);
		chPlayStation1.setBackground(Color.DARK_GRAY);
		chPlayStation1.setBounds(274, 291, 113, 25);
		panelDatosIngresarVideojuego.add(chPlayStation1);
		
		JCheckBox chPsp = new JCheckBox("PSP");
		chPsp.setForeground(Color.WHITE);
		chPsp.setBackground(Color.DARK_GRAY);
		chPsp.setBounds(274, 321, 113, 25);
		panelDatosIngresarVideojuego.add(chPsp);
		
		JCheckBox chXboxOne = new JCheckBox("Xbox One");
		chXboxOne.setForeground(Color.WHITE);
		chXboxOne.setBackground(Color.DARK_GRAY);
		chXboxOne.setBounds(395, 199, 113, 25);
		panelDatosIngresarVideojuego.add(chXboxOne);
		
		JCheckBox chXbox360 = new JCheckBox("Xbox 360");
		chXbox360.setForeground(Color.WHITE);
		chXbox360.setBackground(Color.DARK_GRAY);
		chXbox360.setBounds(395, 229, 113, 25);
		panelDatosIngresarVideojuego.add(chXbox360);
		
		JCheckBox chXbox = new JCheckBox("Xbox");
		chXbox.setForeground(Color.WHITE);
		chXbox.setBackground(Color.DARK_GRAY);
		chXbox.setBounds(395, 259, 113, 25);
		panelDatosIngresarVideojuego.add(chXbox);
		
		JCheckBox chAtari = new JCheckBox("Atari");
		chAtari.setForeground(Color.WHITE);
		chAtari.setBackground(Color.DARK_GRAY);
		chAtari.setBounds(395, 291, 113, 25);
		panelDatosIngresarVideojuego.add(chAtari);
		
		JCheckBox chSwitch = new JCheckBox("Switch");
		chSwitch.setHorizontalAlignment(SwingConstants.LEFT);
		chSwitch.setForeground(Color.WHITE);
		chSwitch.setBackground(Color.DARK_GRAY);
		chSwitch.setBounds(504, 199, 113, 25);
		panelDatosIngresarVideojuego.add(chSwitch);
		
		JCheckBox chWiiU = new JCheckBox("Wii U");
		chWiiU.setForeground(Color.WHITE);
		chWiiU.setBackground(Color.DARK_GRAY);
		chWiiU.setBounds(504, 229, 113, 25);
		panelDatosIngresarVideojuego.add(chWiiU);
		
		JCheckBox chWii = new JCheckBox("Wii");
		chWii.setForeground(Color.WHITE);
		chWii.setBackground(Color.DARK_GRAY);
		chWii.setBounds(504, 259, 113, 25);
		panelDatosIngresarVideojuego.add(chWii);
		
		JCheckBox chGameCube = new JCheckBox("Game Cube");
		chGameCube.setForeground(Color.WHITE);
		chGameCube.setBackground(Color.DARK_GRAY);
		chGameCube.setBounds(504, 291, 113, 25);
		panelDatosIngresarVideojuego.add(chGameCube);
		
		JCheckBox chN64 = new JCheckBox("N64");
		chN64.setForeground(Color.WHITE);
		chN64.setBackground(Color.DARK_GRAY);
		chN64.setBounds(504, 321, 113, 25);
		panelDatosIngresarVideojuego.add(chN64);
		
		JCheckBox chDs = new JCheckBox("Ds");
		chDs.setForeground(Color.WHITE);
		chDs.setBackground(Color.DARK_GRAY);
		chDs.setBounds(621, 199, 82, 25);
		panelDatosIngresarVideojuego.add(chDs);
		
		JCheckBox ch2Ds = new JCheckBox("2Ds");
		ch2Ds.setForeground(Color.WHITE);
		ch2Ds.setBackground(Color.DARK_GRAY);
		ch2Ds.setBounds(621, 229, 82, 25);
		panelDatosIngresarVideojuego.add(ch2Ds);
		
		JCheckBox ch3Ds = new JCheckBox("3Ds");
		ch3Ds.setForeground(Color.WHITE);
		ch3Ds.setBackground(Color.DARK_GRAY);
		ch3Ds.setBounds(621, 259, 82, 25);
		panelDatosIngresarVideojuego.add(ch3Ds);
		
		JCheckBox chGBA = new JCheckBox("GBA");
		chGBA.setForeground(Color.WHITE);
		chGBA.setBackground(Color.DARK_GRAY);
		chGBA.setBounds(621, 291, 82, 25);
		panelDatosIngresarVideojuego.add(chGBA);
		
		JCheckBox chGameBoy = new JCheckBox("Game Boy");
		chGameBoy.setForeground(Color.WHITE);
		chGameBoy.setBackground(Color.DARK_GRAY);
		chGameBoy.setBounds(621, 321, 92, 25);
		panelDatosIngresarVideojuego.add(chGameBoy);
		
		JCheckBox chSegaGenesis = new JCheckBox("Sega Genesis");
		chSegaGenesis.setForeground(Color.WHITE);
		chSegaGenesis.setBackground(Color.DARK_GRAY);
		chSegaGenesis.setBounds(154, 351, 113, 25);
		panelDatosIngresarVideojuego.add(chSegaGenesis);
		
		JCheckBox chSNES = new JCheckBox("SNES");
		chSNES.setForeground(Color.WHITE);
		chSNES.setBackground(Color.DARK_GRAY);
		chSNES.setBounds(504, 351, 113, 25);
		panelDatosIngresarVideojuego.add(chSNES);
		
		JCheckBox chNES = new JCheckBox("NES");
		chNES.setForeground(Color.WHITE);
		chNES.setBackground(Color.DARK_GRAY);
		chNES.setBounds(621, 351, 82, 25);
		panelDatosIngresarVideojuego.add(chNES);
		
		Label lblModosDeJuego = new Label("Modos de juego:");
		lblModosDeJuego.setForeground(Color.WHITE);
		lblModosDeJuego.setFont(new Font("Dialog", Font.BOLD, 14));
		lblModosDeJuego.setBounds(10, 409, 127, 24);
		panelDatosIngresarVideojuego.add(lblModosDeJuego);
		
		JCheckBox chSinglePlayer = new JCheckBox("Single Player");
		chSinglePlayer.setForeground(Color.WHITE);
		chSinglePlayer.setBackground(Color.DARK_GRAY);
		chSinglePlayer.setBounds(154, 409, 113, 25);
		panelDatosIngresarVideojuego.add(chSinglePlayer);
		
		JCheckBox chMultiplayer = new JCheckBox("Multiplayer");
		chMultiplayer.setForeground(Color.WHITE);
		chMultiplayer.setBackground(Color.DARK_GRAY);
		chMultiplayer.setBounds(154, 437, 113, 25);
		panelDatosIngresarVideojuego.add(chMultiplayer);
		
		Label lblPerspectiva = new Label("Perspectiva:");
		lblPerspectiva.setForeground(Color.WHITE);
		lblPerspectiva.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPerspectiva.setBounds(274, 409, 127, 24);
		panelDatosIngresarVideojuego.add(lblPerspectiva);
		
		JCheckBox chPrimeraPersona = new JCheckBox("1ra Persona");
		chPrimeraPersona.setForeground(Color.WHITE);
		chPrimeraPersona.setBackground(Color.DARK_GRAY);
		chPrimeraPersona.setBounds(395, 409, 113, 25);
		panelDatosIngresarVideojuego.add(chPrimeraPersona);
		
		JCheckBox chTerceraPersona = new JCheckBox("3ra Persona");
		chTerceraPersona.setForeground(Color.WHITE);
		chTerceraPersona.setBackground(Color.DARK_GRAY);
		chTerceraPersona.setBounds(395, 437, 113, 25);
		panelDatosIngresarVideojuego.add(chTerceraPersona);
		
		JCheckBox chVistaArea = new JCheckBox("Vista Aerea");
		chVistaArea.setForeground(Color.WHITE);
		chVistaArea.setBackground(Color.DARK_GRAY);
		chVistaArea.setBounds(504, 409, 113, 25);
		panelDatosIngresarVideojuego.add(chVistaArea);
		
		Label lblDescripcion = new Label("Descripción:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDescripcion.setBounds(732, 199, 127, 24);
		panelDatosIngresarVideojuego.add(lblDescripcion);
		
		JTextArea txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(732, 230, 274, 192);
		panelDatosIngresarVideojuego.add(txtDescripcion);

		Button btnCancelarAgregarVideojuego = new Button("Cancelar");
		btnCancelarAgregarVideojuego.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCancelarAgregarVideojuego.setForeground(Color.WHITE);
		btnCancelarAgregarVideojuego.setBackground(new Color(255, 99, 71));
		btnCancelarAgregarVideojuego.setBounds(731, 439, 99, 34);
		panelDatosIngresarVideojuego.add(btnCancelarAgregarVideojuego);
		
		Button btnAgregarVideojuego = new Button("Agregar Videojuego");
		btnAgregarVideojuego.setBackground(new Color(255, 140, 0));
		btnAgregarVideojuego.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAgregarVideojuego.setForeground(Color.WHITE);
		btnAgregarVideojuego.setBounds(851, 438, 155, 34);
		panelDatosIngresarVideojuego.add(btnAgregarVideojuego);
		
		
		
		// ----------------------------------------------------------------------------- ACCIONES BOTONES -------------------------------------------------------------
		
		
		
		// --------------------------------------------- MENU PRINCIPAL --------------------------------
		
		
		// BOTON OPCION AGREGAR VIDEOJUEGOS
		
		btnOpcionAgregarVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Ocultar elementos Menu Principal
				
				lPanelMenuPrincipal.setVisible(false);
				
				// Mostrar elementos Agregar Videojuego
				
				lPanelAgregarVideojuego.setVisible(true);
			}
		});
		
		
		// ------------------------------------------- AGREGAR VIDEOJUEGOS --------------------------------
		
		
		// BOTON CANCELAR AGREGAR VIDEOJUEGOS
		
		btnCancelarAgregarVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Ocultar elementos Agregar Videojuego
				
				lPanelAgregarVideojuego.setVisible(false);
				
				// Mostrar elementos Menu Principal
				

				lPanelMenuPrincipal.setVisible(true);
				
			}
		});
		
		// BOTON AGREGAR VIDEOJUEGO
		
		btnAgregarVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
	}	
}
