package Utils;

import Models.Video;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectUtils {

	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof String && ((String) obj).trim().isEmpty()) {
			return true;
		} else if (obj instanceof List && ((List) obj).isEmpty()) {
			return true;
		}
		return false;
	}

	public static List MapVideo(ResultSet dados) {
		List<Video> lisVideos;
		lisVideos = new ArrayList<>();
		try {
			while (dados.next()) {
				Video video = new Video(dados.getInt("id"), dados.getString("url"), dados.getString("titulo"), dados.getString("descricao"));
				lisVideos.add(video);
			}
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro ao mapear os dados!");
		}
		return lisVideos;
	}

	public static List MapTag(ResultSet dados) {
		return null;
	}

	public static List MapTagPorVideo(ResultSet dados) {
		return null;
	}
}
