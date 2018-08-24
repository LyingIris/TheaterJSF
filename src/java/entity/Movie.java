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
@Table(name = "MOVIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m")
    , @NamedQuery(name = "Movie.findByMovieid", query = "SELECT m FROM Movie m WHERE m.movieid = :movieid")
    , @NamedQuery(name = "Movie.findByMovietitle", query = "SELECT m FROM Movie m WHERE m.movietitle = :movietitle")
    , @NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m WHERE m.genre = :genre")
    , @NamedQuery(name = "Movie.findByPlaytime", query = "SELECT m FROM Movie m WHERE m.playtime = :playtime")
    , @NamedQuery(name = "Movie.findByPicurl", query = "SELECT m FROM Movie m WHERE m.picurl = :picurl")})
public class Movie implements Serializable {

    @Size(max = 2000)
    @Column(name = "DESCRIPTION")
    private String description;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "MOVIEID")
    private String movieid;
    @Size(max = 50)
    @Column(name = "MOVIETITLE")
    private String movietitle;
    @Size(max = 250)
    @Column(name = "GENRE")
    private String genre;
    @Size(max = 20)
    @Column(name = "PLAYTIME")
    private String playtime;
    @Size(max = 1000)
    @Column(name = "PICURL")
    private String picurl;

    public Movie() {
    }

    public Movie(String movieid) {
        this.movieid = movieid;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlaytime() {
        return playtime;
    }

    public void setPlaytime(String playtime) {
        this.playtime = playtime;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieid != null ? movieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movie[ movieid=" + movieid + " ]";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
