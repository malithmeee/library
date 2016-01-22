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
package library.ejb.message;

import library.ejb.persistent.*;
import library.models.*;

import javax.annotation.*;
import javax.ejb.*;
import javax.jms.*;

@MessageDriven(
        name = "BookMessageHandler",
        activationConfig = {
                @ActivationConfigProperty( propertyName = "destinationType",
                        propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty( propertyName = "destination",
                        propertyValue ="queue/BookQueue")
        }
)
public class LibraryMessageBean implements MessageListener {

    @Resource
    private MessageDrivenContext mdctx;

    @EJB
    private LibraryPersistentBeanRemote libraryPersistentBeanRemote;

    @Override
    public void onMessage(Message message) {
        TextMessage objectMessage = (TextMessage) message;
        try {
            String name = objectMessage.getText();
            System.out.println(name + " >>>>>>-----------------------------------------");
            libraryPersistentBeanRemote.addBook(new Book(name));
        } catch (JMSException e) {
            e.printStackTrace();
            mdctx.setRollbackOnly();
        }
    }
}
