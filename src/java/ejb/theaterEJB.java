/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Movie;
import entity.Showtime;
import entity.Theater;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sages
 */
@Stateless
public class theaterEJB {

    @PersistenceContext(unitName = "TheaterAppPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Theater> findAllTheaters() {
        return em.createNamedQuery("Theater.findAll", Theater.class).getResultList(); 
    }
    
    public List<Theater> findDistinctZipcode(){
        return em.createNamedQuery("Theater.distinctZipcode", Theater.class).getResultList();
    } 
    
    public List<Theater> findTheaters(String zipcode){
        return em.createNamedQuery("Theater.findByZipcode", Theater.class).setParameter("zipcode", zipcode).getResultList();
    }
    

    public List<Showtime> findShowTimes(String theaterID) {
        return em.createNamedQuery("Showtime.findDistinctMovie", Showtime.class).setParameter("theaterid", theaterID).getResultList();
    }
    
    public List<Movie> findMovie(String movieID){
        return em.createNamedQuery("Movie.findByMovieid", Movie.class).setParameter("movieid", movieID).getResultList();
    }
    public List<Showtime> findMovieShowTimes(String theaterID, String movieID){
        return em.createNamedQuery("Showtime.findMovieShowTime", Showtime.class).setParameter("theaterid", theaterID).setParameter("movieid", movieID).getResultList();
    }
}

