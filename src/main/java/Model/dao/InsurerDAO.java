package Model.dao;

import Model.Insurer;
import Util.HibernateUtil;
import com.sun.istack.NotNull;
import javafx.scene.control.Alert;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class InsurerDAO implements DAO<Insurer,Integer> {

    @Override
    public void create(@NotNull Insurer insurer) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(insurer);
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
    public Insurer read(@NotNull Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            final Insurer result = session.get(Insurer.class,id);
            if(result != null)
            {
                Hibernate.initialize(result.getResidence());
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
    public void update(@NotNull Insurer insurer) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(insurer);
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
    public void delete(@NotNull Insurer insurer) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(insurer);
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

}
