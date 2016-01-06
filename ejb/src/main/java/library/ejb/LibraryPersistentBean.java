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
package library.ejb;

import library.models.*;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;

@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

    public LibraryPersistentBean() {
    }

    @PersistenceContext(unitName = "EjbComponentPU")
    private EntityManager  entityManager;

    @Override
    public void addBook(Book bookName) {
        System.out.println("BOOK saving :" + bookName.toString());
        entityManager.persist(bookName);
    }

    @Override
    public Book updateBook(Book bookName) {
        return entityManager.merge(bookName);
    }

    @Override
    public List<Book> getBooks() {
        List<Book> bookList = entityManager.createQuery("from Book").getResultList();
        if (bookList == null) {
            return new ArrayList<Book>();
        } else {
            return bookList;
        }
    }
}
