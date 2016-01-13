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
package library.service;

import library.models.*;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Remote
@Path("/library")
public interface LibraryServicesRemote {

    void saveBook(Book book);

    @GET
    @Path("/book/{name}")
    Response saveBook(@PathParam("name") String name);

    void updateBook(Book book);

    List<Book> getAllBookList();
}
