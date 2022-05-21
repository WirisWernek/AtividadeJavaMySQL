package Controllers;

import Exceptions.BusinessException;
import Models.Video;
import Persist.VideoPersist;
public class VideoController {

	VideoPersist persiste = new VideoPersist();
	
    public void inserir(Video video) throws BusinessException{
		if(video.getTitulo().isEmpty() || video.getTitulo().isBlank()){
			throw new BusinessException("Titulo do vídeo nulo ou vazio");
		}
		if(video.getUrl().isEmpty() || video.getUrl().isBlank()){
			throw new BusinessException("URL do vídeo nulo ou vazio");
		}
		if(video.getDescricao().isEmpty() || video.getDescricao().isBlank()){
			throw new BusinessException("Descrição do vídeo nulo ou vazio");
		}
		
		try {
			persiste.inserir(video);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void listar() throws BusinessException {	
		
	}
	public void atualizar() throws BusinessException {
		
	}
	public void excluir() throws BusinessException{
		
	}
}
