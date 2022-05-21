package main;

import Database.Conexao;
import Views.TagPorVideoView;
import Views.TagView;
import Views.VideoView;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Conexao con = new Conexao();
		VideoView video = new VideoView();
		TagView tag = new TagView();
		TagPorVideoView tagPorVideo = new TagPorVideoView();
		Scanner input = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("\t-------Menu-------");
			System.out.println("\t1-Incluir Vídeo");
			System.out.println("\t2-Alterar Vídeo");
			System.out.println("\t3-Excluir Vídeo");
			System.out.println("\t4-Listar Vídeos");
			System.out.println("\t5-Informar Tags do Vídeo");
			System.out.println("\t6-Buscar Vídeo por Tag");
			System.out.println("\t0-Sair");
			System.out.println("O que você deseja fazer?: ");
			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
				case 1 -> {
					video.inserir();
				}
				case 2 -> {
				}
				case 3 -> {
				}
				case 4 -> {
				}
				case 5 -> {
				}
				case 6 -> {
				}
				case 0 -> System.out.println("Até a próxima!!");
				default -> System.out.println("Opção inválida!!");
			}
		} while (opcao != 0);
	}
}
