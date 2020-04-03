package com.accenture.tveratc.bank.Model;

import com.accenture.tveratc.bank.entity.GlobalSetting;

import javax.persistence.*;

public class GlobalSettingDAO {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("com.accenture.tveratc.bank.Model.GlobalSettingDAO");
    private static final boolean initialField = new InitialDefaultFields().initializeDefaultFields();


    public GlobalSetting getCode(String code) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM GlobalSetting c WHERE c.code=:code";

        TypedQuery<GlobalSetting> entityManagerQuery = entityManager.createQuery(query, GlobalSetting.class);
        entityManagerQuery.setParameter("code", code);

        GlobalSetting globalSetting = null;

        try {
            globalSetting = entityManagerQuery.getSingleResult();
            globalSetting = new GlobalSetting(globalSetting.getCode(), globalSetting.getValue());
        } catch (NoResultException ex) {
            ex.printStackTrace();

        } finally {
            entityManager.close();
        }
        return globalSetting;
    }


    public void updateValue(String code, String value) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        GlobalSetting globalSetting = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            globalSetting = entityManager.find(GlobalSetting.class, code);
            globalSetting.setValue(value);// ?
            entityManager.persist(globalSetting);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    private static class InitialDefaultFields {
        public boolean initializeDefaultFields() {
            String code = "DEPOSIT_RATE";
            String value = "12";
            EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
            EntityTransaction entityTransaction = null;

            GlobalSetting globalSetting = null;

            try {
                
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                globalSetting = entityManager.find(GlobalSetting.class, code);
                if (globalSetting == null) {
                    globalSetting = new GlobalSetting();
                    globalSetting.setCode(code);
                    globalSetting.setValue(value);
                }
                entityManager.persist(globalSetting);
                entityTransaction.commit();

            } catch (Exception e) {

                if (entityTransaction != null) {
                    entityTransaction.rollback();
                }
                e.printStackTrace();
            } finally {
                entityManager.close();
            }
            return true;
        }

    }

}
