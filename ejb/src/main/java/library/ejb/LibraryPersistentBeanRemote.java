package library.ejb;/*
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

import library.models.*;

import javax.ejb.*;
import java.util.*;

@Remote
public interface LibraryPersistentBeanRemote {

    void addBook(Book bookName);

    Book updateBook(Book bookName);

    List<Book> getBooks();

}
