/*
Created by: Margaret Donin
Date created: 05/11/20
Date revised: 05/21/20
*/

package M3.Testing.DVDlibrary.ui;

import M3.Testing.DVDlibrary.dto.DVD;
import java.time.Year;
import java.util.List;

public class DVDLibraryView {
    private UserIO io;
    
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVD's");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter DVD name");
        int releaseDate = io.readInt("Please enter release date");
        String MPAARating = io.readString("Please enter MPAA rating");
        String director = io.readString("Please enter director name");
        String studio = io.readString("Please enter studio");
        String userRating = io.readString("Please enter personal rating and comments");

        DVD currentDVD = new DVD(title);
        
        currentDVD.setReleaseDate(Year.of(releaseDate));
        currentDVD.setMPAARating(MPAARating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        
        return currentDVD;
    }
    
    public void displayCreateDVDBanner() {
        io.print("~~~~ Create DVD ~~~~");
    }
    
    public void displayCreateSuccessBanner(){
        io.readString("DVD successfully created. Please hit enter to continue.");
    }
    
    public void displayDVDLibrary(List<DVD> dvdList){
        for(DVD currentDVD : dvdList) {
            String dvdInfo = String.format("%s (%s)",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate().toString());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayAllBanner(){
        io.print("~~~~ Display All DVDs ~~~~");
    }
    
    public void displayDisplayAllBanner() {
        io.print("~~~~ Display DVD ~~~~");
    }
    
    public String getDVDTitleChoice() {
        return io.readString("Please enter the DVD title.");
    }
    
    public void displayDVD(DVD dvd, boolean prompt) {
        if(dvd != null) {
            io.print(dvd.getTitle() + " " + dvd.getReleaseDate().toString());
            io.print("Directed by " + dvd.getDirector());
            io.print("Rated " + dvd.getMPAARating());
            io.print(dvd.getStudio());
            io.print("Notes: " + dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such DVD. ");
        }
        
        if (prompt){
            io.readString("Please hit enter to continue.");
        }
    }
    
    public void displayRemoveDVDBanner () {
        io.print("~~~~ Remove DVD ~~~~");
    }
    
    public void displayRemoveResult(DVD selectedDVD) {
        if(selectedDVD != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such DVD,");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayEditDVDBanner() {
        io.print("~~~~ Edit DVD ~~~~");
    }
    
    public int printEditMenuAndGetSelection() {
        io.print("Edit Menu");
        io.print("1. Edit Title");
        io.print("2. Edit Release Date");
        io.print("3. Edit MPAA Rating");
        io.print("4. Edit Studio");
        io.print("5. Edit User Rating");
        io.print("6. Exit editing");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public String getDVDEdit(String toEdit) {
        return io.readString("What would you like to change the " + toEdit + " to? ");
    }
    
    public String displayEditSuccessBanner() {
        return io.readString("DVD successfully edited. Please hit enter to continue.");
    }
        
    public void displayExitBanner() {
        io.print("GoodBye");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("~~~~ Unknown Command ~~~~");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("~~~~ ERROR ~~~~");
        io.print(errorMsg);
    }
    
    public void createPause() {
        io.readString("Please hit enter to continue");
    }
}
