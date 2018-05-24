package com.calewaert.proyecto2.Proyecto2;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 * Hello world!
 *
 */
public class OperacionesDb 
{
    
	// --------------------------------------------- ESTABLECER CONEXION DB  Y CREAR NODOS MOTIVACIONES -----------------------------------------------
	
	public GraphDatabaseService crearConexionDb() {
		
		File graphDbPath = new File("DB -neo4j-community-3.3.5\\data\\databases\\graph.db");
		GraphDatabaseFactory graphFactory = new GraphDatabaseFactory();
		GraphDatabaseService graphDB = graphFactory.newEmbeddedDatabase(graphDbPath);
		
		// Verificar y crear los 6 nodos motivaciones por primera vez
		
		try (Transaction tx = graphDB.beginTx()) {
		
		if (graphDB.findNodes(Denominaciones.MOTIVACION)==null) {
			System.out.println("No se ha encontrado ningun nodo motivacion");
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
	 
	 public void agregarVideojuego (GraphDatabaseService graphDb, String titulo, int anoLanzamiento, int rating, ArrayList<String> categorias[]
			 , ArrayList<String> plataformas, ArrayList<String> modosDeJuego, ArrayList<String> perspectivas, ArrayList<String> descripcion) {
		
		 try (Transaction tx = graphDb.beginTx()) {
		 
		Node videojuego = graphDb.createNode(Denominaciones.VIDEOJUEGO); 
		 videojuego.setProperty("TITULO:", titulo);
		 videojuego.setProperty("AÑO DE LANZAMIENTO:", anoLanzamiento);
		 videojuego.setProperty("RATING:", rating);
		 videojuego.setProperty("CATEGORIAS:", categorias);
		 videojuego.setProperty("PLATAFORMAS:", plataformas);
		 videojuego.setProperty("PLATAFORMAS:", plataformas);
		 videojuego.setProperty("MODOS DE JUEGO:", modosDeJuego);
		 videojuego.setProperty("PERSPECTIVAS:", perspectivas);
		 videojuego.setProperty("DESCRIPCION:", descripcion);
	 }
	
	 }
	 // ------- FIN -------
}
