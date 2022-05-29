package main;

import java.util.Scanner;

import Database.Conexao;
import Views.TagPorVideoView;
import Views.TagView;
import Views.VideoView;

public class Main {

	public static void main( String[] args ) {
		Conexao con = new Conexao();
		VideoView video = new VideoView();
		TagView tag = new TagView();
		TagPorVideoView tagPorVideo = new TagPorVideoView();
		Scanner input = new Scanner( System.in );
		int opcao;

		do {
			System.out.println( "\t-------Menu-------" );
			System.out.println( "\t1-Incluir Vídeo" );
			System.out.println( "\t2-Alterar Vídeo" );
			System.out.println( "\t3-Excluir Vídeo" );
			System.out.println( "\t4-Listar Vídeos" );
			System.out.println( "\t5-Incluir Tag" );
			System.out.println( "\t6-Alterar Tag" );
			System.out.println( "\t7-Excluir Tag" );
			System.out.println( "\t8-Listar Tag" );
			System.out.println( "\t9-Informar Tags do Vídeo" );
			System.out.println( "\t10-Buscar Vídeos por Tag" );
			System.out.println( "\t0-Sair" );
			System.out.println( "O que você deseja fazer?: " );
			opcao = input.nextInt();
			input.nextLine();

			switch ( opcao ) {
				case 1:
					video.inserir();
					break;
				case 2:
					video.atualizar();
					break;
				case 3:
					video.excluir();
					break;
				case 4:
					video.listar();
					break;
				case 5:
					tag.inserir();
					break;
				case 6:
					tag.atualizar();
					break;
				case 7:
					tag.excluir();
					break;
				case 8:
					tag.listar();
					break;
				case 9:
					tagPorVideo.inserir();
					break;
				case 10:
					tagPorVideo.buscar();
					break;
				case 0:
					System.out.println( "Até a próxima!!" );
					break;
				default:
					System.out.println( "Opção inválida!!" );
					break;
			}
		} while( opcao != 0 );
	}
}
