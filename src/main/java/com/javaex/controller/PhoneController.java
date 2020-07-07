package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	/*
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam(value="company", required = false, defaultValue = "0000") String company)
	{
		System.out.println("/phone.write()");
		System.out.println(name + ", " + hp + ", " + company);
		
		PersonVo vo = new PersonVo(name, hp, company);
		return "";
	}
	*/

	// 리스트
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("list");
		
		PhoneDao dao = new PhoneDao();
		List<PersonVo> pList = dao.getPersonList();
		System.out.println(pList.toString());
		
		model.addAttribute("pList", pList);
		
		return "list";
	}
	
	// 등록 폼	
	@RequestMapping(value="/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String writeFrom() {
		System.out.println("writeForm");
		
		return "writeForm";
	}
	
	// 등록
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(@ModelAttribute PersonVo personVo){
		System.out.println("write");
		
		System.out.println(personVo.toString());
		
		PhoneDao dao = new PhoneDao();
		dao.personInsert(personVo);
		
		return "redirect:/phone/list";
	}
	
	// 수정 폼
	@RequestMapping(value="/updateForm/{pId}", method=RequestMethod.GET)
	public String updateForm(@PathVariable("pId") int pId, Model model) {
		System.out.println("updateForm");

		PhoneDao dao = new PhoneDao();
		PersonVo vo = dao.getPerson(pId);
		
		model.addAttribute("vo", vo);
		
		return "updateForm";
	}
	
	// 수정
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@ModelAttribute PersonVo personVo){
		System.out.println("update");

		PhoneDao dao = new PhoneDao();
		dao.personUpdate(personVo);

		return "redirect:/phone/list";
	}
	
	// 삭제
	@RequestMapping(value="/delete/{pId}", method=RequestMethod.GET)
	public String delete(@PathVariable("pId") int pId){
		System.out.println("delete");

		PhoneDao dao = new PhoneDao();
		dao.personDelete(pId);

		return "redirect:/phone/list";
	}
}
