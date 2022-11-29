package ir.maktab.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class HibernateUtils {
    private HibernateUtils(){}
    @Getter
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY
            = Persistence.createEntityManagerFactory("hw20");
}