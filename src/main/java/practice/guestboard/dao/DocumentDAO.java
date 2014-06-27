package practice.guestboard.dao;

import java.util.List;
import practice.guestboard.domain.Document;

public interface DocumentDAO {
	List<Document> SelectAllDocument();
}
