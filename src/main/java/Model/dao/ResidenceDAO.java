package Model.dao;

import Model.Residence;
import Util.HibernateUtil;
import com.sun.istack.NotNull;
import javafx.scene.control.Alert;
import org.hibernate.Session;

public class ResidenceDAO implements DAO<Residence,Integer> {

    @Override
    public void create(@NotNull Residence residence) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(residence);
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
    public Residence read(@NotNull Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            final Residence result = session.get(Residence.class,id);
            if(result != null)
            {
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
    public void update(@NotNull Residence residence) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(residence);
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
    public void delete(@NotNull Residence residence) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(residence);
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

