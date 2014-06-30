package practice.guestboard.dao;

import java.util.List;

import practice.guestboard.domain.Document;


public interface DocumentDAO {
	List<Document> selectAllDocument();
	Document getDocument(Long id);
	void insertDocument(Document document);
	void updateDocument(Document document);
	void deleteDocument(Long id);
}
