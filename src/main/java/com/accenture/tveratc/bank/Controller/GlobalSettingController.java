package com.accenture.tveratc.bank.Controller;

import com.accenture.tveratc.bank.Model.GlobalSettingDAO;
import com.accenture.tveratc.bank.entity.GlobalSetting;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/global-setting")
public class GlobalSettingController {


    @GET()
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{code}")
    public GlobalSetting getGlobalSettings(@PathParam("code") String code) {
        return new GlobalSettingDAO().getCode(code);

    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/update")
    public void updateValue(GlobalSetting globalSetting) {
        new GlobalSettingDAO().updateValue(globalSetting.getCode(), globalSetting.getValue());
    }


}
