package com.milosskovac.rezervisi.serviceImpl;
import com.milosskovac.rezervisi.exception.SQLEx;
import com.milosskovac.rezervisi.repository.ObjectRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import javax.transaction.Transactional;
import java.sql.SQLDataException;
import java.sql.SQLException;

@Service
public class ObjectServiceImpl {

    private final ObjectRepo objRepo;

    public ObjectServiceImpl(ObjectRepo objRepo) {
        
        this.objRepo = objRepo;
    }

   /* @Autowired
    @PersistenceContext
    private EntityManager em;*/

    @Transactional //(rollbackOn = SQLException.class)
    public String MainObject(String objName, String objStreet, String objNumber,
                           String objDistr, String cityName, String activityName) throws Exception {

        String x = null;
        try {
             x = objRepo.MainObject(objName, objStreet, objNumber, objDistr, cityName, activityName);

        } catch (Exception e) {
            throw new SQLException();
        }
        return x;
    }

}
