package com.liveamonth.liveamonth.controller.customerCenterController;

import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.*;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ETemplatePath.CUSTOMER_CENTER;

@Controller
public class CustomerCenterController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/customerCenter")
    public String customerCenter(Model model){
        model.addAttribute("customerCenterMenus",ECustomerCenterPath.values());
        return CUSTOMER_CENTER.getPath();
    }

    @RequestMapping("selectedCustomerCenterMenu")
    public String selectedCustomerCenterMenu(Model model,@RequestParam("menu") String menuName) throws Exception{
        String path = null;
        for(ECustomerCenterPath menu:ECustomerCenterPath.values()){
            if(menu.getText().equals(menuName)) path = menu.getPath();
        }
        model.addAttribute("customerCenterMenus",ECustomerCenterPath.values());
        return path;
    }
}
