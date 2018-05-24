package com.calewaert.proyecto2.Proyecto2;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.neo4j.cypher.internal.compiler.v2_3.mutation.CreateNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
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
