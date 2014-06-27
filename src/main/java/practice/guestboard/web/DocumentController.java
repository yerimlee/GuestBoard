package practice.guestboard.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import practice.guestboard.dao.DocumentDAOImpl;
import practice.guestboard.domain.Document;
import practice.guestboard.service.DocumentService;

@Controller
public class DocumentController {

	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	private DocumentService documentService;
	
	// 방명록 글 목록
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("documents", documentService.selectAllDocument() );
		//return "board_contents";
		return "board";
	}
	
	// 글쓰기 폼
	@RequestMapping("/writeform")
	public void form(Model model){
		model.addAttribute("document", new Document());
	}
	
	// 게시글 등록 버튼 누르면
	@RequestMapping(value="/board", method = RequestMethod.POST)
	public String formSubmit(final Document document, final BindingResult result){
		documentService.insertDocument(document);
		return "redirect:/board";
	}
}
