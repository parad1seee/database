package Model.dao;

import Model.Policy;
import Util.DateUtil;
import Util.HibernateUtil;
import com.sun.istack.NotNull;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.time.LocalDate;


public class PolicyDAO implements DAO<Policy,Integer> {
    @Override
    public void create(@NotNull  Policy policy) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(policy);
            session.getTransaction().commit();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка при вставке");
            alert.setContentText(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Policy read(@NotNull Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            final Policy result = session.get(Policy.class,id);
            if(result != null)
            {
                Hibernate.initialize(result.getDocument());
                Hibernate.initialize(result.getCar());
                Hibernate.initialize(result.getInsurer());
                return result;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка при чтении");
            alert.setContentText(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }

        }
        return null;
    }

    @Override
    public void update(@NotNull Policy policy) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(policy);
            session.getTransaction().commit();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка при обновлении");
            alert.setContentText(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(@NotNull Policy policy) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(policy);
            session.getTransaction().commit();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка при удалении");
            alert.setContentText(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public ObservableList<Policy> selectAll()
    {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            StringBuilder query = new StringBuilder("from Policy");
            Query result = session.createQuery(query.toString());
            session.getTransaction().commit();
            return FXCollections.observableArrayList(result.getResultList());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка 'getAll'");
            alert.setContentText(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    public ObservableList<Policy> selectAllByPolicyEndDate(LocalDate begin, LocalDate end) {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            StringBuilder query = new StringBuilder("from Policy where end_date BETWEEN '"
                    + DateUtil.formatSecond(begin) + "' AND '"
                    + DateUtil.formatSecond(end) + "'");
            Query result = session.createQuery(query.toString());
            System.out.println(query.toString());
            session.getTransaction().commit();
            return FXCollections.observableArrayList(result.getResultList());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка 'getAllByEndDate'");
            alert.setContentText(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }
}


