package Model.dao;

import Model.Car;
import Util.HibernateUtil;
import com.sun.istack.NotNull;
import javafx.scene.control.Alert;
import org.hibernate.Session;

public class CarDAO implements DAO<Car,Integer> {

    @Override
    public void create(@NotNull Car car) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
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
    public Car read(@NotNull Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            final Car result = session.get(Car.class,id);
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
    public void update(@NotNull Car car) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(car);
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
    public void delete(@NotNull Car car) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
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