package Persist;

import Database.Conexao;
import Exceptions.BusinessError;
import Models.Video;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VideoPersist {

	StringBuilder sql = new StringBuilder();
	Conexao conexao = new Conexao();

	public void inserir(Video video) throws BusinessError {
		try {
			this.sql.append(" INSERT INTO MyVideo.Videos ");
			this.sql.append(" (descricao, url, titulo) VALUES(' ");
			this.sql.append(video.getDescricao()).append(" ', ' ");
			this.sql.append(video.getUrl()).append(" ', ' ");
			this.sql.append(video.getTitulo()).append(" '); ");
			Statement stmt = conexao.getCon().createStatement();
			stmt.execute(this.sql.toString());
			stmt.close();
		} catch (SQLException sqlEx) {
			throw new BusinessError("Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage());
		} catch (Exception ex) {
			throw new BusinessError("Ocorreu um erro, contate o adiministrador do sistema");
		}
	}

	public ResultSet listar() throws BusinessError {

		try {
			this.sql.append(" SELECT id, descricao, url, titulo FROM MyVideo.Videos;");
			Statement stmt = conexao.getCon().createStatement();
			ResultSet dados = stmt.executeQuery(this.sql.toString());
			stmt.close();
			return dados;
		} catch (SQLException sqlEx) {
			throw new BusinessError("Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage());
		} catch (Exception ex) {
			throw new BusinessError("Ocorreu um erro, contate o adiministrador do sistema");
		}
	}

	public void atualizar(Video video) throws BusinessError {
		try {

			this.sql.append(" UPDATE MyVideo.Videos ");
			this.sql.append(" SET descricao='");
			this.sql.append(video.getDescricao());
			this.sql.append("', url='");
			this.sql.append(video.getUrl());
			this.sql.append("', titulo='");
			this.sql.append(video.getTitulo());
			this.sql.append("'");
			this.sql.append(" WHERE id=").append(video.getId());
			this.sql.append(";");

			Statement stmt = conexao.getCon().createStatement();
			stmt.execute(this.sql.toString());
			stmt.close();
		} catch (SQLException sqlEx) {
			throw new BusinessError("Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage());
		} catch (Exception ex) {
			throw new BusinessError("Ocorreu um erro, contate o adiministrador do sistema");
		}
	}

	public void excluir(int id) throws BusinessError {
		try {
			this.sql.append(" DELETE FROM MyVideo.Videos ");
			this.sql.append(" WHERE id=").append(id);
			this.sql.append(";");
			Statement stmt = conexao.getCon().createStatement();
			stmt.execute(this.sql.toString());
			stmt.close();
		} catch (SQLException sqlEx) {
			throw new BusinessError("Ocorreu um erro ao se comunicar com o banco de dados\n" + sqlEx.getMessage());
		} catch (Exception ex) {
			throw new BusinessError("Ocorreu um erro, contate o adiministrador do sistema");
		}
	}
}
