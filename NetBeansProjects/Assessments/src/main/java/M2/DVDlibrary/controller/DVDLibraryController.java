/*
Created by: Margaret Donin
Date created: 
Date revised:
*/

package M2.DVDlibrary.controller;

import M2.DVDlibrary.dao.DVDLibraryDao;
import M2.DVDlibrary.dao.DVDLibraryDaoException;
import M2.DVDlibrary.dto.DVD;
import M2.DVDlibrary.ui.DVDLibraryView;
import M2.DVDlibrary.ui.UserIO;
import M2.DVDlibrary.ui.UserIOConsoleImpl;
import java.util.List;

public class DVDLibraryController {
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryView view;
    private DVDLibraryDao dao;
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() throws DVDLibraryDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1: listDVDs();
                        break;
                    case 2: createDVD();
                        break;
                    case 3: viewDVD();
                        break;
                    case 4: removeDVD();
                        break;
                    case 5: editDVD();
                        break;
                    case 6: keepGoing = false;
                        break;
                    default: unknownCommand();
                }
            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }
    
    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdLibrary = dao.getAllDVDs();
        view.displayDVDLibrary(dvdLibrary);
    }
    
    private void viewDVD() throws DVDLibraryDaoException {
        String dvdChoice = view.getDVDTitleChoice();
        DVD chosenDVD = dao.getDVD(dvdChoice);
        view.displayDVD(chosenDVD, true);
    }
    
    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVD removedDVD = dao.getDVD(dvdTitle);
        view.displayRemoveResult(removedDVD);
    }
    
    private void editDVD() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        String dvdTitleToEdit = view.getDVDTitleChoice();
        DVD dvdToEdit = dao.getDVD(dvdTitleToEdit);
        view.displayDVD(dvdToEdit, false);
        
        if (dvdToEdit != null) {
            int menuSelection = view.printEditMenuAndGetSelection();
            String edit;
            
            try {
                switch(menuSelection) {
                    case 1:
                        // Special case. The title is the key
                        // we remove the key from the Map and create a new key and value
                        edit = view.getDVDEdit("title");
                        dao.removeDVD(dvdTitleToEdit);
                        dao.editTitle(dvdToEdit, edit);
                        dvdToEdit = dao.getDVD(edit);
                        break;
                    case 2:
                        edit = view.getDVDEdit("release date");
                        dao.editReleaseDate(dvdToEdit, edit);
                        break;
                    case 3:
                        edit = view.getDVDEdit("MPAA Rating");
                        dao.editMPAARating(dvdToEdit, edit);
                        break;
                    case 4:
                        edit = view.getDVDEdit("studio");
                        dao.editStudio(dvdToEdit, edit);
                        break;
                    case 5:
                        edit = view.getDVDEdit("user rating");
                        dao.editUserRating(dvdToEdit, edit);
                        break;
                    default: unknownCommand();
                }
                
                view.displayEditSuccessBanner();
                view.displayDVD(dvdToEdit, false);
                
            } catch (DVDLibraryDaoException e) {
                throw new DVDLibraryDaoException("Could not make edit.", e);
            }
        } else {
            view.createPause();
        }
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
}