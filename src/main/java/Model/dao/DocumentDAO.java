package Model.dao;

import Model.Document;
import Util.HibernateUtil;
import com.sun.istack.NotNull;
import javafx.scene.control.Alert;
import org.hibernate.Session;


public class DocumentDAO implements DAO<Document,Integer> {

    @Override
    public void create(@NotNull Document document) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(document);
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
    public Document read(@NotNull Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            final Document result = session.get(Document.class,id);
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
    public void update(@NotNull Document document) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(document);
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
    public void delete(@NotNull Document document) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(document);
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
