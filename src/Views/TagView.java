package Views;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import Controllers.TagController;
import Exceptions.BusinessException;
import Models.Tag;

public class TagView {

	Tag tag = new Tag();
	TagController controller = new TagController();
	Scanner input = new Scanner( System.in );

	public void inserir() {
		System.out.println( "----CADASTRANDO NOVA TAG----" );
		System.out.println( "Insira a descrição da Tag: " );
		tag.setDescricao( input.nextLine() );
		try {
			controller.inserir( tag );
		} catch ( BusinessException e ) {
			System.out.println( e.getMessage() );
		}
	}

	public void listar() {

		System.out.println( "----LISTANDO TAGS----" );
		try {
			List<Tag> listTags = controller.listar();
			if( !Objects.isNull( listTags ) ) {
				for( Tag entidade : listTags ) {
					System.out.println( "Id: " + entidade.getId() );
					System.out.println( "Descrição: " + entidade.getDescricao() );
					System.out.println( "------------------------------" );
				}
			} else {
				System.out.println( "Nenhuma Tag encontrada para ser listada" );
			}
		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		}

	}

	public void atualizar() {
		System.out.println( "----ATUALIZANDO TAG----" );
		try {
			List<Tag> listTags = controller.listar();
			if( !Objects.isNull( listTags ) ) {
				for( Tag entidade : listTags ) {
					System.out.println( "Id: " + entidade.getId() + " - Descrição: " + entidade.getDescricao() );
				}

				System.out.println( "Insira o ID da Tag a ser atualizada: " );
				tag.setId( input.nextInt() );
				input.nextLine();
				System.out.println( "Insira a descrição da tag: " );
				tag.setDescricao( input.nextLine() );
				controller.atualizar( tag );
			} else {
				System.out.println( "Nenhuma Tag encontrada para ser atualizada" );
			}
		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		}
	}

	public void excluir() {
		System.out.println( "----EXCLUINDO TAG----" );
		try {
			List<Tag> listTags = controller.listar();
			if( !Objects.isNull( listTags ) ) {
				for( Tag entidade : listTags ) {
					System.out.println( "Id: " + entidade.getId() + " - Descrição: " + entidade.getDescricao() );
				}

				System.out.println( "Insira o ID da Tag a ser excluida: " );
				tag.setId( input.nextInt() );
				input.nextLine();
				controller.excluir( tag.getId() );
			} else {
				System.out.println( "Nenhuma Tag encontrada para ser excluida" );
			}
		} catch ( BusinessException ex ) {
			System.out.println( ex.getMessage() );
		}
	}
}
