package org.dng.beer_counters.controller;

import org.dng.beer_counters.model.Nomenclature;
import org.dng.beer_counters.model.ProductionInfo;
import org.dng.beer_counters.model.TypeOfLine;
import org.dng.beer_counters.model.WorkMode;
import org.dng.beer_counters.service.NomenclatureService;
import org.dng.beer_counters.service.ProductionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public String showItemsList(Model model,
                                @RequestParam(defaultValue = "0", required = true) int pageNo
    ) {
        int pageSize = 5;
        List<ProductionInfo> items = new ArrayList<>();
        Pageable paging = PageRequest.of(pageNo-1, pageSize);
        Page<ProductionInfo> pageItems = productionInfoService.getAllWithPagination(paging);
        items = pageItems.getContent();

        model.addAttribute("listOfItems", items);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", pageItems.getTotalPages());
        model.addAttribute("totalRecords", pageItems.getTotalElements());
        return "productionInfo";
    }

    @GetMapping("productionInfo/delete")
    public String removeItem(Model model, @RequestParam(name = "id") long id) {
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
            item = productionInfoService.getById(id).orElse(null);
        } else item = new ProductionInfo();
        model.addAttribute("item", item);

        List<Nomenclature> subItemList;
        subItemList = nomenclatureService.getAll();
        model.addAttribute("subItemList", subItemList);

        List<WorkMode> subItemList2 = WorkMode.getListOfItems();

        List<TypeOfLine> subItemList3 = TypeOfLine.getListOfItems();


        model.addAttribute("subItemList", subItemList);
        model.addAttribute("subItemList2", subItemList2);
        model.addAttribute("subItemList3", subItemList3);

        return "productionInfoForm";
    }

    @PostMapping("productionInfo/add")
    public String addItem(@ModelAttribute(value = "item") ProductionInfo item) {
        productionInfoService.saveOrUpdate(item);
//        return "productionInfo";
        return "redirect:/productionInfo";
    }

    @PostMapping("productionInfo/update")
    public String updateItem(@ModelAttribute(value = "item") ProductionInfo item) {

        productionInfoService.saveOrUpdate(item);
        return "redirect:/productionInfo";
    }

}
