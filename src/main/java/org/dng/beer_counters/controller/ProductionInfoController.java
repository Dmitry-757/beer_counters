package org.dng.beer_counters.controller;

import org.dng.beer_counters.model.Nomenclature;
import org.dng.beer_counters.model.ProductionInfo;
import org.dng.beer_counters.model.WorkMode;
import org.dng.beer_counters.service.NomenclatureService;
import org.dng.beer_counters.service.ProductionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class ProductionInfoController {
    private final ProductionInfoService productionInfoService;
    private final NomenclatureService nomenclatureService;

    @Autowired
    public ProductionInfoController(ProductionInfoService productionInfoService, NomenclatureService nomenclatureService) {
        this.productionInfoService = productionInfoService;
        this.nomenclatureService = nomenclatureService;
    }

    @GetMapping("/start")
    public String getHelloPage() {
        return "start";
    }

    @GetMapping("/productionInfo")
    public String showStudentsList(Model model) {
        model.addAttribute("listOfItems", productionInfoService.getAll());
        return "productionInfo";
    }

    @GetMapping("productionInfo/delete")
    public String removeStudent(Model model, @RequestParam(name = "id") long id) {
        if (id > 0) {
            productionInfoService.delete(id);
        }
        model.addAttribute("listOfStudents", productionInfoService.getAll());
        return "productionInfo";
    }

    @GetMapping("productionInfo/addEditItem")
    public String editForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        //model.addAttribute("id", id);
        ProductionInfo item;
        if (id != null) {
            item = productionInfoService.getById(id).get();
        } else item = new ProductionInfo();
        model.addAttribute("item", item);

        List<Nomenclature> subItemList;
        subItemList = nomenclatureService.getAll();
        model.addAttribute("subItemList", subItemList);

        List<WorkMode> subItemList2 = new LinkedList<>();
        subItemList2.add(WorkMode.PRODUCTION);
        subItemList2.add(WorkMode.STOPPING);
        subItemList2.add(WorkMode.WASHING);

        model.addAttribute("subItemList", subItemList);
        model.addAttribute("subItemList2", subItemList2);

        return "productionInfoForm";
    }

    @PostMapping("productionInfo/add")
    public String addStudent(@ModelAttribute(value = "item") ProductionInfo item) {
        productionInfoService.saveOrUpdate(item);
//        return "productionInfo";
        return "redirect:/productionInfo";
    }

    @PostMapping("productionInfo/update")
    public String updateStudent(@ModelAttribute(value = "item") ProductionInfo item) {

        productionInfoService.saveOrUpdate(item);
        return "redirect:/productionInfo";
    }

}
