package Controllers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Exceptions.BusinessError;
import Exceptions.BusinessException;
import Models.Tag;
import Models.TagPorVideo;
import Models.Video;
import Persist.TagPorVideoPersist;
import Utils.ObjectUtils;

public class TagPorVideoController {

	TagPorVideoPersist persiste = new TagPorVideoPersist();

	public void inserir( TagPorVideo tagPorVideo ) throws BusinessException {
		if( ObjectUtils.isNullOrEmpty( tagPorVideo.getIdTag() ) ) {
			throw new BusinessException( "A tag não foi informada" );
		}
		if( ObjectUtils.isNullOrEmpty( tagPorVideo.getIdVideo() ) ) {
			throw new BusinessException( "O video não foi informado" );
		}

		try {
			persiste.inserir( tagPorVideo );
		} catch ( BusinessError e ) {
			System.out.println( e.getMessage() );
		}
	}

	public List<Video> buscar( List<String> listTags ) throws BusinessException {
		List<Video> mapVideos = new ArrayList<Video>();

		if( ObjectUtils.isNullOrEmpty( listTags ) ) {
			throw new BusinessException( "Nenhuma Tag foi informada" );
		}
		try {
			ResultSet dados = persiste.buscar( listTags );
			mapVideos = ObjectUtils.MapVideo( dados );

			for( Video item : mapVideos ) {
				item.setTags( ObjectUtils.MapTag( persiste.getTagsPorVideo( item.getId() ) ) );
			}

		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}

		return mapVideos;
	}

	public List<Video> listar() throws BusinessException {
		List<Video> mapVideos = new ArrayList<Video>();
		try {
			ResultSet dados = persiste.listar();
			mapVideos = ObjectUtils.MapVideo( dados );

			for( Video item : mapVideos ) {
				item.setTags( ObjectUtils.MapTag( persiste.getTagsPorVideo( item.getId() ) ) );
			}

		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}

		return mapVideos;
	}

	public void excluir( TagPorVideo tagPorVideo ) throws BusinessException {

		try {
			persiste.excluir( tagPorVideo );

		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}

	public List<Tag> getTagsDoVideo( int id ) {
		try {
			if( !ObjectUtils.isNullOrEmpty( id ) ) {
				return ObjectUtils.MapTag( persiste.getTagsPorVideo( id ) );
			}
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
		return null;
	}

}
