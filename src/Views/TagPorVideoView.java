package Views;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import Controllers.TagController;
import Controllers.TagPorVideoController;
import Controllers.VideoController;
import Exceptions.BusinessException;
import Models.Tag;
import Models.TagPorVideo;
import Models.Video;

public class TagPorVideoView {

	TagPorVideo tagPorVideo = new TagPorVideo();
	TagPorVideoController controller = new TagPorVideoController();
	TagController tagController = new TagController();
	VideoController videoController = new VideoController();
	Scanner input = new Scanner( System.in );

	public void inserir() {
		try {
			List<Tag> listTags = tagController.listar();
			List<Video> listVideos = videoController.listar();

			if( !Objects.isNull( listVideos ) ) {
				for( Video entidade : listVideos ) {
					System.out.println( "Id: " + entidade.getId() + " - Título: " + entidade.getDescricao() + " - Url: " + entidade.getUrl() );
				}
				System.out.println( "Insira o ID do Video a ser tageado: " );
				tagPorVideo.setIdVideo( input.nextInt() );
			} else {
				System.out.println( "Nenhum Video encontrado para ser tageado" );
			}

			if( !Objects.isNull( listTags ) ) {
				for( Tag entidade : listTags ) {
					System.out.println( "Id: " + entidade.getId() + " - Descrição: " + entidade.getDescricao() );
				}

				System.out.println( "Insira o ID da Tag a ser utilizada: " );
				tagPorVideo.setIdTag( input.nextInt() );

			} else {
				System.out.println( "Nenhuma Tag encontrada para ser utilizado" );
			}

			controller.inserir( tagPorVideo );

		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		}
	}

	public void listar() {
		try {
			List<Video> videos = this.controller.listar();

			System.out.println( "----VÍDEOS ENCONTRADOS----" );

			for( Video video : videos ) {
				System.out.println( "Id: " + video.getId() );
				System.out.println( "Descrição: " + video.getDescricao() );
				System.out.println( "Url: " + video.getUrl() );
				System.out.println( "Data de Publicação: " + video.getDate() );
				System.out.println( "Tags" );
				for( Tag tag : video.getTags() ) {
					System.out.println( "Id: " + tag.getId() );
					System.out.println( "Descrição: " + tag.getDescricao() );
					System.out.println( "------------------------------" );
				}
				System.out.println( "------------------------------" );
			}
		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		}
	}

	public void excluir() {
		try {
			List<Video> listVideos = videoController.listar();
			List<Tag> listTags = new ArrayList<Tag>();

			if( !Objects.isNull( listVideos ) ) {
				for( Video entidade : listVideos ) {
					System.out.println( "Id: " + entidade.getId() + " - Título: " + entidade.getDescricao() + " - Url: " + entidade.getUrl() );
				}
				System.out.println( "Insira o ID do Video : " );
				tagPorVideo.setIdVideo( input.nextInt() );
			} else {
				System.out.println( "Nenhum Video encontrado para ter uma tag removida" );
			}

			listTags = controller.getTagsDoVideo( tagPorVideo.getIdVideo() );

			if( !Objects.isNull( listTags ) ) {
				for( Tag entidade : listTags ) {
					System.out.println( "Id: " + entidade.getId() + " - Descrição: " + entidade.getDescricao() );
				}

				System.out.println( "Insira o ID da Tag a ser removida: " );
				tagPorVideo.setIdTag( input.nextInt() );

			} else {
				System.out.println( "Nenhuma Tag encontrada para ser removida" );
			}

			controller.excluir( tagPorVideo );

		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		}
	}

	public void buscar() {
		List<String> listTags = new ArrayList<String>();
		Boolean continua = true;
		try {
			do {
				System.out.println( "Insira a tag a ser bucada ou digite 0 para sair: " );
				String tag = input.nextLine();

				if( tag.trim().equals( "0" ) ) {
					continua = false;
				} else {
					listTags.add( tag );
				}

			} while( continua );
			System.out.println( listTags );

			List<Video> videos = this.controller.buscar( listTags );

			System.out.println( "----VÍDEOS ENCONTRADOS----" );

			for( Video video : videos ) {
				System.out.println( "Id: " + video.getId() );
				System.out.println( "Descrição: " + video.getDescricao() );
				System.out.println( "Url: " + video.getUrl() );
				System.out.println( "Data de Publicação: " + video.getDate() );
				System.out.println( "Tags" );
				for( Tag tag : video.getTags() ) {
					System.out.println( "Id: " + tag.getId() );
					System.out.println( "Descrição: " + tag.getDescricao() );
					System.out.println( "------------------------------" );
				}
				System.out.println( "------------------------------" );
			}
		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		}

	}

}
