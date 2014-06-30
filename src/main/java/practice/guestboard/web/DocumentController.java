package practice.guestboard.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import practice.guestboard.domain.Document;
import practice.guestboard.service.DocumentService;

@Controller
@SessionAttributes("document")
public class DocumentController {

	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	private DocumentService documentService;
	
	// 방명록 글 목록
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("documents", documentService.selectAllDocument() );
		return "board";
	}
	
	// 글쓰기 폼
	@RequestMapping("/writeform")
	public void form(Model model){
		model.addAttribute("document", new Document());
	}
	
	// 게시글 등록 버튼 누르면
	@RequestMapping(value="/board", method = RequestMethod.POST)
	public String formSubmit(@Valid Document document, BindingResult result){
		if(result.hasErrors())
			return "/writeform";
		documentService.insertDocument(document);
		return "redirect:/board";
	}
	
	// 게시글 수정 폼
	@RequestMapping("/update/{id}")
	public String updateForm(@PathVariable Long id, Model model){
		model.addAttribute("document", documentService.getDocument(id));
		return "/update";
	}
	
	// 게시글 수정 등록 버튼 누르면
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateSubmit(@Valid Document document, BindingResult result, SessionStatus status){
		if(result.hasErrors())
			return "update";
		documentService.updateDocument(document);
		status.setComplete();
		return "redirect:/board";
	}
	
	// 게시글 삭제 폼
	@RequestMapping("/delete/{id}")
	public String deleteForm(@PathVariable Long id, Model model){
		model.addAttribute("document", documentService.getDocument(id));
		return "/delete";
	}
	
	// 게시글 삭제 등록 버튼 누르면
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteSubmit(@Valid Document document, BindingResult result, SessionStatus status){
		documentService.deleteDocument(document.getId());
		status.setComplete();
		return "redirect:/board";
	}
}
