package com.alberto.Consultas;

import com.alberto.Entidades.Futbolista;
import com.alberto.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;


public class Consulta1 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Query<String> q = ss.createQuery("Select nom from Futbolista order by nom desc", String.class);


        Iterator<String> futbolistas = q.stream().iterator();
        while(futbolistas.hasNext())
            System.out.println(futbolistas.next());
    }
}
