package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection con;

	public Conexao( String url, String usuario, String senha ) {
		this.EstabeleceConexao( url, usuario, senha );
	}

	public Conexao() {
		String url = "jdbc:mysql://localhost:3306/prog4_ativ1?" + "useTimeZone=true&serverTimeZone=UTC&autoReconnect=true&useSSL=false";
		String usuario = "root";
		String senha = "itix.123";
		this.EstabeleceConexao( url, usuario, senha );
	}

	public Connection getCon() {
		return this.con;
	}

	private void EstabeleceConexao( String url, String usuario, String senha ) {
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			this.con = DriverManager.getConnection( url, usuario, senha );

			if( this.con == null ) {
				System.out.println( "Conexo com o BD não estabelecida" );
			}
		} catch ( ClassNotFoundException e ) {
			System.out.println( "Erro ao carregar o driver" );
		} catch ( SQLException e ) {
			System.out.println( "Erro ao realizar a conexo" );
		} catch ( Exception e ) {
			System.out.println( "Ocorreu um erro, contate o adiministrador do sistema" );
		}
	}
}
