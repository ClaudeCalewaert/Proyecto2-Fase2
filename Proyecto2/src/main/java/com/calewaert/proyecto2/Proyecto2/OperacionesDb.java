package com.calewaert.proyecto2.Proyecto2;

import java.io.File;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 * Hello world!
 *
 */
public class OperacionesDb 
{
    
	// --------------------------------------------- ESTABLECER CONEXION DB -------------------------------------------------------------
	
	public GraphDatabaseService crearConexionDb() {
		
		File graphDbPath = new File("Proyecto Fase 2\\Proyecto2\\DB -neo4j-community-3.3.5\\data\\databases\\graph.db");
		GraphDatabaseFactory graphFactory = new GraphDatabaseFactory();
		GraphDatabaseService graphDB = graphFactory.newEmbeddedDatabase(graphDbPath);
		
		return graphDB;
	}
	
	// --------------------------------------------- CERRAR CONEXION DB -------------------------------------------------------------
	 
	 public static void registerShutdownHook( final GraphDatabaseService graphDb )
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
	 }
	 
	 // ------- FIN -------
}