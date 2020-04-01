package com.accenture.tveratc.bank.Model;

import com.accenture.tveratc.bank.entity.Client;

import javax.persistence.*;

public class LoginJPA {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("client");

    public boolean validate(String login, String password) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c from Client c WHERE c.LOGIN=:login and c.PASSWORD=:password";
        TypedQuery<Client> tq = entityManager.createQuery(query, Client.class);

        Client client = null;

        try {
            client = tq.getSingleResult();
            if (client != null) {
                return true;
            }
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }

        return false;
    }
}
