/*
Created by: Margaret Donin
Date created: 
Date revised:
 */

package M2.DVDlibrary.dto;

public class DVD {
    private String title;
    private String releaseDate;
    private String MPAARating;
    private String director;
    private String studio;
    private String userRating;
    
    public DVD(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
    }
    
    public String getMPAARating() {
            return MPAARating;
    }
    
    public void setMPAARating(String mPAARating) {
            MPAARating = mPAARating;
    }
    
    public String getDirector() {
            return director;
    }
    
    public void setDirector(String director) {
            this.director = director;
    }
    
    public String getStudio() {
            return studio;
    }
    
    public void setStudio(String studio) {
            this.studio = studio;
    }
    
    public String getUserRating() {
            return userRating;
    }
    
    public void setUserRating(String userRating) {
            this.userRating = userRating;
    }
}
