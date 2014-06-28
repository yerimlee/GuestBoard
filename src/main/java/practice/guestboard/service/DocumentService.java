package practice.guestboard.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import practice.guestboard.domain.Document;

public interface DocumentService {
	
	@Transactional
	List<Document> selectAllDocument();
	
	@Transactional
	void insertDocument(Document document);
	
	@Transactional
	Document getDocument(Long id);

	@Transactional
	void updateDocument(Document document);
}
