package practice.guestboard.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import practice.guestboard.dao.DocumentDAOImpl;
import practice.guestboard.domain.Document;
import practice.guestboard.service.DocumentService;

@Controller
public class DocumentController {

	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	private DocumentService documentService;
	
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("documents", documentService.SelectAllDocument() );
		return "board_contents";
	}
}
