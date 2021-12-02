/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.dao;

import java.util.List;
import kas.model.Kas;

/**
 *
 * @author Azka Pratama
 */
public interface KasDAO {
    List<Kas> get();
    Kas getSinggle(int id);
    boolean save (Kas kas); 
    boolean update(Kas kas);
    boolean delete(int id);
}
