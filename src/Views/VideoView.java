package Views;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import Controllers.VideoController;
import Exceptions.BusinessException;
import Models.Video;

public class VideoView {

	Video video = new Video();
	VideoController controller = new VideoController();
	Scanner input = new Scanner( System.in );

	public void inserir() {
		System.out.println( "----CADASTRANDO NOVO VIDEO----" );
		System.out.println( "Insira a URL do vídeo: " );
		video.setUrl( input.nextLine() );
		System.out.println( "Insira o título do vídeo: " );
		video.setTitulo( input.nextLine() );
		System.out.println( "Insira a descrição do vídeo: " );
		video.setDescricao( input.nextLine() );
		System.out.println( video.getUrl() + video.getTitulo() + video.getDescricao() );
		try {
			controller.inserir( video );
		} catch ( BusinessException e ) {
			System.out.println( e.getMessage() );
		}
	}

	public void listar() {
		System.out.println( "----LISTANDO VÍDEOS----" );
		try {
			List<Video> listVideos = controller.listar();
			if( !Objects.isNull( listVideos ) ) {
				for( Video entidade : listVideos ) {
					System.out.println( "Id: " + entidade.getId() );
					System.out.println( "Título: " + entidade.getTitulo() );
					System.out.println( "Descrição: " + entidade.getDescricao() );
					System.out.println( "Url: " + entidade.getUrl() );
					System.out.println( "------------------------------" );
				}
			} else {
				System.out.println( "Nenhum Video encontrado para ser listado" );
			}
		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		}
	}

	public void atualizar() {
		System.out.println( "----ATUALIZANDO VÍDEO----" );
		try {
			List<Video> listVideos = controller.listar();
			if( !Objects.isNull( listVideos ) ) {
				for( Video entidade : listVideos ) {
					System.out.println( "Id: " + entidade.getId() + " - Título: " + entidade.getTitulo() + " - Url: " + entidade.getUrl() );
				}

				System.out.println( "Insira o ID do vídeo a ser atualizado: " );
				video.setId( input.nextInt() );
				input.nextLine();
				System.out.println( "Insira a URL do vídeo: " );
				video.setUrl( input.nextLine() );
				System.out.println( "Insira o título do vídeo: " );
				video.setTitulo( input.nextLine() );
				System.out.println( "Insira a descrição do vídeo: " );
				video.setDescricao( input.nextLine() );
				controller.atualizar( video );
			} else {
				System.out.println( "Nenhum Video encontrado para ser atualizado" );
			}
		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		}
	}

	public void excluir() {
		System.out.println( "----EXCLUINDO VÍDEO----" );
		try {
			List<Video> listVideos = controller.listar();
			if( !Objects.isNull( listVideos ) ) {
				for( Video entidade : listVideos ) {
					System.out.println( "Id: " + entidade.getId() + " - Título: " + entidade.getTitulo() + " - Url: " + entidade.getUrl() );
				}

				System.out.println( "Insira o ID do vídeo a ser excluido: " );
				video.setId( input.nextInt() );
				input.nextLine();
				controller.excluir( video.getId() );
			} else {
				System.out.println( "Nenhum Video encontrado para ser excluido" );
			}
		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		}
	}
}
