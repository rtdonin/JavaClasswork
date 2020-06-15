/*
Created by: Margaret Donin
Date created: 05/11/20
Date revised:05/21/20
*/

package M3.Testing.DVDlibrary.controller;

import M3.Testing.DVDlibrary.dao.DVDLibraryDao;
import M3.Testing.DVDlibrary.dao.DVDLibraryDaoException;
import M3.Testing.DVDlibrary.dto.DVD;
import M3.Testing.DVDlibrary.ui.DVDLibraryView;
import M3.Testing.DVDlibrary.ui.UserIO;
import M3.Testing.DVDlibrary.ui.UserIOConsoleImpl;
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
        DVD removedDVD = dao.removeDVD(dvdTitle);
        view.displayRemoveResult(removedDVD);
    }
    
    private void editDVD() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        String dvdTitleToEdit = view.getDVDTitleChoice();
        DVD dvdToEdit = dao.getDVD(dvdTitleToEdit);
        view.displayDVD(dvdToEdit, false);
        
        if (dvdToEdit != null) {
            boolean keepGoing = true;
            String edit;
            
            try {
                while(keepGoing) {
                    int menuSelection = view.printEditMenuAndGetSelection();
                    switch(menuSelection) {
                        case 1:
                            // Special case. The title is the key
                            // we remove the key from the Map and create a new key and value
                            // v0 has it here, v1 has it in the DAO where it should be.
                            edit = view.getDVDEdit("title");
                            dao.editTitle(dvdToEdit, edit);
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
                        case 6:
                            keepGoing = false;
                            break;
                        default: unknownCommand();
                    }
                    view.displayDVD(dvdToEdit, false);
                }
            } catch (DVDLibraryDaoException e) {
                throw new DVDLibraryDaoException("Could not make edit.", e);
            }
        } else {
            view.createPause();
        }
        view.displayEditSuccessBanner();
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
}