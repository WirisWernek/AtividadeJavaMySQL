package Views;

import java.util.InputMismatchException;
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
		try {
			System.out.println( "----CADASTRANDO NOVO VIDEO----" );
			System.out.println( "Insira a URL do vídeo: " );
			video.setUrl( input.nextLine() );
			System.out.println( "Insira a descrição do vídeo: " );
			video.setDescricao( input.nextLine() );
			System.out.println( "Insira o dia da publicação do vídeo: " );
			video.setDia( input.nextInt() );
			System.out.println( "Insira o mês da publicação do vídeo: " );
			video.setMes( input.nextInt() );
			System.out.println( "Insira o ano da publicação do vídeo: " );
			video.setAno( input.nextInt() );
			controller.inserir( video );
		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		} catch ( InputMismatchException i ) {
			System.out.println( "Tipo de dado não esperado" );
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}

	public void listar() {
		try {
			List<Video> listVideos = controller.listar();

			System.out.println( "----LISTANDO VÍDEOS----" );
			if( !Objects.isNull( listVideos ) ) {
				for( Video entidade : listVideos ) {
					System.out.println( "Id: " + entidade.getId() );
					System.out.println( "Descrição: " + entidade.getDescricao() );
					System.out.println( "Url: " + entidade.getUrl() );
					System.out.println( "Data de Publicação: " + entidade.getDate() );
					System.out.println( "------------------------------" );
				}
			} else {
				System.out.println( "Nenhum Video encontrado para ser listado" );
			}
		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		} catch ( InputMismatchException i ) {
			System.out.println( "Tipo de dado não esperado" );
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}

	public void atualizar() {
		try {
			List<Video> listVideos = controller.listar();

			System.out.println( "----ATUALIZANDO VÍDEO----" );
			if( !Objects.isNull( listVideos ) ) {
				for( Video entidade : listVideos ) {
					System.out.println( "Id: " + entidade.getId() + " - Título: " + entidade.getDescricao() + " - Url: " + entidade.getUrl() );
				}

				System.out.println( "Insira o ID do vídeo a ser atualizado: " );
				video.setId( input.nextInt() );
				input.nextLine();
				System.out.println( "Insira a URL do vídeo: " );
				video.setUrl( input.nextLine() );
				System.out.println( "Insira a descrição do vídeo: " );
				video.setDescricao( input.nextLine() );
				System.out.println( "Insira o dia da publicação do vídeo: " );
				video.setDia( input.nextInt() );
				System.out.println( "Insira o mês da publicação do vídeo: " );
				video.setMes( input.nextInt() );
				System.out.println( "Insira o ano da publicação do vídeo: " );
				video.setAno( input.nextInt() );

				controller.atualizar( video );
			} else {
				System.out.println( "Nenhum Video encontrado para ser atualizado" );
			}
		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		} catch ( InputMismatchException i ) {
			System.out.println( "Tipo de dado não esperado" );
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}

	public void excluir() {
		try {
			List<Video> listVideos = controller.listar();

			System.out.println( "----EXCLUINDO VÍDEO----" );
			if( !Objects.isNull( listVideos ) ) {
				for( Video entidade : listVideos ) {
					System.out.println( "Id: " + entidade.getId() + " - Título: " + entidade.getDescricao() + " - Url: " + entidade.getUrl() );
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
		} catch ( InputMismatchException i ) {
			System.out.println( "Tipo de dado não esperado" );
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}
}
