/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.theaterEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author sages
 */
@Named(value = "purchaseTicketBean")
@Dependent
public class purchaseTicketBean {

    @EJB
    private theaterEJB theaterEJB;
    private int creditnumber;

    /**
     * Creates a new instance of purchaseTicketBean
     */
    public purchaseTicketBean() {
    }

    public String showPurchase() {
        return "PurchasePage";
    }

    public int getCreditnumber() {
        return creditnumber;
    }

    public void setCreditnumber(int creditnumber) {
        this.creditnumber = creditnumber;
    }

    public String purchaseTicket() {

        int length = String.valueOf(creditnumber).length();
        if (length != 16) {
            return "ErrorPage";
        } else {
            return "SuccessPage";
        }
    }

}
