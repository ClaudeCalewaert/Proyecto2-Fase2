package com.calewaert.proyecto2.Proyecto2;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;

/**
 * Hello world!
 *
 */
public class OperacionesDb 
{
    
	// --------------------------------------------- ESTABLECER CONEXION DB  Y CREAR NODOS MOTIVACIONES -----------------------------------------------
	
	public GraphDatabaseService crearConexionDb(JFrame jramePrincipal) {
		
		File graphDbPath = new File("DB -neo4j-community-3.3.5\\data\\databases\\graph.db");
		GraphDatabaseFactory graphFactory = new GraphDatabaseFactory();
		GraphDatabaseService graphDB = graphFactory.newEmbeddedDatabase(graphDbPath);
		
		JOptionPane.showMessageDialog(jramePrincipal, "Conexion con base de datos realizada con exito", "Conexion", JOptionPane.INFORMATION_MESSAGE);
		
		// Verificar y crear los 6 nodos motivaciones por primera vez
		
		
		try (Transaction tx = graphDB.beginTx()) {
		
		ResourceIterator<Node> nodosMotivacion = graphDB.findNodes(Denominaciones.MOTIVACION);
	
		if (nodosMotivacion.hasNext()==false) {
			
			JOptionPane.showMessageDialog(jramePrincipal, "No se han detectado nodos Motivacion, se han creado los nodos", "Creacion de nodos", JOptionPane.INFORMATION_MESSAGE);
			
			Node motivacion1 = graphDB.createNode(Denominaciones.MOTIVACION);
			motivacion1.setProperty("NOMBRE", "Accion");
			
			Node motivacion2 = graphDB.createNode(Denominaciones.MOTIVACION);
			motivacion2.setProperty("NOMBRE", "Social");
			
			Node motivacion3 = graphDB.createNode(Denominaciones.MOTIVACION);
			motivacion3.setProperty("NOMBRE", "Maestria");
			
			Node motivacion4 = graphDB.createNode(Denominaciones.MOTIVACION);
			motivacion4.setProperty("NOMBRE", "Logros");
			
			Node motivacion5 = graphDB.createNode(Denominaciones.MOTIVACION);
			motivacion5.setProperty("NOMBRE", "Creatividad");
			
			Node motivacion6 = graphDB.createNode(Denominaciones.MOTIVACION);
			motivacion6.setProperty("NOMBRE", "Inmersion");
			
			//Fin Verificar y crear los 6 nodos motivaciones por primera vez
			
		}
		
		tx.success();
		
		}
		
		// Fin Verificar y crear los 6 nodos motivaciones por primera vez
		
		return graphDB;
	}
	
	// --------------------------------------------- CERRAR CONEXION DB -------------------------------------------------------------
	 
	 public int cerrarConexion( final GraphDatabaseService graphDb )
	 {
	     // Registers a shutdown hook for the Neo4j instance so that it
	     // shuts down nicely when the VM exits (even if you "Ctrl-C" the
	     // running application).
	     Runtime.getRuntime().addShutdownHook( new Thread()
	     {
	         @Override
	         public void run()
	         {
	             graphDb.shutdown();
	         }
	     } );

	     return JFrame.DISPOSE_ON_CLOSE;
	    
	 }
	 
	 
	// --------------------------------------------- AGREGAR VIDEOJUEGO -------------------------------------------------------------
	 
	 public void agregarVideojuego (GraphDatabaseService graphDb, String titulo, int anoLanzamiento, int rating, ArrayList<String> generos
			 , ArrayList<String> plataformas, ArrayList<String> modosDeJuego, ArrayList<String> perspectivas, String descripcion, ArrayList<String> motivaciones) {
		
		 try (Transaction tx = graphDb.beginTx()) {
		 
		Node videojuego = graphDb.createNode(Denominaciones.VIDEOJUEGO); 
		 videojuego.setProperty("TITULO", titulo);
		 videojuego.setProperty("AÑO DE LANZAMIENTO", anoLanzamiento);
		 videojuego.setProperty("RATING", rating);
		 
		 
		 //Agregar generos
		 
		 String[] agregarGeneros = new String[generos.size()];
		 
		 for (int i=0; i < generos.size(); i++) {
			 agregarGeneros[i] = generos.get(i);
		 }
		 
		 videojuego.setProperty("GENEROS", agregarGeneros);
		 
		 
		 //Agregar plataformas
		 
		 String[] agregarPlataformas = new String[plataformas.size()];
		 
		 for (int i=0; i < plataformas.size(); i++) {
			 agregarPlataformas[i] = plataformas.get(i);
		 }
		 
		 videojuego.setProperty("PLATAFORMAS", agregarPlataformas);
		 
		 
		 //Agregar modos de juego
		 
		 String[] agregarModosDeJuego = new String[modosDeJuego.size()];
		 
		 for (int i=0; i < modosDeJuego.size(); i++) {
			 agregarModosDeJuego[i] = modosDeJuego.get(i);
		 }
		 
		 videojuego.setProperty("MODOS DE JUEGO", agregarModosDeJuego);
		 
		 
		 //Agregar perspectivas
		 
		 String[] agregarPerspectivas = new String[perspectivas.size()];
		 
		 for (int i=0; i < perspectivas.size(); i++) {
			 agregarPerspectivas[i] = perspectivas.get(i);
		 }
		 
		 videojuego.setProperty("PERSPECTIVAS", agregarPerspectivas);
		 
		 
		//Agregar Descripcion
		 videojuego.setProperty("DESCRIPCION", descripcion);
		 
		 
		 //Agregar Motivaciones
		 for (int i=0; i < motivaciones.size(); i++) {
			 
			 Relationship relacionMotivaciones = videojuego.createRelationshipTo(graphDb.findNode(Denominaciones.MOTIVACION, "NOMBRE", motivaciones.get(i)),Relaciones.POSEE);
		 }
		 
		 
		 
		 tx.success();
	 }
	
	 }
	 // ------- FIN -------
	 
	 
	 
	// --------------------------------------------- ELIMINAR VIDEOJUEGO -------------------------------------------------------------
	 
	 public void eliminarVideoJuego(GraphDatabaseService graphDb, String tituloVideojuego, JLayeredPane lPanelEliminarVideojuego) {
		
		 try (Transaction tx = graphDb.beginTx()) {
		 
		 Node videojuego = graphDb.findNode(Denominaciones.VIDEOJUEGO, "TITULO", tituloVideojuego);
		 
		 if (videojuego != null) {
			 
			 // Eliminar relaciones
			 Iterator<Relationship> relaciones = videojuego.getRelationships().iterator();
			 
			 while (relaciones.hasNext() == true) {
				 relaciones.next().delete();
			 }
			 
			 // Eliminar Videojuego
			 videojuego.delete();
			 JOptionPane.showMessageDialog(lPanelEliminarVideojuego, "El videojuego se ha eliminado con exito", "ELIMINACION", JOptionPane.INFORMATION_MESSAGE);
		 }
			 
		 
		 if (videojuego == null)
			 JOptionPane.showMessageDialog(lPanelEliminarVideojuego, "No se ha encontrado el videojuego, verifique los datos", "ELIMINACION", JOptionPane.ERROR_MESSAGE);
		 
		tx.success();
	 }
	 
	 }
	// ------- FIN -------
	 
	// --------------------------------------------- AGREGAR USUARIO -------------------------------------------------------------
	 
	 public void agregarUsuario(GraphDatabaseService graphDb, String nombre, int edad, String genero, String juegoFav1, String juegoFav2, String juegoFav3,
			 String juegoDis1, String juegoDis2, String juegoDis3, int respPregunta1Accion, int respPregunta2Social, int respPregunta3Maestria, int respPregunta4Logros,
			 int respPregunta5Creatividad, int respPregunta6Inmersion, String nombreUsuario, String passwordUsuario) {
		 
		 Node usuario = graphDb.createNode(Denominaciones.USUARIO);
		
		 // Datos usuario
		 usuario.setProperty("NOMBRE", nombre);
		 usuario.setProperty("EDAD", edad);
		 usuario.setProperty("GÉNERO", genero);
		 
		 // Datos cuenta user
		 usuario.setProperty("USER", nombreUsuario);
		 usuario.setProperty("PASSWORD", passwordUsuario);
		 
		 // Juegos favoritos y disfrutados
		 usuario.setProperty("JUEGO FAVORITO 1", juegoFav1);
		 usuario.setProperty("JUEGO FAVORITO 2", juegoFav2);
		 usuario.setProperty("JUEGO FAVORITO 3", juegoFav3);
		 
		 usuario.setProperty("JUEGO DISFRUTADO 1", juegoDis1);
		 usuario.setProperty("JUEGO DISFRUTADO 2", juegoDis2);
		 usuario.setProperty("JUEGO DISFRUTADO 3", juegoDis3);
		 
		 // Creacion de relaciones hacia motivaciones
		 
		 
		 // Motivacion Accion
		 Relationship usuarioMotivacionAccion = usuario.createRelationshipTo(graphDb.findNode(Denominaciones.MOTIVACION, "NOMBRE", "Accion"), Relaciones.AFINIDAD);
		 usuarioMotivacionAccion.setProperty("NIVEL DE AFINIDAD", respPregunta1Accion);
		 
		 // Motivacion Social
		 Relationship usuarioMotivacionSocial = usuario.createRelationshipTo(graphDb.findNode(Denominaciones.MOTIVACION, "NOMBRE", "Social"), Relaciones.AFINIDAD);
		 usuarioMotivacionSocial.setProperty("NIVEL DE AFINIDAD", respPregunta2Social);
		
		 // Motivacion Maestria
		 Relationship usuarioMotivacionMestria = usuario.createRelationshipTo(graphDb.findNode(Denominaciones.MOTIVACION, "NOMBRE", "Maestria"), Relaciones.AFINIDAD);
		 usuarioMotivacionMestria.setProperty("NIVEL DE AFINIDAD", respPregunta3Maestria);
		 
		 // Motivacion Logros
		 Relationship usuarioMotivacionLogros = usuario.createRelationshipTo(graphDb.findNode(Denominaciones.MOTIVACION, "NOMBRE", "Logros"), Relaciones.AFINIDAD);
		 usuarioMotivacionLogros.setProperty("NIVEL DE AFINIDAD", respPregunta4Logros);
		 
		 // Motivacion Creatividad
		 Relationship usuarioMotivacionCreatividad = usuario.createRelationshipTo(graphDb.findNode(Denominaciones.MOTIVACION, "NOMBRE", "Creatividad"), Relaciones.AFINIDAD);
		 usuarioMotivacionCreatividad.setProperty("NIVEL DE AFINIDAD", respPregunta5Creatividad);
		 
		 // Motivacion Inmersion
		 Relationship usuarioMotivacionInmersion = usuario.createRelationshipTo(graphDb.findNode(Denominaciones.MOTIVACION, "NOMBRE", "Maestria"), Relaciones.AFINIDAD);
		 usuarioMotivacionInmersion.setProperty("NIVEL DE AFINIDAD", respPregunta6Inmersion);
		 
		 //--- FIN
	 }
	 
	// --------------------------------------------- ELIMINAR USUARIO -------------------------------------------------------------
	 
		 public void eliminarUsuario(GraphDatabaseService graphDb, String nombreUsuario, String passwordUsuario, JLayeredPane lPanelEliminarUsuario) {
			
			 try (Transaction tx = graphDb.beginTx()) {
			 
			 Node usuario = graphDb.findNode(Denominaciones.USUARIO, "USER", nombreUsuario);
			 
			String verificacionPassword = (String) usuario.getProperty("PASSWORD");
			 
			 if (usuario != null) {
				 usuario.delete();
				 JOptionPane.showMessageDialog(lPanelEliminarUsuario, "El usuario se ha eliminado con exito", "ELIMINACION", JOptionPane.INFORMATION_MESSAGE);
			 }
				 
			 
			 if (usuario == null)
				 JOptionPane.showMessageDialog(lPanelEliminarUsuario, "No se ha encontrado el usuario, verifique los datos", "ELIMINACION", JOptionPane.ERROR_MESSAGE);
			
			 tx.success();
		 }
		 
		 }
		// ------- FIN -------
		 
		// --------------------------------------------- DEVOLVER LISTA DE VIDEOJUEGOS -------------------------------------------------------------
		 
		 public EventList<String> ListaVideojuegos(GraphDatabaseService graphDb) {
			 
			 EventList<String> eventlistaTitulos = new BasicEventList<String>();
			
			 try (Transaction tx = graphDb.beginTx()) {
				 
			 
			 
			ArrayList<String> listaTitulosExistentes = new ArrayList<>();
			 
			ResourceIterator<Node> nodosVideojuegos = graphDb.findNodes(Denominaciones.VIDEOJUEGO);
			
			while (nodosVideojuegos.hasNext() != false) {
				
			listaTitulosExistentes.add((String) nodosVideojuegos.next().getProperty("TITULO"));
				
			}	
			
			for (int i=0; i < listaTitulosExistentes.size(); i++) {
				
				eventlistaTitulos.add(listaTitulosExistentes.get(i));
				
			}
			
			 
			tx.success();
			
			 }
			 return eventlistaTitulos; 
		 }
		 
}
