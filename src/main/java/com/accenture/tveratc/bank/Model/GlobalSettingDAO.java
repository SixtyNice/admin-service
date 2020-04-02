package com.accenture.tveratc.bank.Model;

import com.accenture.tveratc.bank.entity.GlobalSetting;

import javax.persistence.*;

public class GlobalSettingDAO {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("com.accenture.tveratc.bank.Model.GlobalSettingDAO");
    private static final boolean initialField = new InitialDefaultFields().initializeDefaultFields();


    public GlobalSetting getCode(String code) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM GlobalSetting c WHERE c.code=:code";

        TypedQuery<GlobalSetting> tq = em.createQuery(query, GlobalSetting.class);
        tq.setParameter("code", code);

        GlobalSetting globalSetting = null;

        try {
            globalSetting = tq.getSingleResult();
            globalSetting = new GlobalSetting(globalSetting.getCode(), globalSetting.getValue());
        } catch (NoResultException ex) {
            ex.printStackTrace();

        } finally {
            em.close();
        }
        return globalSetting;
    }


    public void updateValue(String code, String value) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        GlobalSetting globalSetting = null;

        try {
            et = em.getTransaction();
            et.begin();
            globalSetting = em.find(GlobalSetting.class, code);
            globalSetting.setValue(value);
            em.persist(globalSetting);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    private static class InitialDefaultFields {
        public boolean initializeDefaultFields() {
            String code = "DEPOSIT_RATE";
            String value = "12";
            EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
            EntityTransaction et = null;

            GlobalSetting globalSetting = null;

            try {
                et = em.getTransaction();
                et.begin();
                globalSetting = em.find(GlobalSetting.class, code);
                if (globalSetting == null) {
                    globalSetting = new GlobalSetting();
                    globalSetting.setCode(code);
                    globalSetting.setValue(value);
                }
                em.persist(globalSetting);
                et.commit();

            } catch (Exception e) {

                if (et != null) {
                    et.rollback();
                }
                e.printStackTrace();
            } finally {
                em.close();
            }
            return true;
        }

    }

}
