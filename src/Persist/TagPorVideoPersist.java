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
			sql.append( " SELECT DISTINCT assoc_tag_video.idassoc_tag_video, video.idVideo,video.Descricao,video.Link,video.DiaPostagem,video.MesPostagem, " );
			sql.append( " video.AnoPostagem,tag.idTag, tag.TextoTag " );
			sql.append( " from video Inner join assoc_tag_video " );
			sql.append( " on video.idVideo=assoc_tag_video.idVideo inner join tag " );
			sql.append( " on tag.idTag=assoc_tag_video.idTag " );
			sql.append( " WHERE tag.TextoTag in " );

			// TODO: Resolver problema de conversão para array
			sql.append( listTags.toString() );
			sql.append( ";" );
			Statement stmt = conexao.getCon().createStatement();
			return stmt.executeQuery( sql.toString() );
		} catch ( SQLException sqlEx ) {
			throw new BusinessError( "Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage() );
		} catch ( Exception ex ) {
			throw new BusinessError( "Ocorreu um erro, contate o adiministrador do sistema" );
		}
	}

}
