package Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Tag;
import Models.Video;

public class ObjectUtils {

	public static boolean isNullOrEmpty( Object obj ) {
		if( obj == null ) {
			return true;
		} else if( obj instanceof String && ( ( String ) obj ).trim().isEmpty() ) {
			return true;
		} else if( obj instanceof List && ( ( List ) obj ).isEmpty() ) {
			return true;
		}
		return false;
	}

	public static List MapVideo( ResultSet dados ) {
		List<Video> lisVideos;
		lisVideos = new ArrayList<>();
		try {
			while( dados.next() ) {
				Video video = new Video( dados.getInt( "idVideo" ), dados.getString( "Link" ), dados.getString( "Descricao" ), dados.getInt( "DiaPostagem" ), dados.getInt( "MesPostagem" ), dados.getInt( "AnoPostagem" ) );
				lisVideos.add( video );
			}
		} catch ( SQLException ex ) {
			System.out.println( "Ocorreu um erro ao mapear os dados!\n" + ex );
		}
		return lisVideos;
	}

	public static List MapTag( ResultSet dados ) {
		List<Tag> lisTags;
		lisTags = new ArrayList<>();
		try {
			while( dados.next() ) {
				Tag tag = new Tag( dados.getInt( "idTag" ), dados.getString( "TextoTag" ) );
				lisTags.add( tag );
			}
		} catch ( SQLException ex ) {
			System.out.println( "Ocorreu um erro ao mapear os dados!\n" + ex );
		}
		return lisTags;
	}

	public static List MapTagPorVideo( ResultSet dados ) {
		return null;
	}
}
