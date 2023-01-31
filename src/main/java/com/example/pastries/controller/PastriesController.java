package com.example.pastries.controller;

import com.example.pastries.dao.DaoFactory;
import com.example.pastries.dao.entity.Pastry;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/hello-world")
public class PastriesController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {

        List<Pastry> pastries  = DaoFactory.createPastryDao().getAll();

        return Response
                .status(Response.Status.FOUND)
                .entity(pastries)
                .build();
    }

    @GET
    @Path("/{idParam}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("idParam") Long idSearched) {

        Optional<Pastry> userOpt = DaoFactory.createPastryDao().get(idSearched);

        if(userOpt.isEmpty()){
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(userOpt.get())
                .build();
    }


    //Soucis tranformation json dao
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPastry(Pastry pastry){

        DaoFactory.createPastryDao().create(pastry);



        return Response
                .status(Response.Status.CREATED)
                .build();
    }



    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePastry(Pastry pastry){


        DaoFactory.createPastryDao().update(pastry);





        return Response
                .status(Response.Status.CREATED)
                .build();
    }


    @DELETE
    @Path("/{idParam}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePastry(@PathParam("idParam") Long idSearched){

        Optional<Pastry> pastry = DaoFactory.createPastryDao().get(idSearched);

        if (pastry.isPresent()){
            DaoFactory.createPastryDao().delete(pastry.get());
        }

        return Response
                .status(Response.Status.OK)
                .build();
    }


}