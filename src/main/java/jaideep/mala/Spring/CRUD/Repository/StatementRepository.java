package jaideep.mala.Spring.CRUD.Repository;

import jaideep.mala.Spring.CRUD.Model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepository extends JpaRepository<Statement,Long> {


}