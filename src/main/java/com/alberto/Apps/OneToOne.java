package com.alberto.Apps;

import com.alberto.Entidades.Delantero;
import com.alberto.Entidades.Futbolista;
import com.alberto.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOne {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Delantero d1 = new Delantero("De hierro",null);
        Futbolista f1 = new Futbolista("Ramón", 4, null, null, d1);
        d1.setFutbolista(f1);
        ss.persist(f1);
        ss.persist(d1);

        Futbolista f2 = new Futbolista("Videdo", 4, null, null, null);
        Delantero d2 = new Delantero("Derecha",f2);
        f2.setDelantero(d2);
        ss.persist(f2);
        ss.persist(d2);

        t.commit();
    }
}
