/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.controller;

import javax.servlet.http.HttpServletRequest;
import kas.dao.KasDAO;
import kas.dao.KasDAOProses;
import kas.model.Kas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Azka Pratama
 */
@Controller
public class KasController {
    KasDAO kasDAO = null;
    public KasController() {
        kasDAO = new KasDAOProses();
    }
    @RequestMapping(value="/kas-form")
    public ModelAndView index(HttpServletRequest req, HttpServletRequest res){
        String action = req.getParameter("action");
        ModelAndView modelandview;
        if(action == null){
            action = "ADD";
        }
        switch(action.toUpperCase()){
            case "EDIT":
                modelandview = editKas(req, res);
                break;
            case "DELETE":
                modelandview = deleteKas(req, res);
                break;
            default:
                modelandview = addKas(req, res);
                break;
        }
        return modelandview;
    }
    
    @RequestMapping(value = "/kas-form", method = RequestMethod.POST)
        public ModelAndView save(@ModelAttribute("kas") Kas ks){
           ModelAndView modelandview = new ModelAndView("redirect:/kas-form.html");
           if(ks.getId() != 0){
                    if(kasDAO.update(ks)){
                            return new ModelAndView("redirect:/home.html");
                    } else {
                            modelandview.addObject("message", "error save");
                    }
           } else {
                     if(kasDAO.save(ks)){
                            return new ModelAndView("redirect:/home.html");
                    } else {
                            modelandview.addObject("message", "error save");
                    }
           }
           return modelandview;
     }

    private ModelAndView editKas(HttpServletRequest req, HttpServletRequest res) {
       String id = req.getParameter("id");
       Kas kh = kasDAO.getSinggle(Integer.parseInt(id));
       ModelAndView modelandview = new ModelAndView();
       modelandview.addObject("kas", kh);
       return modelandview;
    }

    private ModelAndView deleteKas(HttpServletRequest req, HttpServletRequest res) {
        String id = req.getParameter("id");
        if(kasDAO.delete(Integer.parseInt(id))){
            return new ModelAndView("redirect:/home.html");
        } else {
            req.setAttribute("message", "gagal delete");
            return addKas(req, res);
        }
    }

    private ModelAndView addKas(HttpServletRequest req, HttpServletRequest res) {
        if(req.getParameter("message") != null){
            ModelAndView modelandview = new ModelAndView();
            modelandview.addObject("message", req.getParameter("message"));
            return modelandview;
        }
        return new ModelAndView();
    }
}
