package com.accenture.tveratc.bank.Controller;

import com.accenture.tveratc.bank.Model.LoginJPA;
import com.accenture.tveratc.bank.entity.Client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/loginjpa")
public class LoginControllerJPA {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/login")
    public void login(Client client) {
        LoginJPA loginJPA = new LoginJPA();

        if (loginJPA.validate(client.getLogin(),client.getPassword())){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

}
