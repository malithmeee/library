/*
 *   (C) Copyright 1996-2016 hSenid Software International (Pvt) Limited.
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Software International (Pvt) Limited.
 *
 *   hSenid Software International (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 *
 */
package library.service.impl;

import library.ejb.*;
import library.models.*;
import library.service.*;

import javax.ejb.*;
import java.util.*;

@Stateless
public class LibraryServices implements LibraryServicesRemote {

    @EJB
    private LibraryPersistentBeanRemote libraryPersistentBean;

    @Override
    public void saveBook(Book book) {
        libraryPersistentBean.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        libraryPersistentBean.updateBook(book);
    }

    @Override
    public List<Book> getAllBookList() {
        System.out.println(libraryPersistentBean + "libraryPersistentBean-------------------------------");
        return libraryPersistentBean.getBooks();
    }

    public void setLibraryPersistentBean(LibraryPersistentBeanRemote libraryPersistentBean) {
        this.libraryPersistentBean = libraryPersistentBean;
    }
}
