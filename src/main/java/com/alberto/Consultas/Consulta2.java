package com.alberto.Consultas;

import com.alberto.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

/**
     * Seleccionar el número de jugadores según los goles según el número de goles
 */
public class Consulta2 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<Object[]> q = ss.createQuery("SELECT F.media, count (F.nom) from Futbolista F group by F.media");
        List<Object[]> futbolistas = q.list();
        for(Object[] f : futbolistas)
            System.out.println("Los de " + f[0] + " goles son " + f[1] + " futbolistas.");


    }

}
