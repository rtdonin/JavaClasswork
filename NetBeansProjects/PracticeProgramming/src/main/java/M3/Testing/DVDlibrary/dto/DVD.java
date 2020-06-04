/*
Created by: Margaret Donin
Date created: 05/11/20
Date revised: 06/04/20
 */

package M3.Testing.DVDlibrary.dto;

import java.time.Year;
import java.util.Objects;

public class DVD {
    private String title;
    private Year releaseDate;
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

    public Year getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(Year releaseDate) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.title);
        hash = 41 * hash + Objects.hashCode(this.releaseDate);
        hash = 41 * hash + Objects.hashCode(this.MPAARating);
        hash = 41 * hash + Objects.hashCode(this.director);
        hash = 41 * hash + Objects.hashCode(this.studio);
        hash = 41 * hash + Objects.hashCode(this.userRating);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.MPAARating, other.MPAARating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.userRating, other.userRating)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DVD{" + "title=" + title + ", releaseDate=" + releaseDate.toString() + ", MPAARating=" + MPAARating + ", director=" + director + ", studio=" + studio + ", userRating=" + userRating + '}';
    }
    
}
