package com.accenture.tveratc.bank.Model;

import com.accenture.tveratc.bank.entity.GlobalSetting;

import javax.persistence.*;

public class GlobalSettingDAO {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("global-setting");

    public GlobalSetting getCode(String code) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM GlobalSetting c WHERE c.code=:code";

        TypedQuery<GlobalSetting> tq = em.createQuery(query, GlobalSetting.class);
        tq.setParameter("code", code);

        GlobalSetting globalSetting = null;

        try {
            globalSetting = tq.getSingleResult();
            return new GlobalSetting(globalSetting.getCode(), globalSetting.getValue());
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

}
