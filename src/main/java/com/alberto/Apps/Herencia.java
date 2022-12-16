package com.alberto.Apps;

import com.alberto.Entidades.Delantero;
import com.alberto.Entidades.Extremo;
import com.alberto.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Herencia {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Delantero d = new Delantero("Izquierda",null);
        Extremo e = new Extremo("Izquierda",null,"Derecha");

        ss.persist(d);
        ss.persist(e);

        t.commit();
    }
}
