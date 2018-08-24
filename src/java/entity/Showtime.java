/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sages
 */
@Entity
@Table(name = "SHOWTIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Showtime.findAll", query = "SELECT s FROM Showtime s")
    , @NamedQuery(name = "Showtime.findByTimeid", query = "SELECT s FROM Showtime s WHERE s.timeid = :timeid")
    , @NamedQuery(name = "Showtime.findByTheaterid", query = "SELECT s FROM Showtime s WHERE s.theaterid = :theaterid")
    , @NamedQuery(name = "Showtime.findByMovieid", query = "SELECT s FROM Showtime s WHERE s.movieid = :movieid")
    , @NamedQuery(name = "Showtime.findByShowtime", query = "SELECT s FROM Showtime s WHERE s.showtime = :showtime")
    , @NamedQuery(name = "Showtime.findDistinctMovie", query = "SELECT DISTINCT s.movieid FROM Showtime s WHERE s.theaterid = :theaterid")
    , @NamedQuery(name = "Showtime.findMovieShowTime", query = "SELECT s FROM Showtime s WHERE s.movieid = :movieid AND s.theaterid = :theaterid")})

public class Showtime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "TIMEID")
    private String timeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "THEATERID")
    private String theaterid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "MOVIEID")
    private String movieid;
    @Size(max = 25)
    @Column(name = "SHOWTIME")
    private String showtime;

    public Showtime() {
    }

    public Showtime(String timeid) {
        this.timeid = timeid;
    }

    public Showtime(String timeid, String theaterid, String movieid) {
        this.timeid = timeid;
        this.theaterid = theaterid;
        this.movieid = movieid;
    }

    public String getTimeid() {
        return timeid;
    }

    public void setTimeid(String timeid) {
        this.timeid = timeid;
    }

    public String getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(String theaterid) {
        this.theaterid = theaterid;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeid != null ? timeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Showtime)) {
            return false;
        }
        Showtime other = (Showtime) object;
        if ((this.timeid == null && other.timeid != null) || (this.timeid != null && !this.timeid.equals(other.timeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Showtime[ timeid=" + timeid + " ]";
    }
    
}
