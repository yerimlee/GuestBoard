// DAO(Data Access Object) 계층 : 데이터 저장 및 조회

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
