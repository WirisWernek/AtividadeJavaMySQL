package Controllers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Exceptions.BusinessError;
import Exceptions.BusinessException;
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
		List<Video> videos = new ArrayList<Video>();

		if( ObjectUtils.isNullOrEmpty( listTags ) ) {
			throw new BusinessException( "Nenhuma Tag foi informada" );
		}
		try {
			ResultSet dados = persiste.buscar( listTags );
			List<TagPorVideo> mapTagPorVideo = ObjectUtils.MapTagPorVideo( dados );

			for( TagPorVideo item : mapTagPorVideo ) {
				if( !this.existeNaLista( item, videos ) ) {
					videos.add( item.getVideo() );
				}
			}

		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}

		return videos;
	}

	private boolean existeNaLista( TagPorVideo dado, List<Video> videos ) {
		for( Video video : videos ) {
			if( video.getId() == dado.getIdVideo() ) {
				video.getTags().add( dado.getTag() );
				return true;
			} else {
				return false;
			}
		}
		return true;
	}
}
