package com.soliduslabs.messagehashdemo.dao;

import com.soliduslabs.messagehashdemo.model.Message;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDAOImpl implements MessageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addMessage(Message m) {
        sessionFactory.getCurrentSession().save(m);
    }

    @Override
    public String getMessage(String hash) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * from messagehash where digest = \"" + hash + "\"");
        List<Object[]> rows = query.list();
        for(Object[] row : rows) {
            return row[0].toString();
        }

        return null;
    }
}
