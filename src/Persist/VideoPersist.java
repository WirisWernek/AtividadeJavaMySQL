package Persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.Conexao;
import Exceptions.BusinessError;
import Models.Video;

public class VideoPersist {

	Conexao conexao = new Conexao();

	public void inserir( Video video ) throws BusinessError {
		StringBuilder sql = new StringBuilder();
		try {

			sql.append( " INSERT INTO prog4_ativ1.video " );
			sql.append( " (Descricao, Link, DiaPostagem, MesPostagem, AnoPostagem) VALUES('" );
			sql.append( video.getDescricao() );
			sql.append( "', '" );
			sql.append( video.getUrl() );
			sql.append( "', '" );
			sql.append( video.getDia() );
			sql.append( "', '" );
			sql.append( video.getMes() );
			sql.append( "', '" );
			sql.append( video.getAno() );
			sql.append( "');" );

			Statement stmt = conexao.getCon().createStatement();
			stmt.execute( sql.toString() );
			stmt.close();
		} catch ( SQLException sqlEx ) {
			throw new BusinessError( "Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage() );
		} catch ( Exception ex ) {
			throw new BusinessError( "Ocorreu um erro, contate o adiministrador do sistema" );
		}
	}

	public ResultSet listar() throws BusinessError {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append( " SELECT idVideo, Descricao, Link, DiaPostagem, MesPostagem, AnoPostagem" );
			sql.append( " FROM prog4_ativ1.video;" );
			Statement stmt = conexao.getCon().createStatement();
			ResultSet dados = stmt.executeQuery( sql.toString() );
			return dados;
		} catch ( SQLException sqlEx ) {
			throw new BusinessError( "Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage() );
		} catch ( Exception ex ) {
			throw new BusinessError( "Ocorreu um erro, contate o adiministrador do sistema" );
		}
	}

	public void atualizar( Video video ) throws BusinessError {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append( " UPDATE prog4_ativ1.video " );
			sql.append( " SET Descricao='" );
			sql.append( video.getDescricao() );
			sql.append( "', Link='" );
			sql.append( video.getUrl() );
			sql.append( "', DiaPostagem='" );
			sql.append( video.getDia() );
			sql.append( "', MesPostagem='" );
			sql.append( video.getMes() );
			sql.append( "', AnoPostagem='" );
			sql.append( video.getAno() );
			sql.append( "'" );
			sql.append( " WHERE idVideo=" ).append( video.getId() );
			sql.append( ";" );

			Statement stmt = conexao.getCon().createStatement();
			stmt.execute( sql.toString() );
		} catch ( SQLException sqlEx ) {
			throw new BusinessError( "Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage() );
		} catch ( Exception ex ) {
			throw new BusinessError( "Ocorreu um erro, contate o adiministrador do sistema" );
		}
	}

	public void excluir( int id ) throws BusinessError {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append( " DELETE FROM prog4_ativ1.video " );
			sql.append( " WHERE idVideo=" ).append( id );
			sql.append( ";" );
			Statement stmt = conexao.getCon().createStatement();
			stmt.execute( sql.toString() );
		} catch ( SQLException sqlEx ) {
			throw new BusinessError( "Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage() );
		} catch ( Exception ex ) {
			throw new BusinessError( "Ocorreu um erro, contate o adiministrador do sistema" );
		}
	}
}
