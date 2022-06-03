package Persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Database.Conexao;
import Exceptions.BusinessError;
import Models.TagPorVideo;

public class TagPorVideoPersist {

	Conexao conexao = new Conexao();

	public void inserir( TagPorVideo tagPorVideo ) throws BusinessError {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append( " INSERT INTO prog4_ativ1.assoc_tag_video " );
			sql.append( " (idVideo, idTag) VALUES(" );
			sql.append( tagPorVideo.getIdVideo() );
			sql.append( ", " );
			sql.append( tagPorVideo.getIdTag() );
			sql.append( ");" );

			Statement stmt = conexao.getCon().createStatement();
			stmt.execute( sql.toString() );
		} catch ( SQLException sqlEx ) {
			throw new BusinessError( "Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage() );
		} catch ( Exception ex ) {
			throw new BusinessError( "Ocorreu um erro, contate o adiministrador do sistema" );
		}
	}

	public ResultSet buscar( List<String> listTags ) throws BusinessError {
		StringBuilder sql = new StringBuilder();
		try {

			sql.append( " SELECT DISTINCT video.idVideo, video.Descricao, video.Link, video.DiaPostagem, video.MesPostagem ," );
			sql.append( " video.AnoPostagem  FROM prog4_ativ1.video video INNER JOIN prog4_ativ1.assoc_tag_video associativa " );
			sql.append( " on associativa.idVideo  = video.idVideo " );
			sql.append( " INNER JOIN prog4_ativ1.tag tag on tag.idTag = associativa.idTag " );
			sql.append( " WHERE tag.TextoTag in ( " );

			for( String texto : listTags ) {
				sql.append( "'" );
				sql.append( texto );
				sql.append( "'," );
			}
			sql.append( "'');" );

			Statement stmt = conexao.getCon().createStatement();
			return stmt.executeQuery( sql.toString() );
		} catch ( SQLException sqlEx ) {
			throw new BusinessError( "Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage() );
		} catch ( Exception ex ) {
			throw new BusinessError( "Ocorreu um erro, contate o adiministrador do sistema" );
		}
	}

	public ResultSet listar() throws BusinessError {
		StringBuilder sql = new StringBuilder();
		try {

			sql.append( " SELECT DISTINCT video.idVideo, video.Descricao, video.Link, video.DiaPostagem, video.MesPostagem ," );
			sql.append( " video.AnoPostagem  FROM prog4_ativ1.video video INNER JOIN prog4_ativ1.assoc_tag_video associativa " );
			sql.append( " on associativa.idVideo  = video.idVideo " );
			sql.append( " INNER JOIN prog4_ativ1.tag tag on tag.idTag = associativa.idTag;" );

			Statement stmt = conexao.getCon().createStatement();
			return stmt.executeQuery( sql.toString() );
		} catch ( SQLException sqlEx ) {
			throw new BusinessError( "Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage() );
		} catch ( Exception ex ) {
			throw new BusinessError( "Ocorreu um erro, contate o adiministrador do sistema" );
		}
	}

	public ResultSet getTagsPorVideo( int id ) throws BusinessError {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append( " SELECT tag.idTag, tag.TextoTag FROM prog4_ativ1.tag tag " );
			sql.append( " inner join prog4_ativ1.assoc_tag_video associativa on associativa.idTag = tag.idTag " );
			sql.append( "WHERE associativa.idVideo =" );
			sql.append( id );
			sql.append( ";" );
			Statement stmt = conexao.getCon().createStatement();
			ResultSet dados = stmt.executeQuery( sql.toString() );
			return dados;
		} catch ( SQLException sqlEx ) {
			throw new BusinessError( "Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage() );
		} catch ( Exception ex ) {
			throw new BusinessError( "Ocorreu um erro, contate o adiministrador do sistema" );
		}
	}

	public void excluir( TagPorVideo tagPorVideo ) throws BusinessError {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append( " DELETE FROM prog4_ativ1.assoc_tag_video " );
			sql.append( " WHERE idVideo =" );
			sql.append( tagPorVideo.getIdVideo() );
			sql.append( " AND idTag =" );
			sql.append( tagPorVideo.getIdTag() );
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
