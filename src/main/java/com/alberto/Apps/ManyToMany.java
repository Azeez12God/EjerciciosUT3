package com.alberto.Apps;

import com.alberto.Entidades.Futbolista;
import com.alberto.Entidades.Marca;
import com.alberto.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ManyToMany {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Marca m1 = new Marca("Adidas", 5000, null);
        Marca m2 = new Marca("Nike", 6000, null);
        List<Marca> marcas = new ArrayList<>();
        marcas.add(m1); marcas.add(m2);

        Futbolista f1 = new Futbolista("Israel", 10, null, null, null);
        Futbolista f2 = new Futbolista("Samu", 5, null, null, null);
        List<Futbolista> futbolistas = new ArrayList<>();
        futbolistas.add(f1); futbolistas.add(f2);



        m1.setFutbolistas(futbolistas);
        m2.setFutbolistas(futbolistas);

        ss.persist(m1);
        ss.persist(m2);

        t.commit();

    }
}
