package com.calewaert.proyecto2.Proyecto2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import java.awt.Button;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class GUIPrincipal {

	private JFrame jramePrincipal;
	private JTextField txtTituloVideojuego;
	private JTextField txtAnoLanzamiento;
	private JTextField txtRating;
	private JTextField txtNombre;
	private JTextField txtEdadUsuario;
	private JComboBox<String> txtVideojuegoFav1;
	private JComboBox<String> txtVideojuegoFav2;
	private JComboBox<String> txtVideojuegoFav3;
	private JComboBox<String> txtVideojuegoDisf1;
	private JComboBox<String> txtVideojuegoDisf2;
	private JComboBox<String> txtVideojuegoDisf3;
	private JTextField txtNombreUsuario;
	private JTextField txtContraseña;
	private JTextField txtUserRecomendacion;
	private JPasswordField txtpasswordField;
	private JTable tablaRecomendaciones;
	private JComboBox<String> txtTituloVideojuegoEliminar;
	
	// Variables preguntas usuario
	private int contadorPreguntas = 0;
	private int progresoBarraPreguntas = 0;
	private int respPregunta1Accion = 0;
	private int respPregunta2Social = 0;
	private int respPregunta3Maestria = 0;
	private int respPregunta4Logros = 0;
	private int respPregunta5Creatividad = 0;
	private int respPregunta6Inmersion = 0;
	

	
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
		jramePrincipal.setTitle("GRE");
		jramePrincipal.setBounds(100, 100, 1040, 563);

		jramePrincipal.getContentPane().setBackground(new Color(128, 128, 128));
		jramePrincipal.getContentPane().setLayout(new CardLayout(0, 0));
	
		// -------------------------------------------------------------- CONEXION Y OPERACIONES CON BASE DE DATOS -------------------------------------------------------------
		
		// Crear la clase de operaciones
		OperacionesDb operaciones = new OperacionesDb();
		
		// Asignar la conexion a la base de datos a una variable
		
		GraphDatabaseService graphDb = operaciones.crearConexionDb(jramePrincipal);
		
		// Cerrar Base de datos al cerrar ventana
		
		jramePrincipal.setDefaultCloseOperation(operaciones.cerrarConexion(graphDb));
		
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
		txtDescripcion.setBounds(732, 230, 274, 79);
		txtDescripcion.setLineWrap(true);
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
		
		Label lblMotivaciones = new Label("Motivaciones:");
		lblMotivaciones.setForeground(Color.WHITE);
		lblMotivaciones.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMotivaciones.setBounds(732, 321, 127, 24);
		panelDatosIngresarVideojuego.add(lblMotivaciones);
		
		JCheckBox chMAccion = new JCheckBox("Accion");
		chMAccion.setForeground(Color.WHITE);
		chMAccion.setBackground(Color.DARK_GRAY);
		chMAccion.setBounds(732, 351, 113, 25);
		panelDatosIngresarVideojuego.add(chMAccion);
		
		JCheckBox chMSocial = new JCheckBox("Social");
		chMSocial.setForeground(Color.WHITE);
		chMSocial.setBackground(Color.DARK_GRAY);
		chMSocial.setBounds(732, 381, 113, 25);
		panelDatosIngresarVideojuego.add(chMSocial);
		
		JCheckBox chMMaestria = new JCheckBox("Maestria");
		chMMaestria.setForeground(Color.WHITE);
		chMMaestria.setBackground(Color.DARK_GRAY);
		chMMaestria.setBounds(732, 408, 113, 25);
		panelDatosIngresarVideojuego.add(chMMaestria);
		
		JCheckBox chMLogros = new JCheckBox("Logros");
		chMLogros.setForeground(Color.WHITE);
		chMLogros.setBackground(Color.DARK_GRAY);
		chMLogros.setBounds(864, 351, 113, 25);
		panelDatosIngresarVideojuego.add(chMLogros);
		
		JCheckBox chMCreatividad = new JCheckBox("Creatividad");
		chMCreatividad.setForeground(Color.WHITE);
		chMCreatividad.setBackground(Color.DARK_GRAY);
		chMCreatividad.setBounds(864, 381, 113, 25);
		panelDatosIngresarVideojuego.add(chMCreatividad);
		
		JCheckBox chMInmersion = new JCheckBox("Inmersion");
		chMInmersion.setForeground(Color.WHITE);
		chMInmersion.setBackground(Color.DARK_GRAY);
		chMInmersion.setBounds(864, 409, 113, 25);
		panelDatosIngresarVideojuego.add(chMInmersion);
		
		JCheckBox chVistaLateral = new JCheckBox("Vista Lateral");
		chVistaLateral.setForeground(Color.WHITE);
		chVistaLateral.setBackground(Color.DARK_GRAY);
		chVistaLateral.setBounds(504, 437, 113, 25);
		panelDatosIngresarVideojuego.add(chVistaLateral);
		
		JCheckBox chDeporte = new JCheckBox("Deporte");
		chDeporte.setForeground(Color.WHITE);
		chDeporte.setBackground(Color.DARK_GRAY);
		chDeporte.setBounds(864, 160, 113, 25);
		panelDatosIngresarVideojuego.add(chDeporte);
		
		
		
		
		// ----------------------------------------------------------------------------- INGRESAR USUARIO -------------------------------------------------------------
		
		
		
		JLayeredPane lPanelAgregarUsuario = new JLayeredPane();
		jramePrincipal.getContentPane().add(lPanelAgregarUsuario, "name_304202694180708");
		
		JPanel panelTituloAgregarUsuario = new JPanel();
		panelTituloAgregarUsuario.setBackground(new Color(255, 140, 0));
		panelTituloAgregarUsuario.setBounds(0, 0, 1034, 46);
		lPanelAgregarUsuario.add(panelTituloAgregarUsuario);
		panelTituloAgregarUsuario.setLayout(null);
		
		JLabel lblAgregarUsuario = new JLabel("Agregar Usuario");
		lblAgregarUsuario.setForeground(Color.WHITE);
		lblAgregarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAgregarUsuario.setBounds(0, 0, 1034, 46);
		panelTituloAgregarUsuario.add(lblAgregarUsuario);
	
		JPanel panelDatosAgregarUsuario = new JPanel();
		panelDatosAgregarUsuario.setBackground(Color.DARK_GRAY);
		panelDatosAgregarUsuario.setBounds(0, 46, 1034, 482);
		lPanelAgregarUsuario.add(panelDatosAgregarUsuario);
		panelDatosAgregarUsuario.setLayout(null);
		
		Label lblNombre = new Label("Nombre :");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNombre.setBounds(10, 22, 77, 24);
		panelDatosAgregarUsuario.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.DARK_GRAY);
		txtNombre.setBounds(93, 24, 274, 22);
		panelDatosAgregarUsuario.add(txtNombre);
		
		Label lblEdad = new Label("Edad:");
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEdad.setBounds(410, 22, 45, 24);
		panelDatosAgregarUsuario.add(lblEdad);
		
		txtEdadUsuario = new JTextField();
		txtEdadUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdadUsuario.setForeground(Color.WHITE);
		txtEdadUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEdadUsuario.setColumns(10);
		txtEdadUsuario.setBackground(Color.DARK_GRAY);
		txtEdadUsuario.setBounds(468, 24, 27, 22);
		panelDatosAgregarUsuario.add(txtEdadUsuario);
		
		Label lblGeneroUsuario = new Label("Género:");
		lblGeneroUsuario.setForeground(Color.WHITE);
		lblGeneroUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGeneroUsuario.setBounds(557, 22, 70, 24);
		panelDatosAgregarUsuario.add(lblGeneroUsuario);
		
		JRadioButton rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.setBackground(Color.DARK_GRAY);
		rdbMasculino.setForeground(Color.WHITE);
		rdbMasculino.setBounds(633, 22, 91, 25);
		panelDatosAgregarUsuario.add(rdbMasculino);
		
		JRadioButton rdbFemenino = new JRadioButton("Femenino");
		rdbFemenino.setForeground(Color.WHITE);
		rdbFemenino.setBackground(Color.DARK_GRAY);
		rdbFemenino.setBounds(728, 21, 91, 25);
		panelDatosAgregarUsuario.add(rdbFemenino);
		
		ButtonGroup grupoOpcionGenero = new ButtonGroup();
		grupoOpcionGenero.add(rdbMasculino);
		grupoOpcionGenero.add(rdbFemenino);
		
		
		Label lblIngreseVideojuegosFav = new Label("Cuales son sus tres videojuegos favoritos:");
		lblIngreseVideojuegosFav.setForeground(Color.WHITE);
		lblIngreseVideojuegosFav.setFont(new Font("Dialog", Font.BOLD, 14));
		lblIngreseVideojuegosFav.setBounds(10, 96, 325, 24);
		panelDatosAgregarUsuario.add(lblIngreseVideojuegosFav);
		
		txtVideojuegoFav1 = new JComboBox<>();
		txtVideojuegoFav1.setForeground(Color.WHITE);
		txtVideojuegoFav1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVideojuegoFav1.setBackground(Color.DARK_GRAY);
		txtVideojuegoFav1.setBounds(10, 133, 274, 22);
		panelDatosAgregarUsuario.add(txtVideojuegoFav1);
		
		txtVideojuegoFav2 = new JComboBox<>();
		txtVideojuegoFav2.setForeground(Color.WHITE);
		txtVideojuegoFav2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVideojuegoFav2.setBackground(Color.DARK_GRAY);
		txtVideojuegoFav2.setBounds(10, 168, 274, 22);
		panelDatosAgregarUsuario.add(txtVideojuegoFav2);
		
		txtVideojuegoFav3 = new JComboBox<>();
		txtVideojuegoFav3.setForeground(Color.WHITE);
		txtVideojuegoFav3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVideojuegoFav3.setBackground(Color.DARK_GRAY);
		txtVideojuegoFav3.setBounds(10, 203, 274, 22);
		panelDatosAgregarUsuario.add(txtVideojuegoFav3);
		
		Label lblUltimosTresVideojuegos = new Label("Ultimos tres videojuegos que ha disfrutado:");
		lblUltimosTresVideojuegos.setForeground(Color.WHITE);
		lblUltimosTresVideojuegos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUltimosTresVideojuegos.setBounds(10, 257, 325, 24);
		panelDatosAgregarUsuario.add(lblUltimosTresVideojuegos);
		
		txtVideojuegoDisf1 = new JComboBox<>();
		txtVideojuegoDisf1.setForeground(Color.WHITE);
		txtVideojuegoDisf1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVideojuegoDisf1.setBackground(Color.DARK_GRAY);
		txtVideojuegoDisf1.setBounds(10, 287, 274, 22);
		panelDatosAgregarUsuario.add(txtVideojuegoDisf1);
		
		txtVideojuegoDisf2 = new JComboBox<>();
		txtVideojuegoDisf2.setForeground(Color.WHITE);
		txtVideojuegoDisf2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVideojuegoDisf2.setBackground(Color.DARK_GRAY);
		txtVideojuegoDisf2.setBounds(10, 322, 274, 22);
		panelDatosAgregarUsuario.add(txtVideojuegoDisf2);
		
		txtVideojuegoDisf3 = new JComboBox<>();
		txtVideojuegoDisf3.setForeground(Color.WHITE);
		txtVideojuegoDisf3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVideojuegoDisf3.setBackground(Color.DARK_GRAY);
		txtVideojuegoDisf3.setBounds(10, 357, 274, 22);
		panelDatosAgregarUsuario.add(txtVideojuegoDisf3);
		
		// Agregar autocompletar a los textFields
		
		EventList<String> listaTitulos = operaciones.ListaVideojuegos(graphDb);
		
		AutoCompleteSupport.install(txtVideojuegoFav1, listaTitulos);
		AutoCompleteSupport.install(txtVideojuegoFav2, listaTitulos);
		AutoCompleteSupport.install(txtVideojuegoFav3, listaTitulos);
		AutoCompleteSupport.install(txtVideojuegoDisf1, listaTitulos);
		AutoCompleteSupport.install(txtVideojuegoDisf2, listaTitulos);
		AutoCompleteSupport.install(txtVideojuegoDisf3, listaTitulos);
		
		
		JPanel panelPreguntas = new JPanel();
		panelPreguntas.setOpaque(false);
		panelPreguntas.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelPreguntas.setBackground(Color.DARK_GRAY);
		panelPreguntas.setBounds(351, 101, 671, 195);
		panelDatosAgregarUsuario.add(panelPreguntas);
		panelPreguntas.setLayout(null);
		
		Label lblPreguntas = new Label("Que opina sobre una trama/historia elaborada en un videojuego:");
		lblPreguntas.setForeground(Color.WHITE);
		lblPreguntas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPreguntas.setBounds(8, 10, 651, 40);
		panelPreguntas.add(lblPreguntas);
		
		JRadioButton rdbNadaImportante = new JRadioButton("Nada Importante");
		rdbNadaImportante.setForeground(Color.WHITE);
		rdbNadaImportante.setBackground(Color.DARK_GRAY);
		rdbNadaImportante.setBounds(8, 56, 125, 25);
		panelPreguntas.add(rdbNadaImportante);
		
		JRadioButton rdbAlgoImportante = new JRadioButton("Algo Importante");
		rdbAlgoImportante.setForeground(Color.WHITE);
		rdbAlgoImportante.setBackground(Color.DARK_GRAY);
		rdbAlgoImportante.setBounds(130, 56, 125, 25);
		panelPreguntas.add(rdbAlgoImportante);
		
		JRadioButton rdbImportante = new JRadioButton("Importante");
		rdbImportante.setForeground(Color.WHITE);
		rdbImportante.setBackground(Color.DARK_GRAY);
		rdbImportante.setBounds(250, 56, 91, 25);
		panelPreguntas.add(rdbImportante);
		
		JRadioButton rdbBastanteImportante = new JRadioButton("Bastante Importante");
		rdbBastanteImportante.setForeground(Color.WHITE);
		rdbBastanteImportante.setBackground(Color.DARK_GRAY);
		rdbBastanteImportante.setBounds(340, 56, 145, 25);
		panelPreguntas.add(rdbBastanteImportante);
		
		JRadioButton rdbExtremadamenteImportante = new JRadioButton("Extrenadanente Importante");
		rdbExtremadamenteImportante.setForeground(Color.WHITE);
		rdbExtremadamenteImportante.setBackground(Color.DARK_GRAY);
		rdbExtremadamenteImportante.setBounds(480, 56, 189, 25);
		panelPreguntas.add(rdbExtremadamenteImportante);
		
		ButtonGroup grupoOpcionImportacia = new ButtonGroup();
		grupoOpcionImportacia.add(rdbNadaImportante);
		grupoOpcionImportacia.add(rdbAlgoImportante);
		grupoOpcionImportacia.add(rdbImportante);
		grupoOpcionImportacia.add(rdbBastanteImportante);
		grupoOpcionImportacia.add(rdbExtremadamenteImportante);
		
		JProgressBar barraDeProgresoPreguntas = new JProgressBar();
		barraDeProgresoPreguntas.setBorder(new LineBorder(Color.WHITE));
		barraDeProgresoPreguntas.setOpaque(true);
		barraDeProgresoPreguntas.setForeground(new Color(255, 140, 0));
		barraDeProgresoPreguntas.setValue(20);
		barraDeProgresoPreguntas.setStringPainted(true);
		barraDeProgresoPreguntas.setBackground(Color.DARK_GRAY);
		barraDeProgresoPreguntas.setBounds(8, 155, 651, 19);
		panelPreguntas.add(barraDeProgresoPreguntas);
		
		Button btnAnteriorPregunta = new Button("Anterior");
		btnAnteriorPregunta.setBackground(Color.DARK_GRAY);
		btnAnteriorPregunta.setForeground(Color.WHITE);
		btnAnteriorPregunta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnteriorPregunta.setBounds(212, 108, 91, 25);
		panelPreguntas.add(btnAnteriorPregunta);
		
		Button btnSiguientePregunta = new Button("Siguiente");
		btnSiguientePregunta.setBackground(Color.DARK_GRAY);
		btnSiguientePregunta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSiguientePregunta.setForeground(Color.WHITE);
		btnSiguientePregunta.setBounds(354, 108, 91, 25);
		panelPreguntas.add(btnSiguientePregunta);
		
		Button btnAgregarUsuario = new Button("Agregar Usuario");
		btnAgregarUsuario.setForeground(Color.WHITE);
		btnAgregarUsuario.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAgregarUsuario.setBackground(new Color(255, 140, 0));
		btnAgregarUsuario.setBounds(867, 427, 155, 34);
		panelDatosAgregarUsuario.add(btnAgregarUsuario);
		
		Button btnCancelarAgregarUsuario = new Button("Cancelar");
		btnCancelarAgregarUsuario.setForeground(Color.WHITE);
		btnCancelarAgregarUsuario.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCancelarAgregarUsuario.setBackground(new Color(255, 99, 71));
		btnCancelarAgregarUsuario.setBounds(728, 427, 99, 34);
		panelDatosAgregarUsuario.add(btnCancelarAgregarUsuario);
		
		Label lblNombreUsuario = new Label("Nombre de usuario:");
		lblNombreUsuario.setForeground(Color.WHITE);
		lblNombreUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNombreUsuario.setBounds(351, 322, 145, 24);
		panelDatosAgregarUsuario.add(lblNombreUsuario);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreUsuario.setForeground(Color.WHITE);
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBackground(Color.DARK_GRAY);
		txtNombreUsuario.setBounds(351, 357, 274, 22);
		panelDatosAgregarUsuario.add(txtNombreUsuario);
		
		Label lblContraseña = new Label("Contraseña:");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setFont(new Font("Dialog", Font.BOLD, 14));
		lblContraseña.setBounds(728, 320, 145, 24);
		panelDatosAgregarUsuario.add(lblContraseña);
		
		txtContraseña = new JTextField();
		txtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		txtContraseña.setForeground(Color.WHITE);
		txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtContraseña.setColumns(10);
		txtContraseña.setBackground(Color.DARK_GRAY);
		txtContraseña.setBounds(728, 357, 274, 22);
		panelDatosAgregarUsuario.add(txtContraseña);
		
		// ----------------------------------------------------------------------------- OBTENER RECOMENDACION -------------------------------------------------------------
		
		JLayeredPane lPanelObtenerRecomendacion = new JLayeredPane();
		jramePrincipal.getContentPane().add(lPanelObtenerRecomendacion, "name_141227190678198");
		
		JPanel panelTituloRecomendaciones = new JPanel();
		panelTituloRecomendaciones.setLayout(null);
		panelTituloRecomendaciones.setBackground(new Color(255, 140, 0));
		panelTituloRecomendaciones.setBounds(0, 0, 1034, 46);
		lPanelObtenerRecomendacion.add(panelTituloRecomendaciones);
		
		JLabel lblTituloRecomendacion = new JLabel("Obtener Recomendacion");
		lblTituloRecomendacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloRecomendacion.setForeground(Color.WHITE);
		lblTituloRecomendacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTituloRecomendacion.setBounds(0, 0, 1034, 46);
		panelTituloRecomendaciones.add(lblTituloRecomendacion);
		
		JPanel panelDatosRecomendaciones = new JPanel();
		panelDatosRecomendaciones.setLayout(null);
		panelDatosRecomendaciones.setBackground(Color.DARK_GRAY);
		panelDatosRecomendaciones.setBounds(0, 46, 1034, 482);
		lPanelObtenerRecomendacion.add(panelDatosRecomendaciones);
		
		Label lblUserRecomendacion = new Label("Ingrese nombre de usuario (User) :");
		lblUserRecomendacion.setForeground(Color.WHITE);
		lblUserRecomendacion.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUserRecomendacion.setBounds(10, 22, 260, 24);
		panelDatosRecomendaciones.add(lblUserRecomendacion);
		
		txtUserRecomendacion = new JTextField();
		txtUserRecomendacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserRecomendacion.setForeground(Color.WHITE);
		txtUserRecomendacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUserRecomendacion.setColumns(10);
		txtUserRecomendacion.setBackground(Color.DARK_GRAY);
		txtUserRecomendacion.setBounds(276, 24, 209, 22);
		panelDatosRecomendaciones.add(txtUserRecomendacion);
		
		Button btnObtenerRecomendacion = new Button("Obtener recomendacion");
		btnObtenerRecomendacion.setForeground(Color.WHITE);
		btnObtenerRecomendacion.setFont(new Font("Dialog", Font.BOLD, 13));
		btnObtenerRecomendacion.setBackground(new Color(255, 140, 0));
		btnObtenerRecomendacion.setBounds(806, 427, 186, 34);
		panelDatosRecomendaciones.add(btnObtenerRecomendacion);
		
		Button btnCancelarRecomendacion = new Button("Cancelar");
		btnCancelarRecomendacion.setForeground(Color.WHITE);
		btnCancelarRecomendacion.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCancelarRecomendacion.setBackground(new Color(255, 99, 71));
		btnCancelarRecomendacion.setBounds(670, 427, 99, 34);
		panelDatosRecomendaciones.add(btnCancelarRecomendacion);
		
		Label lblPassword = new Label("Contraseña:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(546, 22, 99, 24);
		panelDatosRecomendaciones.add(lblPassword);
		
		txtpasswordField = new JPasswordField();
		txtpasswordField.setForeground(Color.WHITE);
		txtpasswordField.setBackground(Color.DARK_GRAY);
		txtpasswordField.setBounds(651, 24, 132, 22);
		panelDatosRecomendaciones.add(txtpasswordField);
		
		tablaRecomendaciones = new JTable();
		tablaRecomendaciones.setBorder(new LineBorder(Color.WHITE));
		tablaRecomendaciones.setBackground(Color.DARK_GRAY);
		tablaRecomendaciones.setBounds(377, 75, 615, 315);
		panelDatosRecomendaciones.add(tablaRecomendaciones);
		
		Label lblRangoDeLanzamientoRecomendacion = new Label("Rango de lanzamiento:");
		lblRangoDeLanzamientoRecomendacion.setForeground(Color.WHITE);
		lblRangoDeLanzamientoRecomendacion.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRangoDeLanzamientoRecomendacion.setBounds(10, 147, 173, 24);
		panelDatosRecomendaciones.add(lblRangoDeLanzamientoRecomendacion);
		
		JRadioButton rdbAntiguosRecomendacion = new JRadioButton("Antiguos");
		rdbAntiguosRecomendacion.setForeground(Color.WHITE);
		rdbAntiguosRecomendacion.setBackground(Color.DARK_GRAY);
		rdbAntiguosRecomendacion.setBounds(10, 177, 99, 25);
		panelDatosRecomendaciones.add(rdbAntiguosRecomendacion);
		
		JRadioButton rdbSemiRecientesRecomendacion = new JRadioButton("Semi-recientes");
		rdbSemiRecientesRecomendacion.setForeground(Color.WHITE);
		rdbSemiRecientesRecomendacion.setBackground(Color.DARK_GRAY);
		rdbSemiRecientesRecomendacion.setBounds(113, 177, 125, 25);
		panelDatosRecomendaciones.add(rdbSemiRecientesRecomendacion);
		
		JRadioButton rdbRecientesRecomendacion = new JRadioButton("Recientes");
		rdbRecientesRecomendacion.setForeground(Color.WHITE);
		rdbRecientesRecomendacion.setBackground(Color.DARK_GRAY);
		rdbRecientesRecomendacion.setBounds(242, 177, 99, 25);
		panelDatosRecomendaciones.add(rdbRecientesRecomendacion);
		
		// Grupo rango lanzamiento
		ButtonGroup grupoRangoDeLanzamiento = new ButtonGroup();
		grupoRangoDeLanzamiento.add(rdbAntiguosRecomendacion);
		grupoRangoDeLanzamiento.add(rdbSemiRecientesRecomendacion);
		grupoRangoDeLanzamiento.add(rdbRecientesRecomendacion);
		
		
		Label lblPopularidadRecomendacion = new Label("Popularidad:");
		lblPopularidadRecomendacion.setForeground(Color.WHITE);
		lblPopularidadRecomendacion.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPopularidadRecomendacion.setBounds(10, 258, 173, 24);
		panelDatosRecomendaciones.add(lblPopularidadRecomendacion);
		
		JRadioButton rdbNoTanPopularesRecomendacion = new JRadioButton("No tan populares");
		rdbNoTanPopularesRecomendacion.setForeground(Color.WHITE);
		rdbNoTanPopularesRecomendacion.setBackground(Color.DARK_GRAY);
		rdbNoTanPopularesRecomendacion.setBounds(10, 288, 132, 25);
		panelDatosRecomendaciones.add(rdbNoTanPopularesRecomendacion);
		
		JRadioButton rdbPopularesRecomendacion = new JRadioButton("Populares");
		rdbPopularesRecomendacion.setForeground(Color.WHITE);
		rdbPopularesRecomendacion.setBackground(Color.DARK_GRAY);
		rdbPopularesRecomendacion.setBounds(146, 288, 125, 25);
		panelDatosRecomendaciones.add(rdbPopularesRecomendacion);
		
		// Grupo popularidad
		
		ButtonGroup grupoPopularidadRecomendaciones = new ButtonGroup();
		grupoPopularidadRecomendaciones.add(rdbNoTanPopularesRecomendacion);
		grupoPopularidadRecomendaciones.add(rdbPopularesRecomendacion);
		
		JCheckBox chAjustarPreferencias = new JCheckBox("Ajustar Preferencias");
		chAjustarPreferencias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chAjustarPreferencias.setHorizontalAlignment(SwingConstants.CENTER);
		chAjustarPreferencias.setForeground(Color.WHITE);
		chAjustarPreferencias.setBackground(Color.DARK_GRAY);
		chAjustarPreferencias.setBounds(25, 88, 325, 25);
		panelDatosRecomendaciones.add(chAjustarPreferencias);
		
		
		
		// ----------------------------------------------------------------------------- ELIMINAR VIDEOJUEGO -------------------------------------------------------------
		
		
		
		JLayeredPane lPanelEliminarVideojuego = new JLayeredPane();
		jramePrincipal.getContentPane().add(lPanelEliminarVideojuego, "name_172903503945285");
		
		JPanel panelTituloEliminarVideojuego = new JPanel();
		panelTituloEliminarVideojuego.setLayout(null);
		panelTituloEliminarVideojuego.setBackground(new Color(255, 140, 0));
		panelTituloEliminarVideojuego.setBounds(0, 0, 1034, 46);
		lPanelEliminarVideojuego.add(panelTituloEliminarVideojuego);
		
		JLabel lblEliminarVideojuego = new JLabel("Eliminar Videojuego");
		lblEliminarVideojuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarVideojuego.setForeground(Color.WHITE);
		lblEliminarVideojuego.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEliminarVideojuego.setBounds(0, 0, 1034, 46);
		panelTituloEliminarVideojuego.add(lblEliminarVideojuego);
		
		JPanel panelDatosEliminarVideojuego = new JPanel();
		panelDatosEliminarVideojuego.setLayout(null);
		panelDatosEliminarVideojuego.setBackground(Color.DARK_GRAY);
		panelDatosEliminarVideojuego.setBounds(0, 46, 1034, 482);
		lPanelEliminarVideojuego.add(panelDatosEliminarVideojuego);
		
		Label label_1 = new Label("Titulo del videojuego a eliminar:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(117, 99, 252, 24);
		panelDatosEliminarVideojuego.add(label_1);
		
		txtTituloVideojuegoEliminar = new JComboBox<>();
		txtTituloVideojuegoEliminar.setForeground(Color.WHITE);
		txtTituloVideojuegoEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTituloVideojuegoEliminar.setBackground(Color.DARK_GRAY);
		txtTituloVideojuegoEliminar.setBounds(388, 99, 274, 22);
		panelDatosEliminarVideojuego.add(txtTituloVideojuegoEliminar);
		
		// Agregar autocompletar a titulo eliminar videojuego
		AutoCompleteSupport.install(txtTituloVideojuegoEliminar, listaTitulos);
		
		Button btnEliminarVideojuego = new Button("Eliminar videojuego");
		btnEliminarVideojuego.setForeground(Color.WHITE);
		btnEliminarVideojuego.setFont(new Font("Dialog", Font.BOLD, 13));
		btnEliminarVideojuego.setBackground(new Color(255, 140, 0));
		btnEliminarVideojuego.setBounds(867, 427, 155, 34);
		panelDatosEliminarVideojuego.add(btnEliminarVideojuego);
		
		Button btnCancelarEliminarVideojuego = new Button("Cancelar");
		btnCancelarEliminarVideojuego.setForeground(Color.WHITE);
		btnCancelarEliminarVideojuego.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCancelarEliminarVideojuego.setBackground(new Color(255, 99, 71));
		btnCancelarEliminarVideojuego.setBounds(728, 427, 99, 34);
		panelDatosEliminarVideojuego.add(btnCancelarEliminarVideojuego);
		
		// ----------------------------------------------------------------------------- ACCIONES BOTONES -------------------------------------------------------------
		
		
		// ------------------------------------------- AGREGAR VIDEOJUEGOS --------------------------------
		
		
		// BOTON OPCION AGREGAR VIDEOJUEGOS ----- MENU PRINCIPAL 
		
		btnOpcionAgregarVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Ocultar elementos Menu Principal
				
				lPanelMenuPrincipal.setVisible(false);
				
				// Mostrar elementos Agregar Videojuego
				
				lPanelAgregarVideojuego.setVisible(true);
			}
		});
		
		
		// BOTON CANCELAR AGREGAR VIDEOJUEGOS
		
		btnCancelarAgregarVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Ocultar elementos Agregar Videojuego
				
				lPanelAgregarVideojuego.setVisible(false);
				
				//limpiar
				
				txtTituloVideojuego.setText("");
				txtAnoLanzamiento.setText("");
				txtRating.setText("");
				
				ch2Ds.setSelected(false);
				ch3Ds.setSelected(false);
				chAccion.setSelected(false);
				chArcade.setSelected(false);
				chAtari.setSelected(false);
				chAventura.setSelected(false);
				chDreamcast.setSelected(false);
				chDs.setSelected(false);
				chEstrategia.setSelected(false);
				chFamicom.setSelected(false);
				chFantasia.setSelected(false);
				chGameBoy.setSelected(false);
				chGameCube.setSelected(false);
				chGBA.setSelected(false);
				chHackAndSlash.setSelected(false);
				chHorror.setSelected(false);
				chLinux.setSelected(false);
				chMac.setSelected(false);
				chMAccion.setSelected(false);
				chMCreatividad.setSelected(false);
				chMInmersion.setSelected(false);
				chMLogros.setSelected(false);
				chMMaestria.setSelected(false);
				chMSocial.setSelected(false);
				chMultiplayer.setSelected(false);
				chMundoAbierto.setSelected(false);
				chN64.setSelected(false);
				chNES.setSelected(false);
				chPc.setSelected(false);
				chPlataforma.setSelected(false);
				chPlayStation1.setSelected(false);
				chPlayStation2.setSelected(false);
				chPlayStation3.setSelected(false);
				chPlayStation4.setSelected(false);
				chPrimeraPersona.setSelected(false);
				chPsp.setSelected(false);
				chPuzzle.setSelected(false);
				chRPG.setSelected(false);
				chSegaGenesis.setSelected(false);
				chShooter.setSelected(false);
				chSimulacion.setSelected(false);
				chSinglePlayer.setSelected(false);
				chSNES.setSelected(false);
				chSupervivencia.setSelected(false);
				chSwitch.setSelected(false);
				chTerceraPersona.setSelected(false);
				chVistaArea.setSelected(false);
				chWii.setSelected(false);
				chWiiU.setSelected(false);
				chXbox.setSelected(false);
				chXbox360.setSelected(false);
				chXboxOne.setSelected(false);
				chVistaLateral.setSelected(false);
				chDeporte.setSelected(false);
				
				txtDescripcion.setText("");
				
				// Mostrar elementos Menu Principal
				

				lPanelMenuPrincipal.setVisible(true);
				
				
			}
		});
		
		// BOTON AGREGAR VIDEOJUEGO
		
		btnAgregarVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int existeError = 0;
				
				// Titulo Videojuego
				String titulo= null;
				
				titulo =txtTituloVideojuego.getText();
				
				if (titulo.equals("")) {
					JOptionPane.showMessageDialog(lPanelAgregarVideojuego, "Debe ingresar un titulo", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
					existeError = 1;
				}
				
				// Año Lanzamiento
				int anoLanzamiento = 0;
				
				try {
					anoLanzamiento = Integer.parseInt(txtAnoLanzamiento.getText()); 
				}
				
				catch (Exception s){
					JOptionPane.showMessageDialog(lPanelAgregarVideojuego, "Debe ingresar un año de lanzamiento valido", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
					existeError = 1;
				}
				
				// Rating
				int rating = 0;
				
				try {
					 rating = Integer.parseInt(txtRating.getText()); 
				}
					
				catch (Exception s){
					JOptionPane.showMessageDialog(lPanelAgregarVideojuego, "Debe ingresar un rating valido", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
					existeError = 1;
				}
				
				//Obtener Generos
				
				ArrayList<String> generos = new ArrayList<>();
				
				if (chAccion.isSelected()==true)
					generos.add("Accion");
				
				if (chAventura.isSelected()==true)
					generos.add("Aventura");
				
				if (chRPG.isSelected()==true)
					generos.add("RPG");
				
				if	(chSimulacion.isSelected()==true)
					generos.add("Simulacion");
				
				if	(chShooter.isSelected()==true)
					generos.add("Shooter");
				
				if	(chEstrategia.isSelected()==true)
					generos.add("Estrategia");
				
				if	(chHackAndSlash.isSelected()==true)
					generos.add("Hack & Slash");
				
				if	(chPlataforma.isSelected()==true)
					generos.add("Plataforma");
				
				if	(chFantasia.isSelected()==true)
					generos.add("Fantasia");
				
				if	(chArcade.isSelected()==true)
					generos.add("Arcade");
				
				if	(chSupervivencia.isSelected()==true)
					generos.add("Supervivencia");
				
				if	(chHorror.isSelected()==true)
					generos.add("Horror");
				
				if	(chPuzzle.isSelected()==true)
					generos.add("Puzzle");
				
				if	(chMundoAbierto.isSelected()==true)
					generos.add("Mundo Abierto");
				
				if	(chDeporte.isSelected()==true)
					generos.add("Deporte");
				
				if (generos.size()==0) {
					JOptionPane.showMessageDialog(lPanelAgregarVideojuego, "Debe seleccionar al menos una categoría", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
					existeError = 1;
				}
				//Fin Obtener Categorias
				
				
				//Obtener Plataformas
				
				ArrayList<String> plataformas = new ArrayList<>();
				
				if (chPc.isSelected()==true)
					plataformas.add("PC");
				
				if (chMac.isSelected()==true)
					plataformas.add("Mac");
				
				if (chLinux.isSelected()==true)
					plataformas.add("Linux");
				
				if (chSegaGenesis.isSelected()==true)
					plataformas.add("Sega Genesis");
				
				if (chFamicom.isSelected()==true)
					plataformas.add("Famicom");
				
				if (chDreamcast.isSelected()==true)
					plataformas.add("Dreamcast");
			
				if (chPlayStation4.isSelected()==true)
					plataformas.add("Play Station 4");
				
				if (chPlayStation3.isSelected()==true)
					plataformas.add("Play Station 3");
				
				if (chPlayStation2.isSelected()==true)
					plataformas.add("Play Station 2");
				
				if (chPlayStation1.isSelected()==true)
					plataformas.add("Play Station 1");
				
				if (chPsp.isSelected()==true)
					plataformas.add("PSP");
				
				if (chXboxOne.isSelected()==true)
					plataformas.add("Xbox One");
				
				if (chXbox360.isSelected()==true)
					plataformas.add("Xbox 360");
				
				if (chXbox.isSelected()==true)
					plataformas.add("Xbox");
				
				if (chAtari.isSelected()==true)
					plataformas.add("Atari");
				
				if (chSwitch.isSelected()==true)
					plataformas.add("Switch");
				
				if (chWiiU.isSelected()==true)
					plataformas.add("Wii U");
				
				if (chWii.isSelected()==true)
					plataformas.add("Wii");
				
				if (chGameCube.isSelected()==true)
					plataformas.add("Game Cube");
				
				if (chN64.isSelected()==true)
					plataformas.add("N64");
				
				if (chSNES.isSelected()==true)
					plataformas.add("SNES");
				
				if (chDs.isSelected()==true)
					plataformas.add("Ds");
				
				if (ch2Ds.isSelected()==true)
					plataformas.add("2Ds");
				
				if (ch3Ds.isSelected()==true)
					plataformas.add("3Ds");
				
				if (chGBA.isSelected()==true)
					plataformas.add("GBA");
				
				if (chGameBoy.isSelected()==true)
					plataformas.add("Game Boy");
				
				if (chNES.isSelected()==true)
					plataformas.add("NES");
				
				if (plataformas.size()==0){
					JOptionPane.showMessageDialog(lPanelAgregarVideojuego, "Debe seleccionar al menos una plataforma", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
					existeError = 1;
				}
				
				//Fin Obtener Plataformas
				
				
				// Obtener Modos de Juegos
				
				ArrayList<String> modosDeJuego = new ArrayList<>();
				
				if (chSinglePlayer.isSelected()==true)
					modosDeJuego.add("Single Player");
				
				if (chMultiplayer.isSelected()==true)
					modosDeJuego.add("Multiplayer");
				
				if (modosDeJuego.size()==0){
					JOptionPane.showMessageDialog(lPanelAgregarVideojuego, "Debe seleccionar al menos un modo de juego", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
					existeError = 1;
				}
				
				// Fin Obtener Modos de Juegos
				
				
				// Obtener Perspectiva
				
				ArrayList<String> perspectivas = new ArrayList<>();
				
				if (chPrimeraPersona.isSelected()==true)
					perspectivas.add("1ra Persona");
				
				if (chTerceraPersona.isSelected()==true)
					perspectivas.add("3ra Persona");
				
				if (chVistaArea.isSelected()==true)
					perspectivas.add("Vista aerea");
				
				if (chVistaLateral.isSelected()==true)
					perspectivas.add("Vista lateral");
				
				if (perspectivas.size()==0){
					JOptionPane.showMessageDialog(lPanelAgregarVideojuego, "Debe seleccionar al menos una perspectiva", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
					existeError = 1;
				}
				
				//Fin Obtener Perspectiva
				
				String descripcion = txtDescripcion.getText();
				
				if (descripcion.equals("")){
					JOptionPane.showMessageDialog(lPanelAgregarVideojuego, "Debe ingresar una descripcion", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
					existeError = 1;
				}
				
				// Obtener Motivaciones
				
				ArrayList<String> motivaciones = new ArrayList<>();
				
				if (chMAccion.isSelected()==true)
					motivaciones.add("Accion");
				
				if (chMCreatividad.isSelected()==true)
					motivaciones.add("Creatividad");
				
				if (chMInmersion.isSelected()==true)
					motivaciones.add("Inmersion");
				
				if (chMLogros.isSelected()==true)
					motivaciones.add("Logros");
				
				if (chMMaestria.isSelected()==true)
					motivaciones.add("Maestria");
				
				if (chMSocial.isSelected()==true)
					motivaciones.add("Social");
				
				if (motivaciones.size()==0){
					JOptionPane.showMessageDialog(lPanelAgregarVideojuego, "Debe seleccionar al menos una motivacion", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
					existeError = 1;
				}
				
				//Pruebas de ingreso de datos
				
				/*
				
				System.out.println("->"+titulo+"<-");
				System.out.println(anoLanzamiento);
				System.out.println(rating);
				
				System.out.println(categorias.size());
				System.out.println(generos);
				
				System.out.println(plataformas.size());
				System.out.println(plataformas);
				
				System.out.println(modosDeJuego.size());
				System.out.println(modosDeJuego);
				
				System.out.println(perspectiva.size());
				System.out.println(perspectiva);
				
				System.out.println(descripcion);
				
				System.out.println(motivaciones.size());
				System.out.println(motivaciones);
				
				System.out.println("error"+existeError);
				
				*/
				if (existeError==0) {
				operaciones.agregarVideojuego(graphDb, titulo, anoLanzamiento, rating, generos, plataformas, modosDeJuego, perspectivas, descripcion, motivaciones);
				JOptionPane.showMessageDialog(lPanelAgregarVideojuego, "El juego se ha agregado con exito", "INGRESO", JOptionPane.INFORMATION_MESSAGE);
				
				//limpiar
				
				txtTituloVideojuego.setText("");
				txtAnoLanzamiento.setText("");
				txtRating.setText("");
				
				ch2Ds.setSelected(false);
				ch3Ds.setSelected(false);
				chAccion.setSelected(false);
				chArcade.setSelected(false);
				chAtari.setSelected(false);
				chAventura.setSelected(false);
				chDreamcast.setSelected(false);
				chDs.setSelected(false);
				chEstrategia.setSelected(false);
				chFamicom.setSelected(false);
				chFantasia.setSelected(false);
				chGameBoy.setSelected(false);
				chGameCube.setSelected(false);
				chGBA.setSelected(false);
				chHackAndSlash.setSelected(false);
				chHorror.setSelected(false);
				chLinux.setSelected(false);
				chMac.setSelected(false);
				chMAccion.setSelected(false);
				chMCreatividad.setSelected(false);
				chMInmersion.setSelected(false);
				chMLogros.setSelected(false);
				chMMaestria.setSelected(false);
				chMSocial.setSelected(false);
				chMultiplayer.setSelected(false);
				chMundoAbierto.setSelected(false);
				chN64.setSelected(false);
				chNES.setSelected(false);
				chPc.setSelected(false);
				chPlataforma.setSelected(false);
				chPlayStation1.setSelected(false);
				chPlayStation2.setSelected(false);
				chPlayStation3.setSelected(false);
				chPlayStation4.setSelected(false);
				chPrimeraPersona.setSelected(false);
				chPsp.setSelected(false);
				chPuzzle.setSelected(false);
				chRPG.setSelected(false);
				chSegaGenesis.setSelected(false);
				chShooter.setSelected(false);
				chSimulacion.setSelected(false);
				chSinglePlayer.setSelected(false);
				chSNES.setSelected(false);
				chSupervivencia.setSelected(false);
				chSwitch.setSelected(false);
				chTerceraPersona.setSelected(false);
				chVistaArea.setSelected(false);
				chWii.setSelected(false);
				chWiiU.setSelected(false);
				chXbox.setSelected(false);
				chXbox360.setSelected(false);
				chXboxOne.setSelected(false);
				chVistaLateral.setSelected(false);
				chDeporte.setSelected(false);
				
				txtDescripcion.setText("");
				
				
				lPanelAgregarVideojuego.setVisible(false);
				lPanelMenuPrincipal.setVisible(true);
				
				}
			}
		});
		
		//FIN BOTON AGREGAR VIDEOJUEGO
		
		
		// ------------------------------------------- AGREGAR USUARIOS--------------------------
		
		
		// BOTON OPCION AGREGAR USUARIOS ----- MENU PRINCIPAL 
		
		btnOpcionAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Ocultar elementos Menu Principal
				
				lPanelMenuPrincipal.setVisible(false);
				
				// Mostrar elementos Agregar usuarios - reiniciar variables y componentes
				
				lPanelAgregarUsuario.setVisible(true);
				lblPreguntas.setText("Que el juego tenga caos,destruccion, adrenalina, armas y/o emociones intensas:"); // pregunta: Accion
				btnAnteriorPregunta.setVisible(false);
				
				contadorPreguntas = 0;
				respPregunta1Accion = 0;
				respPregunta2Social = 0;
				respPregunta3Maestria = 0;
				respPregunta4Logros = 0;
				respPregunta5Creatividad = 0;
				respPregunta6Inmersion = 0;
				
				progresoBarraPreguntas = 0;
				barraDeProgresoPreguntas.setValue(progresoBarraPreguntas);
			}
		});
		
		// BOTON CANCELAR AGREGAR USUARIOS
		
		btnCancelarAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Mostrar elementos Menu Principal
				
				lPanelMenuPrincipal.setVisible(true);
				
				// Ocultar elementos Agregar Videojuego
				
				lPanelAgregarUsuario.setVisible(false);
				grupoOpcionImportacia.clearSelection();
				grupoOpcionGenero.clearSelection();
				
				txtVideojuegoFav1.setSelectedItem(null);
				txtVideojuegoFav2.setSelectedItem(null);
				txtVideojuegoFav3.setSelectedItem(null);
				
				txtVideojuegoDisf1.setSelectedItem(null);
				txtVideojuegoDisf2.setSelectedItem(null);
				txtVideojuegoDisf3.setSelectedItem(null);
				
			}
		});

		// BOTON SIGUIENTE PREGUNTA
		
		btnSiguientePregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int existeError = 0;
				
				//Pregunta 1 - Motivacion Accion
				
				if (contadorPreguntas == 0) {
					
					//Obtener respuesta
					
					if (rdbNadaImportante.isSelected()==true) 
						respPregunta1Accion = 20;
					
					if (rdbAlgoImportante.isSelected()==true)
						respPregunta1Accion = 40;
					
					if (rdbImportante.isSelected()==true)
						respPregunta1Accion = 60;
					
					if (rdbBastanteImportante.isSelected()==true)
						respPregunta1Accion = 80;
					
					if (rdbExtremadamenteImportante.isSelected()==true)
						respPregunta1Accion = 100;
					
					if (respPregunta1Accion == 0)
						existeError = 1;
				}
				
				//Pregunta 2 - Motivacion Social
				
				if (contadorPreguntas == 1) {
					
					//Obtener respuesta
					
					if (rdbNadaImportante.isSelected()==true) 
						respPregunta2Social = 20;
					
					if (rdbAlgoImportante.isSelected()==true)
						respPregunta2Social = 40;
					
					if (rdbImportante.isSelected()==true)
						respPregunta2Social = 60;
					
					if (rdbBastanteImportante.isSelected()==true)
						respPregunta2Social = 80;
					
					if (rdbExtremadamenteImportante.isSelected()==true)
						respPregunta2Social = 100;
					
					if (respPregunta2Social == 0)
						existeError = 1;
				}
				
				
				//Pregunta 3 - Motivacion Maestria
				
				if (contadorPreguntas == 2) {
					
					//Obtener respuesta
					
					if (rdbNadaImportante.isSelected()==true) 
						respPregunta3Maestria = 20;
					
					if (rdbAlgoImportante.isSelected()==true)
						respPregunta3Maestria = 40;
					
					if (rdbImportante.isSelected()==true)
						respPregunta3Maestria = 60;
					
					if (rdbBastanteImportante.isSelected()==true)
						respPregunta3Maestria = 80;
					
					if (rdbExtremadamenteImportante.isSelected()==true)
						respPregunta3Maestria = 100;
					
					if (respPregunta3Maestria == 0)
						existeError = 1;
				}
				
				//Pregunta 4 - Motivacion Logros
				
				if (contadorPreguntas == 3) {
					
					//Obtener respuesta
					
					if (rdbNadaImportante.isSelected()==true) 
						respPregunta4Logros = 20;
					
					if (rdbAlgoImportante.isSelected()==true)
						respPregunta4Logros = 40;
					
					if (rdbImportante.isSelected()==true)
						respPregunta4Logros = 60;
					
					if (rdbBastanteImportante.isSelected()==true)
						respPregunta4Logros = 80;
					
					if (rdbExtremadamenteImportante.isSelected()==true)
						respPregunta4Logros = 100;
					
					if (respPregunta4Logros == 0)
						existeError = 1;
				}
				
				//Pregunta 5 - Motivacion Creatividad
				
				if (contadorPreguntas == 4) {
					
					//Obtener respuesta
					
					if (rdbNadaImportante.isSelected()==true) 
						respPregunta5Creatividad = 20;
					
					if (rdbAlgoImportante.isSelected()==true)
						respPregunta5Creatividad = 40;
					
					if (rdbImportante.isSelected()==true)
						respPregunta5Creatividad = 60;
					
					if (rdbBastanteImportante.isSelected()==true)
						respPregunta5Creatividad = 80;
					
					if (rdbExtremadamenteImportante.isSelected()==true)
						respPregunta5Creatividad = 100;
					
					if (respPregunta5Creatividad == 0)
						existeError = 1;
				}
				
				//Pregunta 6 - Motivacion Creatividad
				
				if (contadorPreguntas == 5) {
					
					//Obtener respuesta
					
					if (rdbNadaImportante.isSelected()==true) 
						respPregunta6Inmersion = 20;
					
					if (rdbAlgoImportante.isSelected()==true)
						respPregunta6Inmersion = 40;
					
					if (rdbImportante.isSelected()==true)
						respPregunta6Inmersion = 60;
					
					if (rdbBastanteImportante.isSelected()==true)
						respPregunta6Inmersion = 80;
					
					if (rdbExtremadamenteImportante.isSelected()==true)
						respPregunta6Inmersion = 100;
					
					if (respPregunta6Inmersion == 0)
						existeError = 1;
				}
				
				//----
				
				
				//Verificacion de error
				
				if (existeError == 1)
					JOptionPane.showMessageDialog(lPanelAgregarUsuario, "Debe seleccionar un nivel de importancia como respuesta", "ERROR DE RESPUESTA A PREGUNTA", JOptionPane.ERROR_MESSAGE);
			
				if (existeError == 0) {
					
					// Actualiza el contador de preguntas y la barra de progreso
					
					contadorPreguntas++;
					
					if (contadorPreguntas != 6) {
						progresoBarraPreguntas = progresoBarraPreguntas + 18;
						barraDeProgresoPreguntas.setValue(progresoBarraPreguntas);
					}
					
					
					// Actualizar preguntas al usuario
					
					
					// Cambiar a pregunta 2
					
					if (contadorPreguntas == 1) {
						
						// Cambiar a la siguiente pregunta: Social
						lblPreguntas.setText("Competir, socializar, colaborar y/o relacionarse con otros jugadores:");
						
						// habilitar boton anterior en caso se haya pasado de la primera pregunta
						btnAnteriorPregunta.setVisible(true);
					}
					
					// Cambiar a pregunta 3
					
					if (contadorPreguntas == 2) {
						
						// Cambiar a la siguiente pregunta: Maestria
						lblPreguntas.setText("Que los juegos requieran habilidad, planeacion y decisiones importantes");
					}
					
					// Cambiar a pregunta 4
					
					if (contadorPreguntas == 3) {
						
						// Cambiar a la siguiente pregunta: Logros
						lblPreguntas.setText("Completar todo lo que el juego ofrece: desfios, Coleccionables, personajes, etc");
					}
					
					// Cambiar a pregunta 5
					
					if (contadorPreguntas == 4) {
						
						// Cambiar a la siguiente pregunta: Creatividad
						lblPreguntas.setText("Descubrir los limites del juego: que pasaría si..., customizar entornos, personajes");
					}
					
					// Cambiar a pregunta 6
					
					if (contadorPreguntas == 5) {
						
						// Cambiar a la siguiente pregunta: Inmersion
						lblPreguntas.setText("Ser alguien más, fundirse con el personaje, juegos con trasfondo e historia entrañable");
						btnSiguientePregunta.setLabel("Finalizar");
					}
					
					
					// Pregrunta final sin cambio solo actualizacion de progreso e inhabilitar boton siguiente pregunta
					
					if (contadorPreguntas == 6) {
						progresoBarraPreguntas = 100;
						barraDeProgresoPreguntas.setValue(progresoBarraPreguntas);
						btnSiguientePregunta.setVisible(false);
					}
					
					// Limpiar selecciones
					grupoOpcionImportacia.clearSelection();
				}	
				
				// Verificar output boton siguiente pregunta
				
				
				
				/*System.out.println("contador de preguntas "+contadorPreguntas);
				System.out.println("progreso barra " + progresoBarraPreguntas);
				System.out.println("respuesta1 Accion " + respPregunta1Accion);
				System.out.println("respuesta2 Social " + respPregunta2Social);
				System.out.println("respuesta3 Maestria " + respPregunta3Mestria);
				System.out.println("respuesta4 Logros " + respPregunta4Logros);
				System.out.println("respuesta5 Creatividad " + respPregunta5Creatividad);
				System.out.println("respuesta6 Inmersion " + respPregunta6Inmersion);
				System.out.println("");*/
				 
			}
		});
		
		// BOTON PREGUNTA ANTERIOR
		
		btnAnteriorPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Limpiar selecciones
				grupoOpcionImportacia.clearSelection();
				
				// Actualiza el contador de preguntas y el contador de la barra de progreso
				
				contadorPreguntas--;
				
				if (contadorPreguntas != 5) {
					progresoBarraPreguntas = progresoBarraPreguntas - 18;
				}
				
				// Actualizar preguntas a usuario
				
				
				// Cambiar a pregunta 1
				if (contadorPreguntas == 0) {	
					// Cambiar a la siguiente pregunta: Accion
					lblPreguntas.setText("Que el juego tenga caos,destruccion, adrenalina, armas y/o emociones intensas:");
					respPregunta1Accion = 0;
					
					// Deshabilita el boton pregunta anterior en caso de estar en la primera pregunta  
					btnAnteriorPregunta.setVisible(false);
				}
				
				// Cambiar a pregunta 2
				if (contadorPreguntas == 1) {
					
					// Cambiar a la siguiente pregunta: Social
					lblPreguntas.setText("Competir, socializar, colaborar y/o relacionarse con otros jugadores:");
					respPregunta2Social = 0;
					
					// habilitar boton anterior en caso se haya pasado de la primera pregunta
					btnAnteriorPregunta.setVisible(true);
				}
				
				// Cambiar a pregunta 3
				
				if (contadorPreguntas == 2) {
					
					// Cambiar a la siguiente pregunta: Maestria
					lblPreguntas.setText("Que los juegos requieran habilidad, planeacion y decisiones importantes");
					respPregunta3Maestria = 0;
				}
				
				// Cambiar a pregunta 4
				
				if (contadorPreguntas == 3) {
					
					// Cambiar a la siguiente pregunta: Logros
					lblPreguntas.setText("Completar todo lo que el juego ofrece: desfios, Coleccionables, personajes, etc");
					respPregunta4Logros = 0;
				}
				
				// Cambiar a pregunta 5
				
				if (contadorPreguntas == 4) {
					
					btnSiguientePregunta.setLabel("Siguiente");
					
					// Cambiar a la siguiente pregunta: Creatividad
					lblPreguntas.setText("Descubrir los limites del juego: que pasaría si..., customizar entornos, personajes");
					respPregunta5Creatividad = 0;
				}
				
				// Cambiar a pregunta 6
				if (contadorPreguntas == 5) {
					
					respPregunta6Inmersion = 0;
					
					progresoBarraPreguntas = progresoBarraPreguntas - 10;
					
					// Habilita el boton siguiente pregunta en caso estar antes de la ultima pregunta
					
					btnSiguientePregunta.setVisible(true);
					
					
				}
				
				// Actualiza la barra de progreso
				barraDeProgresoPreguntas.setValue(progresoBarraPreguntas);
			}
		});
		
		// BOTON AGREGAR USUARIO
		
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int existeError = 0;

				
				
				// Nombre
				
				String nombreDelUsuario = null;
				
				nombreDelUsuario = txtNombre.getText();
				
				if (nombreDelUsuario.equals("")==true) {
					existeError = 1;
					JOptionPane.showMessageDialog(lPanelAgregarUsuario, "Debe ingresar un nombre", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
				}
				
				// Edad
				
				int edadUsuario = 0;
				
				try {
					edadUsuario = Integer.parseInt(txtEdadUsuario.getText());
				}
				
				catch (Exception s) {
					existeError = 1;
					JOptionPane.showMessageDialog(lPanelAgregarUsuario, "Debe ingresar una edad valida", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
				}
				
				// Genero
				
				String generoUsuario = null;
				
				if (rdbMasculino.isSelected() == true)
					generoUsuario = "Masculino";
				
				if (rdbFemenino.isSelected() == true)
					generoUsuario = "Femenino";
				
				if (generoUsuario == null) {
					existeError = 1;
					JOptionPane.showMessageDialog(lPanelAgregarUsuario, "Debe seleccionar un género", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
				}
				
				// Videojuegos Favoritos
				
				String juegoFav1 = null;
				String juegoFav2 = null;
				String juegoFav3 = null;
				
				try {
				
				juegoFav1 = txtVideojuegoFav1.getSelectedItem().toString();
				juegoFav2 = txtVideojuegoFav2.getSelectedItem().toString();
				juegoFav3 = txtVideojuegoFav3.getSelectedItem().toString();
				}
				
				catch (Exception s) {
					existeError = 1;
					JOptionPane.showMessageDialog(lPanelAgregarUsuario, "Debe ingresar tres videojuegos favoritos", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
				}
				
				// Videojuegos recientemente disfrutados
				
				String juegoDis1 = null;
				String juegoDis2 = null;
				String juegoDis3 = null;
				
				try {
				juegoDis1 = txtVideojuegoDisf1.getSelectedItem().toString();
				juegoDis2 = txtVideojuegoDisf2.getSelectedItem().toString();
				juegoDis3 = txtVideojuegoDisf3.getSelectedItem().toString();
				}
				
				catch (Exception s) {
					existeError = 1;
					JOptionPane.showMessageDialog(lPanelAgregarUsuario, "Debe ingresar tres videojuegos que haya disfrutado", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
				}
				
				//Nombre de Usuario y contraseña

				String nombreUsuario = null;
				String passwordUsuario = null;
				
				nombreUsuario = txtNombreUsuario.getText();
				passwordUsuario = txtContraseña.getText();
				
				if (nombreUsuario.equals("") == true|| passwordUsuario.equals("") == true) {
					existeError = 1;
					JOptionPane.showMessageDialog(lPanelAgregarUsuario, "Debe ingresar un usuario y una contraseña", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
				}
				
				// Verificar existencia nombre usuario
				
				Node verificarExistenciaUsuario = null;
				
				try (Transaction tx = graphDb.beginTx()) {
				
				if (nombreUsuario.equals("") == false) {
				verificarExistenciaUsuario = graphDb.findNode(Denominaciones.USUARIO, "USER", nombreUsuario);
				
				
				if (verificarExistenciaUsuario != null) {
					existeError = 1;
					JOptionPane.showMessageDialog(lPanelAgregarUsuario, "El nombre de usuario no se encuentra disponible, use otro", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
				}
				
				}
				
				if (existeError == 0) {
					
					operaciones.agregarUsuario(graphDb, nombreDelUsuario, edadUsuario, generoUsuario, juegoFav1, juegoFav2, juegoFav3, juegoDis1, juegoDis2, juegoDis3,
							edadUsuario, edadUsuario, edadUsuario, edadUsuario, existeError, edadUsuario, nombreUsuario, passwordUsuario);
					
					JOptionPane.showMessageDialog(lPanelAgregarUsuario, "El usuario se ha agregado con exito", "INGRESO", JOptionPane.INFORMATION_MESSAGE);
				
					// Limpiar 
					
			
					txtNombre.setText("");
					txtNombreUsuario.setText("");
					
					txtEdadUsuario.setText("");
					txtpasswordField.setText("");
					
					grupoOpcionImportacia.clearSelection();
					grupoOpcionGenero.clearSelection();
					
					txtVideojuegoFav1.setSelectedItem(null);
					txtVideojuegoFav2.setSelectedItem(null);
					txtVideojuegoFav3.setSelectedItem(null);
					
					txtVideojuegoDisf1.setSelectedItem(null);
					txtVideojuegoDisf2.setSelectedItem(null);
					txtVideojuegoDisf3.setSelectedItem(null);
				
				}
				
				tx.success();
				}
				
				// Prueba output igresar usuario
				
				/*System.out.println("Nombre usuario "+ nombreDelUsuario);
				System.out.println("Edad "+ edadUsuario);
				System.out.println("Genero "+ generoUsuario);
				
				System.out.println("JFav1 "+ juegoFav1);
				System.out.println("JFav2 "+ juegoFav2);
				System.out.println("JFav3 "+ juegoFav3);
				
				System.out.println("JDis1 "+ juegoDis1);
				System.out.println("JDis2 "+ juegoDis2);
				System.out.println("JDis3 "+ juegoDis3);
				
				System.out.println("user " + nombreUsuario);
				System.out.println("Password "+ passwordUsuario);*/
			}
		});
		
		// Fin agregar usuario
		
		
		// ------------------------------------------- OBTENER RECOMENDACION --------------------------
		
		// BOTON OPCION OBTENER RECOMENDACION
		btnOpcionRecomendacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Ocultar elementos Menu Principal
				
				lPanelMenuPrincipal.setVisible(false);
				
				// Mostra elementos Obtener Recomendacion
				
				lPanelObtenerRecomendacion.setVisible(true);
				
				if (chAjustarPreferencias.isSelected()==false) {
					
					rdbAntiguosRecomendacion.setEnabled(false);
					rdbSemiRecientesRecomendacion.setEnabled(false);
					rdbRecientesRecomendacion.setEnabled(false);
					
					rdbNoTanPopularesRecomendacion.setEnabled(false);
					rdbPopularesRecomendacion.setEnabled(false);
					
				}
				
			}
		});
	
		// BOTON CANCELAR OBTENER RECOMENDACION
		btnCancelarRecomendacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Mostrar elementos Menu Principal
				
				lPanelMenuPrincipal.setVisible(true);
				
				// Ocultar elementos Obtener Recomendacion
				
				lPanelObtenerRecomendacion.setVisible(false);
				grupoRangoDeLanzamiento.clearSelection();
				grupoPopularidadRecomendaciones.clearSelection();
				txtUserRecomendacion.setText("");
				txtpasswordField.setText("");
				
			}
		});
		// ESTADO CHECKBOX 
		
		chAjustarPreferencias.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				if (chAjustarPreferencias.isSelected()== false) {
					
					rdbAntiguosRecomendacion.setEnabled(false);
					rdbSemiRecientesRecomendacion.setEnabled(false);
					rdbRecientesRecomendacion.setEnabled(false);
					
					rdbNoTanPopularesRecomendacion.setEnabled(false);
					rdbPopularesRecomendacion.setEnabled(false);
				}
				
				if (chAjustarPreferencias.isSelected()== true) {
					
					rdbAntiguosRecomendacion.setEnabled(true);
					rdbSemiRecientesRecomendacion.setEnabled(true);
					rdbRecientesRecomendacion.setEnabled(true);
					
					rdbNoTanPopularesRecomendacion.setEnabled(true);
					rdbPopularesRecomendacion.setEnabled(true);
				}
				
			}
		});
		
		
		// BOTON OBTENER RECOMENDACION
		btnObtenerRecomendacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int existeError = 0;
				
				// Estado ajustar preferencias
				
				int estadoAjustarPreferencias = 0;
						
					if (chAjustarPreferencias.isSelected()==true) {
						estadoAjustarPreferencias = 1;
					}
				
				// 
				
				// User y password
				
				String userRecomendacion = txtUserRecomendacion.getText();
				String passRecomendacion = txtpasswordField.getText();
				
				if (userRecomendacion.equals("") == true || passRecomendacion.equals("") == true) {
					existeError = 1;
					JOptionPane.showMessageDialog(lPanelObtenerRecomendacion, "Debe ingresar un usuario y una contraseña", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
				}
				
				// Rango de lanzamiento
				
				if (estadoAjustarPreferencias == 1) {
				
					String rangoLanzamiento = null;
				
					if (rdbAntiguosRecomendacion.isSelected()==true)
						rangoLanzamiento = "Antiguos";
				
					if (rdbSemiRecientesRecomendacion.isSelected()==true)
						rangoLanzamiento = "Semi-Recientes";
				
					if (rdbRecientesRecomendacion.isSelected()==true)
						rangoLanzamiento = "Recientes";
				
					if (rangoLanzamiento == null) {
						existeError = 1;
						JOptionPane.showMessageDialog(lPanelObtenerRecomendacion, "Debe seleccionar un rango de lanzamiento", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
				}
				
				}
				
				// Rango de popularidad
				
				if (estadoAjustarPreferencias == 1) {
					
					String popularidadRecomendaciones = null;
					
					if (rdbNoTanPopularesRecomendacion.isSelected() == true)
						popularidadRecomendaciones = "NoTanPopulares";
					
					if (rdbPopularesRecomendacion.isSelected() == true)
						popularidadRecomendaciones = "Populares";
					
					if (popularidadRecomendaciones == null){
						existeError = 1;
						JOptionPane.showMessageDialog(lPanelObtenerRecomendacion, "Debe seleccionar un rango de popularidad", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				// VALIDAR USER Y PASSWORD
				
				if (userRecomendacion.equals("") == false && passRecomendacion.equals("") == false) {
				
				try (Transaction tx = graphDb.beginTx()) {
				
				Node validarUsuario = graphDb.findNode(Denominaciones.USUARIO, "USER", userRecomendacion);
				
				if (validarUsuario == null) {
					existeError =1;
					JOptionPane.showMessageDialog(lPanelObtenerRecomendacion, "Nombre de usuario incorrecto/inexistente verifique el igreso", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					String validarPassword = null;
					
					validarPassword = validarUsuario.getProperty("PASSWORD").toString();
					
					if (passRecomendacion.equals(validarPassword) == false) {
						existeError =1;
						JOptionPane.showMessageDialog(lPanelObtenerRecomendacion, "Contraseña incorrecto/inexistente verifique el igreso", "ERROR DE INGRESO", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				tx.success();
					}
				}
				
				// FIN VALIDAR USER Y PASSWORD
				
				
				//Obtener recomendacion
				
				if (existeError == 0) {
					
				}
				
			}
		});
		
		// ------------------------------------------- ELIMINAR VIDEOJUEGO --------------------------
		
		
		// BOTON OPCION ELIMINAR VIDEOJUEGO
		btnOpcionEliminarVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Ocultar elementos Menu Principal
				
				lPanelMenuPrincipal.setVisible(false);
				
				// Mostrar elementos Eliminar videojuego
				
				lPanelEliminarVideojuego.setVisible(true);
				
			}
		});
			
		// BOTON CANCELAR ELIMINAR VIDEOJUEGO
		btnCancelarEliminarVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Mostrar elementos Menu Principal
				
				lPanelMenuPrincipal.setVisible(true);
				
				// Ocultar elementos Eliminar videojuego
				
				lPanelEliminarVideojuego.setVisible(false);
				txtTituloVideojuegoEliminar.setSelectedItem(null);
			}
		});
		
		// BOTON ELIMINAR VIDEOJUEGO
		btnEliminarVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int existeError = 0;
				String tituloVideojuegoEliminar = null;
				
				try {
				tituloVideojuegoEliminar = txtTituloVideojuegoEliminar.getSelectedItem().toString();
				}
				
				catch (Exception s) {
					existeError = 1;
					JOptionPane.showMessageDialog(lPanelEliminarVideojuego, "Debe ingresar/seleccionar un titulo", "ERROR DE ELIMINACION", JOptionPane.ERROR_MESSAGE);
				}
				
				if (existeError == 0 ) {
					operaciones.eliminarVideoJuego(graphDb, tituloVideojuegoEliminar, lPanelEliminarVideojuego);
					
					// Actualizar lista de videojuegos
					
					
					AutoCompleteSupport.install(txtTituloVideojuegoEliminar, operaciones.ListaVideojuegos(graphDb));
				}
			}
		});
	}
	
	public EventList<String> actualizarListaTitulos(GraphDatabaseService graphDb , OperacionesDb operaciones, EventList<String> listaTitulos){
		
		listaTitulos = operaciones.ListaVideojuegos(graphDb);
		
		return listaTitulos;
	}
}
