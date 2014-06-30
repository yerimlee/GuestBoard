package practice.guestboard.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import practice.guestboard.dao.DocumentDAO;
import practice.guestboard.domain.Document;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
    private DocumentDAO DocumentDAO;
	
	@Transactional
	public List<Document> selectAllDocument(){
		return (List<Document>) DocumentDAO.selectAllDocument();
	}
	
	@Transactional
	public void insertDocument(Document document){
		//document.setTime(new Date());
		DocumentDAO.insertDocument(document);
	}
	
	@Transactional
	public Document getDocument(Long id){
		return (Document) DocumentDAO.getDocument(id);
	}
	
	@Transactional
	public void updateDocument(Document document){
		DocumentDAO.updateDocument(document);
	}
	
	@Transactional
	public void deleteDocument(Long id){
		DocumentDAO.deleteDocument(id);
	}
}
