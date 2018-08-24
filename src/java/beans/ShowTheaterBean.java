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
@Named(value = "showTheaterBean")
@RequestScoped
public class ShowTheaterBean {
    @EJB
    private theaterEJB theaterEJB;
    private Theater theater;
    private String zipcode;
    /**
     * Creates a new instance of ShowTheaterBean
     */
    public ShowTheaterBean() {
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    
    public String showTheater(String zipcode){
        this.zipcode = zipcode;
        return "TheaterPage.xhtml";
    }
    
    public List<Theater> getTheaterList(){
        if(zipcode !=null){
            return theaterEJB.findTheaters(zipcode);
        }else{
            return null;
        }
    }
    
}
