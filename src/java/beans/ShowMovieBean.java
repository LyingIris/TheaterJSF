/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.theaterEJB;
import entity.Movie;
import entity.Showtime;
import entity.Theater;
import java.util.List;
import java.util.Map;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sages
 */
@Named(value = "showMovieBean")
@RequestScoped
public class ShowMovieBean {

    @EJB
    private theaterEJB theaterEJB;
    private Showtime showtime;
    private String movieID;
    private Theater theater;
    private String theaterID;
    private String theatername;

    private String playTime;
    private String genre;
    private Boolean showingDescription = false;
//    public String name;

    /**
     * Creates a new instance of ShowMovieBean
     */
    public ShowMovieBean() {
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public String showMovie() {
        FacesContext fc = FacesContext.getCurrentInstance();
        theatername = getTheaterParam(fc);
        return "MoviePage";
    }

    public String getTheaterParam(FacesContext fc) {
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("theatername");
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public String getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(String theaterID) {
        this.theaterID = theaterID;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean getShowingDescription() {
        return showingDescription;
    }

    public void setShowingDescription(Boolean showingDescription) {
        this.showingDescription = showingDescription;
    }

    public List<Showtime> getTimeList(String theaterID) {
        return theaterEJB.findShowTimes(theaterID);
    }

    public List<Movie> getMovie(String movieID) {
        return theaterEJB.findMovie(movieID);
    }

    public List<Showtime> getShowTime(String theaterID, String movieID) {
        return theaterEJB.findMovieShowTimes(theaterID, movieID);
    }

    public String showMovieDescription() {
        return "DescriptionPage";
    }
}
