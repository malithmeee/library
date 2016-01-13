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
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Stateless
public class LibraryServices implements LibraryServicesRemote {

    @EJB
    private LibraryPersistentBeanRemote libraryPersistentBean;

    @Override
    public void saveBook(Book book) {
        libraryPersistentBean.addBook(book);
    }

    public Response saveBook(@PathParam("name") String name) {
        System.out.println(name + " ----------------------------------");
        libraryPersistentBean.addBook(new Book(name));
        return Response.ok().build();
    }

    @Override
    public void updateBook(Book book) {
        libraryPersistentBean.updateBook(book);
    }

    @Override
    public List<Book> getAllBookList() {
        return libraryPersistentBean.getBooks();
    }

    public void setLibraryPersistentBean(LibraryPersistentBeanRemote libraryPersistentBean) {
        this.libraryPersistentBean = libraryPersistentBean;
    }
}
