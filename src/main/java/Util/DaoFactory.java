package Util;

import Model.dao.*;

public class DaoFactory {

        private static PolicyDAO policyDAO = null;
        private static CarDAO carDAO = null;
        private static InsurerDAO insurerDAO = null;
        private static ResidenceDAO residenceDAO = null;
        private static DocumentDAO documentDAO = null;
        private static DaoFactory instance = null;

        public static synchronized DaoFactory getInstance(){
            if (instance == null){
                instance = new DaoFactory();
            }
            return instance;
        }

        public PolicyDAO getPolicyDAO(){
            if (policyDAO == null){
                policyDAO = new PolicyDAO();
            }
            return policyDAO;
        }

        public CarDAO getCarDAO(){
            if (carDAO == null){
                carDAO = new CarDAO();
            }
            return carDAO;
        }

        public ResidenceDAO getResidenceDAO(){
            if (residenceDAO == null){
                residenceDAO = new ResidenceDAO();
            }
            return residenceDAO;
        }

        public DocumentDAO getDocumentDAO(){
            if (documentDAO == null){
                documentDAO = new DocumentDAO();
            }
            return documentDAO;
        }

        public InsurerDAO getInsurerDAO(){
            if (insurerDAO == null){
                insurerDAO = new InsurerDAO();
            }
            return insurerDAO;
        }
}
