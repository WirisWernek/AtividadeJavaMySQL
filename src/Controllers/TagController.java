package Controllers;

import java.util.List;

import Exceptions.BusinessError;
import Exceptions.BusinessException;
import Models.Tag;
import Persist.TagPersist;
import Utils.ObjectUtils;

public class TagController {

	TagPersist persiste = new TagPersist();

	public void inserir( Tag tag ) throws BusinessException {
		if( ObjectUtils.isNullOrEmpty( tag.getDescricao() ) ) {
			throw new BusinessException( "Descrição da tag não informada" );
		}
		try {
			persiste.inserir( tag );
		} catch ( BusinessError e ) {
			System.out.println( e.getMessage() );
		}
	}

	public List<Tag> listar() throws BusinessException {
		List mapTag = null;
		try {
			mapTag = ObjectUtils.MapTag( persiste.listar() );
		} catch ( BusinessError e ) {
			System.out.println( e.getMessage() );
		}
		return mapTag;
	}

	public void atualizar( Tag tag ) throws BusinessException {
		if( ObjectUtils.isNullOrEmpty( tag.getId() ) ) {
			throw new BusinessException( "Id da tag não foi informado" );
		}
		if( ObjectUtils.isNullOrEmpty( tag.getDescricao() ) ) {
			throw new BusinessException( "Descrição da tag não foi informada" );
		}
		try {
			persiste.atualizar( tag );
		} catch ( BusinessError ex ) {
			System.out.println( ex.getMessage() );
		}
	}

	public void excluir( int id ) throws BusinessException {
		if( ObjectUtils.isNullOrEmpty( id ) ) {
			throw new BusinessException( "Id da Tag não informado" );
		}
		try {
			persiste.excluir( id );
		} catch ( BusinessError ex ) {
			System.out.println( ex.getMessage() );
		}
	}
}
