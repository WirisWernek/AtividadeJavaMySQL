package Controllers;

import java.util.List;

import Exceptions.BusinessError;
import Exceptions.BusinessException;
import Models.Video;
import Persist.VideoPersist;
import Utils.ObjectUtils;

public class VideoController {

	VideoPersist persiste = new VideoPersist();

	public void inserir( Video video ) throws BusinessException {
		if( ObjectUtils.isNullOrEmpty( video.getTitulo() ) ) {
			throw new BusinessException( "Titulo do vídeo não foi informado" );
		}
		if( ObjectUtils.isNullOrEmpty( video.getUrl() ) ) {
			throw new BusinessException( "URL do vídeo não foi informado" );
		}
		if( ObjectUtils.isNullOrEmpty( video.getDescricao() ) ) {
			throw new BusinessException( "Descrição do vídeo não foi informada" );
		}

		try {
			persiste.inserir( video );
		} catch ( BusinessError e ) {
			System.out.println( e.getMessage() );
		}
	}

	public List<Video> listar() throws BusinessException {
		List mapVideo = null;
		try {
			mapVideo = ObjectUtils.MapVideo( persiste.listar() );
		} catch ( BusinessError e ) {
			System.out.println( e.getMessage() );
		}
		return mapVideo;
	}

	public void atualizar( Video video ) throws BusinessException {
		if( ObjectUtils.isNullOrEmpty( video.getId() ) ) {
			throw new BusinessException( "Id do vídeo não foi informado" );
		}
		if( ObjectUtils.isNullOrEmpty( video.getTitulo() ) ) {
			throw new BusinessException( "Titulo do vídeo não foi informado" );
		}
		if( ObjectUtils.isNullOrEmpty( video.getUrl() ) ) {
			throw new BusinessException( "URL do vídeo não foi informada" );
		}
		if( ObjectUtils.isNullOrEmpty( video.getDescricao() ) ) {
			throw new BusinessException( "Descrição do vídeo não foi informada" );
		}
		try {
			persiste.atualizar( video );
		} catch ( BusinessError ex ) {
			System.out.println( ex.getMessage() );
		}
	}

	public void excluir( int id ) throws BusinessException {
		if( ObjectUtils.isNullOrEmpty( id ) ) {
			throw new BusinessException( "Id do vídeo não foi informado" );
		}
		try {
			persiste.excluir( id );
		} catch ( BusinessError ex ) {
			System.out.println( ex.getMessage() );
		}
	}
}
