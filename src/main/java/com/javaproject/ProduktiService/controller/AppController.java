package com.javaproject.ProduktiService.controller;


import com.javaproject.ProduktiService.model.Produkti;
import com.javaproject.ProduktiService.service.ProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

  private final ProduktService produktservice;

  @Autowired
  public AppController(ProduktService produktservice) {
    this.produktservice = produktservice;
  }

  @GetMapping
  public String viewHomePage(Model model) {
    List<Produkti> produktList = produktservice.listAll();
    model.addAttribute("produktList", produktList);

    return "index";
  }

  @RequestMapping("/new")
  public String showNewProduct(Model model) {
    Produkti produkti = new Produkti();
    model.addAttribute("produkti", produkti);

    return "new_produkt";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveProduct(@ModelAttribute("produkti") Produkti produkti) {
    produktservice.save(produkti);

    return "redirect:/";

  }

  @RequestMapping("/app/edit/{id}")
  public ModelAndView showEditProduct(@PathVariable(name = "id") Integer id) {
    ModelAndView mav = new ModelAndView("edit_product");

    Produkti produkti = produktservice.get(id);
    mav.addObject("produkti", produkti);
    return mav;
  }

  @RequestMapping("/app/delete/{id}")
  public String deleteProduct(@PathVariable(name = "id") Integer id) {
    produktservice.delete(id);

    return "redirect:/";
  }


}
