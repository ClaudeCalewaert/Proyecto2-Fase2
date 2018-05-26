package com.calewaert.proyecto2.Proyecto2;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;


import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

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
			 videojuego.delete();
			 JOptionPane.showMessageDialog(lPanelEliminarVideojuego, "El videojuego se ha eliminado con exito", "ELIMINACION", JOptionPane.INFORMATION_MESSAGE);
		 }
			 
		 
		 if (videojuego == null)
			 JOptionPane.showMessageDialog(lPanelEliminarVideojuego, "No se ha encontrado el videojuego, verifique los datos", "ELIMINACION", JOptionPane.ERROR_MESSAGE);
		 
		tx.success();
	 }
	 
	 }
	 
	 
}