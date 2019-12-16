package com.asukhoverka.localization;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;
import java.util.Map;

public class Test extends TestCase {
    private SessionFactory sessionFactory;

    @Override
    protected void setUp() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Override
    protected void tearDown() {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    @SuppressWarnings("unchecked")
    public void testBasicUsage() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        HotelImpl hotel = new HotelImpl();
        hotel.setCode("TEST");

        session.saveOrUpdate(hotel);
        session.getTransaction().commit();

        session.beginTransaction();
        HotelImplLocalized localizedHotel = new HotelImplLocalized();
        localizedHotel.setAddress("test");
        String localeEn = "en_us";
        localizedHotel.getHotelImplLocalizedPK().setLocale(localeEn);
        localizedHotel.setAsset(hotel);

        session.saveOrUpdate(localizedHotel);

        session.getTransaction().commit();

        session.close();
    }
}
