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

		try {
			if( ObjectUtils.isNullOrEmpty( video.getUrl() ) ) {
				throw new BusinessException( "URL do vídeo não foi informado" );
			}
			if( ObjectUtils.isNullOrEmpty( video.getDescricao() ) ) {
				throw new BusinessException( "Descrição do vídeo não foi informada" );
			}
			if( ObjectUtils.isNullOrEmpty( video.getDia() ) ) {
				throw new BusinessException( "Dia de postagem do vídeo não foi informado" );
			}
			if( ObjectUtils.isNullOrEmpty( video.getMes() ) ) {
				throw new BusinessException( "Mês de postagem do vídeo não foi informado" );
			}
			if( ObjectUtils.isNullOrEmpty( video.getAno() ) ) {
				throw new BusinessException( "Ano de postagem do vídeo não foi informado" );
			}
			persiste.inserir( video );
		} catch ( BusinessError e ) {
			System.out.println( e.getMessage() );
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}

	public List<Video> listar() throws BusinessException {
		List mapVideo = null;
		try {
			mapVideo = ObjectUtils.MapVideo( persiste.listar() );
		} catch ( BusinessError e ) {
			System.out.println( e.getMessage() );
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
		return mapVideo;
	}

	public void atualizar( Video video ) throws BusinessException {
		try {
			if( ObjectUtils.isNullOrEmpty( video.getId() ) ) {
				throw new BusinessException( "Id do vídeo não foi informado" );
			}
			if( ObjectUtils.isNullOrEmpty( video.getUrl() ) ) {
				throw new BusinessException( "URL do vídeo não foi informada" );
			}
			if( ObjectUtils.isNullOrEmpty( video.getDescricao() ) ) {
				throw new BusinessException( "Descrição do vídeo não foi informada" );
			}
			if( ObjectUtils.isNullOrEmpty( video.getDia() ) ) {
				throw new BusinessException( "Dia de postagem do vídeo não foi informado" );
			}
			if( ObjectUtils.isNullOrEmpty( video.getMes() ) ) {
				throw new BusinessException( "Mês de postagem do vídeo não foi informado" );
			}
			if( ObjectUtils.isNullOrEmpty( video.getAno() ) ) {
				throw new BusinessException( "Ano de postagem do vídeo não foi informado" );
			}
			persiste.atualizar( video );
		} catch ( BusinessError e ) {
			System.out.println( e.getMessage() );
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}

	public void excluir( int id ) throws BusinessException {
		try {
			if( ObjectUtils.isNullOrEmpty( id ) ) {
				throw new BusinessException( "Id do vídeo não foi informado" );
			}
			persiste.excluir( id );
		} catch ( BusinessError e ) {
			System.out.println( e.getMessage() );
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}
}
