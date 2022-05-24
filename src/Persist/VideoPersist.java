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
			sql.append( " INSERT INTO MyVideo.Videos " );
			sql.append( " (descricao, url, titulo) VALUES('" );
			sql.append( video.getDescricao() );
			sql.append( "', '" );
			sql.append( video.getUrl() );
			sql.append( "', '" );
			sql.append( video.getTitulo() );
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
			sql.append( " SELECT id, descricao, url, titulo FROM MyVideo.Videos;" );
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
			sql.append( " UPDATE MyVideo.Videos " );
			sql.append( " SET descricao='" );
			sql.append( video.getDescricao() );
			sql.append( "', url='" );
			sql.append( video.getUrl() );
			sql.append( "', titulo='" );
			sql.append( video.getTitulo() );
			sql.append( "'" );
			sql.append( " WHERE id=" ).append( video.getId() );
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
			sql.append( " DELETE FROM MyVideo.Videos " );
			sql.append( " WHERE id=" ).append( id );
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
