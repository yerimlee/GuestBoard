// Service 계층 : 비즈니스 로직 수행, 트랜잭션 경계 설정, 접근 권한 확인 등

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
	
	@Transactional
	void deleteDocument(Long id);
}
