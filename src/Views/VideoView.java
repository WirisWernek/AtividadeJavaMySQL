package Views;

import Controllers.VideoController;
import Exceptions.BusinessException;
import Models.Video;
import Utils.ObjectUtils;
import java.util.Scanner;

public class VideoView {

	Video video = new Video();
	VideoController controller = new VideoController();
	Scanner input = new Scanner(System.in);

	public void inserir() {
		System.out.println("----Cadastrando novo vídeo----");
		System.out.println("Insira a URL do vídeo: ");
		video.setUrl(input.nextLine());
		System.out.println("Insira o título do vídeo: ");
		video.setTitulo(input.nextLine());
		System.out.println("Insira a descrição do vídeo: ");
		video.setDescricao(input.nextLine());
		try {
			controller.inserir(video);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listar() {
		
	}

	public void atualizar() {

	}

	public void excluir() {

	}
}
