package Persist;

import Database.Conexao;
import Exceptions.BusinessError;
import Models.Video;
import java.sql.SQLException;
import java.sql.Statement;

public class VideoPersist {

	StringBuilder sql = new StringBuilder();
	Conexao conexao = new Conexao();

	public void inserir(Video video) throws Exception{
		try {
			this.sql.append(" INSERT INTO MyVideo.Videos ");
			this.sql.append(" (descricao, url, titulo) VALUES('");
			this.sql.append(video.getDescricao()).append("', '");
			this.sql.append(video.getUrl()).append("', '");
			this.sql.append(video.getTitulo()).append("');");
			Statement stmt = conexao.getCon().createStatement();
			stmt.execute(this.sql.toString());
		} catch (SQLException sqlEx) {
			throw new BusinessError("Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage());
		} catch (Exception ex) {
			throw new BusinessError("Ocorreu um erro, contate o adiministrador do sistema");
		}
	}

	public void listar() {

	}

	public void atualizar() {

	}

	public void excluir() {

	}
}
