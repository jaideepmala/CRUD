package jaideep.mala.Spring.CRUD.Repository;

import jaideep.mala.Spring.CRUD.Model.Account;
import jaideep.mala.Spring.CRUD.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findByAccount(Optional<Account> account);
}
