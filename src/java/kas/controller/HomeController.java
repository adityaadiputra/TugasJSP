/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kas.dao.KasDAO;
import kas.dao.KasDAOProses;
import kas.model.DatabaseConfig;
import kas.model.Kas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Azka Pratama
 */
@Controller
public class HomeController {
    KasDAO kasDAO = null;
    public HomeController(){
        kasDAO = new KasDAOProses();
    }
    
    @RequestMapping(value="/home")
    public ModelAndView home(HttpServletRequest req, HttpServletResponse res) throws SQLException{
//        Connection connection = null;
//        connection = DatabaseConfig.openConnection();
//        if(connection != null){
//            ModelAndView modelandview = new ModelAndView();
//            modelandview.addObject("msg", "Koneksi Berhasil");
//            return modelandview;
//        } else {
//            ModelAndView modelandview = new ModelAndView();
//            modelandview.addObject("msg", "Koneksi Gagal");
//            return modelandview;
//        }
            return listKas(req, res);
    }

    private ModelAndView listKas(HttpServletRequest req, HttpServletResponse res) {
       List <Kas> list = kasDAO.get();
       ModelAndView modelandview = new ModelAndView();
       modelandview.addObject("listKas", list);
       return modelandview;
    }
}
