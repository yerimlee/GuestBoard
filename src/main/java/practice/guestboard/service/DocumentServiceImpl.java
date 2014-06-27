package practice.guestboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.guestboard.dao.DocumentDAO;
import practice.guestboard.domain.Document;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
    private DocumentDAO DocumentDAO;
	
	public List<Document> SelectAllDocument(){
		return (List<Document>) DocumentDAO.SelectAllDocument();
	};
}
