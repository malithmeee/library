/*
 *   (C) Copyright 1996-2015 hSenid Software International (Pvt) Limited.
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
package library.web;

import library.models.*;
import library.service.*;

import javax.annotation.*;
import javax.ejb.*;
import javax.faces.bean.*;
import javax.naming.*;
import java.util.*;

@ManagedBean
@SessionScoped
public class LibraryManagement {

    private String message;
    @EJB
    private LibraryServicesRemote libraryServices;
    private List<Book> bookList;
    private InitialContext ctx;

    @PostConstruct
    public void init() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        hashtable.put(Context.PROVIDER_URL, "jnp://localhost:1099");
        hashtable.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        try {
            ctx = new InitialContext(hashtable);
            libraryServices = (LibraryServicesRemote) ctx.lookup("library/LibraryServices/remote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        bookList = libraryServices.getAllBookList();
    }

    public LibraryManagement() {
    }

    public void getData() {
        bookList = libraryServices.getAllBookList();
    }

    public void saveBook() {
        libraryServices.saveBook(new Book(message));
        getData();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Book> getBookList() {
        getData();
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
