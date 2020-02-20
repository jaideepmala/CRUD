package jaideep.mala.Spring.CRUD.Service;

import jaideep.mala.Spring.CRUD.DTO.CreditResponseDTO;
import jaideep.mala.Spring.CRUD.DTO.DebitResponseDTO;
import jaideep.mala.Spring.CRUD.DTO.TransactionInputDTO;
import jaideep.mala.Spring.CRUD.Misc.StatusType;
import jaideep.mala.Spring.CRUD.Misc.TransactionType;
import jaideep.mala.Spring.CRUD.Misc.Wrapper;
import jaideep.mala.Spring.CRUD.Misc.exception.ErrorDetails;
import jaideep.mala.Spring.CRUD.Misc.exception.InputFormatException;
import jaideep.mala.Spring.CRUD.Misc.exception.ResourceUnavailableException;
import jaideep.mala.Spring.CRUD.Model.Account;
import jaideep.mala.Spring.CRUD.Model.Statement;
import jaideep.mala.Spring.CRUD.Model.Transaction;
import jaideep.mala.Spring.CRUD.Repository.AccountRepository;
import jaideep.mala.Spring.CRUD.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountRepository accountRepository;

    //    @Autowired
//    StatementRepository statementRepository;
    public DebitResponseDTO debitApi(TransactionInputDTO transactionInputDTO) throws Exception
    {
        if (Wrapper.isValid(transactionInputDTO.getAcc_no())
                || Wrapper.isValid(transactionInputDTO.getAmount())
                || Wrapper.isValid(transactionInputDTO.getDescription())){
            ErrorDetails errorDetails = new ErrorDetails("Unable to process JSON", HttpStatus.BAD_REQUEST.value());
            RuntimeException exception = new InputFormatException(errorDetails.getMessage());
            throw exception;
        }
        Optional<Account> account = accountRepository.findById(transactionInputDTO.getAcc_no());
        if (!account.isPresent())
        {
            ErrorDetails errorDetails = new ErrorDetails("Account Does Not Exists", HttpStatus.NOT_FOUND.value());
            RuntimeException exception = new ResourceUnavailableException(errorDetails.getMessage());
            throw exception;
        }
        if (transactionInputDTO.getAmount() > account.get().getAvailLimit())
        {
            ErrorDetails errorDetails = new ErrorDetails("insufficient Balance", HttpStatus.OK.value());
            RuntimeException exception = (RuntimeException) new Exception(errorDetails.getMessage());
            throw exception;
        }
        account.get().setAvailLimit(account.get().getAvailLimit()-transactionInputDTO.getAmount());
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        account.get().setUpdatedDate(currentTimestamp);
        Transaction transaction = new Transaction(account.get(), TransactionType.DEBIT, StatusType.SUCCESS, transactionInputDTO.getAmount());
        transactionRepository.save(transaction);
        Long transId = transaction.getTrans_id();
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transId);
        if (!optionalTransaction.isPresent())
        {
            ErrorDetails errorDetails = new ErrorDetails("Transaction Does Not Exists", HttpStatus.NOT_FOUND.value());
            RuntimeException exception = new ResourceUnavailableException(errorDetails.getMessage());
            throw exception;
        }
        Transaction t = optionalTransaction.get();
        DebitResponseDTO responseDTO = new DebitResponseDTO("Debit Successful",t.getTrans_id());
        return responseDTO;
    }

    public CreditResponseDTO creditApi (TransactionInputDTO transactionInputDTO) throws Exception
    {
        if (Wrapper.isValid(transactionInputDTO.getAcc_no())
                || Wrapper.isValid(transactionInputDTO.getAmount())
                || Wrapper.isValid(transactionInputDTO.getDescription())){

            ErrorDetails errorDetails = new ErrorDetails("Unable to process JSON", HttpStatus.BAD_REQUEST.value());
            RuntimeException exception = new InputFormatException(errorDetails.getMessage());
            throw exception;
        }
        Optional<Account> account = accountRepository.findById(transactionInputDTO.getAcc_no());
        if (!account.isPresent())
        {
            ErrorDetails errorDetails = new ErrorDetails("Account Does Not Exists", HttpStatus.NOT_FOUND.value());
            RuntimeException exception = new ResourceUnavailableException(errorDetails.getMessage());
            throw exception;

        }
        account.get().setAvailLimit(transactionInputDTO.getAmount()+account.get().getAvailLimit());
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        account.get().setUpdatedDate(currentTimestamp);
        Transaction transaction = new Transaction(account.get(), TransactionType.CREDIT, StatusType.SUCCESS,transactionInputDTO.getAmount());
        transactionRepository.save(transaction);
        Long transId = transaction.getTrans_id();
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transId);
        if (!optionalTransaction.isPresent())
        {
            ErrorDetails errorDetails = new ErrorDetails("Transaction Does Not Exists", HttpStatus.NOT_FOUND.value());
            RuntimeException exception = new ResourceUnavailableException(errorDetails.getMessage());
            throw exception;
        }
        Transaction t = optionalTransaction.get();
        CreditResponseDTO responseDTO = new CreditResponseDTO("Credit Successful",t.getTrans_id());
        return responseDTO;
    }

    public List<Statement> generateStatement(Long acc_no) throws Exception{
        if (Wrapper.isValid(acc_no))
        {
            ErrorDetails errorDetails = new ErrorDetails("Unable to process JSON", HttpStatus.BAD_REQUEST.value());
            RuntimeException exception = new InputFormatException(errorDetails.getMessage());
            throw exception;
        }
        Optional<Account> account= accountRepository.findById(acc_no);
        if(!account.isPresent())
        {
            ErrorDetails errorDetails = new ErrorDetails("Account Does Not Exists", HttpStatus.NOT_FOUND.value());
            RuntimeException exception = new ResourceUnavailableException(errorDetails.getMessage());
            throw exception;
        }
        List<Statement> statements = new ArrayList<>();
        List<Transaction> optionalTransaction = transactionRepository.findByAccount(account);
        for(int i=0;i<optionalTransaction.size();i++)
        {
            Statement statement = new Statement(acc_no,account.get().getAvailLimit(),optionalTransaction.get(i).getTransactionType(),
                    optionalTransaction.get(i).getStatusType(),account.get().getCreatedDate(),account.get().getUpdatedDate()) ;
            statements.add(statement);
            //statementRepository.save(statement);
        }
        return statements;
    }
}
