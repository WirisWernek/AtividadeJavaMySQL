package Persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.Conexao;
import Exceptions.BusinessError;
import Models.Tag;

public class TagPersist {

	Conexao conexao = new Conexao();

	public void inserir( Tag tag ) throws BusinessError {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append( " INSERT INTO MyVideo.Tags " );
			sql.append( " (descricao) VALUES('" );
			sql.append( tag.getDescricao() );
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
			sql.append( " SELECT id, descricao FROM MyVideo.Tags;" );
			Statement stmt = conexao.getCon().createStatement();
			ResultSet dados = stmt.executeQuery( sql.toString() );
			return dados;
		} catch ( SQLException sqlEx ) {
			throw new BusinessError( "Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage() );
		} catch ( Exception ex ) {
			throw new BusinessError( "Ocorreu um erro, contate o adiministrador do sistema" );
		}
	}

	public void atualizar( Tag tag ) throws BusinessError {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append( " UPDATE MyVideo.Tags " );
			sql.append( " SET descricao='" );
			sql.append( tag.getDescricao() );
			sql.append( "' WHERE id=" );
			sql.append( tag.getId() );
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
			sql.append( " DELETE FROM MyVideo.Tags " );
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
