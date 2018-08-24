/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.theaterEJB;
import entity.Theater;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author sages
 */
@Named(value = "mainPageBean")
@RequestScoped
public class MainPageBean {
    @EJB
    private theaterEJB theaterEJB;
    
    public MainPageBean() {
    }
    
    public List<Theater> getZipcodeList(){
        return theaterEJB.findDistinctZipcode();
    }
    
}
