package org.dng.beer_counters.controller;

import org.dng.beer_counters.model.Nomenclature;
import org.dng.beer_counters.service.NomenclatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NomenclatureController {
    private final NomenclatureService service;
    private final String prefixUrl = "/nomenclature";

    @Autowired
    public NomenclatureController(NomenclatureService service) {
        this.service = service;
    }

    @GetMapping(prefixUrl)
    public String showAll(Model model){
        model.addAttribute("listOfItems", service.getAll());
        return "nomenclature";
    }

    @GetMapping(prefixUrl+"/addEditItem")
    public String editForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        Nomenclature item;
        if (id != null) {
            item = service.getById(id).get();
        } else item = new Nomenclature();
        model.addAttribute("item", item);

        return "nomenclatureForm";
    }

    @PostMapping(prefixUrl+"/add")
    public String addItem(@ModelAttribute(value = "item") Nomenclature item) {
        service.saveOrUpdate(item);
        return "redirect:"+prefixUrl;
    }

    @PostMapping(prefixUrl+"/update")
    public String updateItem(@ModelAttribute(value = "item") Nomenclature item) {

        service.saveOrUpdate(item);
        return "redirect:"+prefixUrl;
    }

    @GetMapping(prefixUrl+"/delete")
    public String removeItem(Model model, @RequestParam(name = "id") long id) {
        if (id > 0) {
            service.delete(id);
        }
        model.addAttribute("listOfItems", service.getAll());
        return "nomenclature";
    }

}
