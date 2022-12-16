package com.alberto.Apps;

import com.alberto.Entidades.Deporte;
import com.alberto.Entidades.Futbolista;
import com.alberto.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OneToMany {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Futbolista f1 = new Futbolista("DieGOD", 2, null, null, null);
        Futbolista f2 = new Futbolista("Ferchu", 28, null, null,null);

        List<Futbolista> futbolistas = new ArrayList<>();
        futbolistas.add(f1); futbolistas.add(f2);

        Deporte d = new Deporte("Futbol", futbolistas);
        f1.setDeporte(d);
        f2.setDeporte(d);
        System.out.println(f1);
        System.out.println(f2);

        ss.persist(f1);
        ss.persist(f2);

        t.commit();
    }
}
