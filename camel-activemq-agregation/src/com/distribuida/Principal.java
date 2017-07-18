package com.distribuida;
import org.apache.camel.spring.Main;

public class Principal {

	public static void main(String[] args) throws Exception {
		Main main = new Main( );
		main.setApplicationContextUri( "camel-conf.xml" );
		main.start( );
		
		
		Thread.sleep( 50000 );
	}

}
