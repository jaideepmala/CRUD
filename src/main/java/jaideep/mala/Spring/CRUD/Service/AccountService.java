package jaideep.mala.Spring.CRUD.Service;

import jaideep.mala.Spring.CRUD.CustomMetric.CustomMetricService;
import jaideep.mala.Spring.CRUD.DTO.AccountsInputDTO;
import jaideep.mala.Spring.CRUD.DTO.OutputDTO;
import jaideep.mala.Spring.CRUD.Misc.Wrapper;
import jaideep.mala.Spring.CRUD.Misc.exception.ErrorDetails;
import jaideep.mala.Spring.CRUD.Misc.exception.InputFormatException;
import jaideep.mala.Spring.CRUD.Misc.exception.ResourceAlreadyExistsException;
import jaideep.mala.Spring.CRUD.Misc.exception.ResourceUnavailableException;
import jaideep.mala.Spring.CRUD.Model.Account;
import jaideep.mala.Spring.CRUD.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomMetricService customMetricService;
    Pattern p = Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
    public OutputDTO createAccount (AccountsInputDTO accountsInputDTO) throws Exception
    {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        if(Wrapper.isValid(accountsInputDTO.getCustomerName()) ||
                Wrapper.isValid(accountsInputDTO.getEmail()) || Wrapper.isValid(accountsInputDTO.getAuthLimit()))
        {
            ErrorDetails errorDetails = new ErrorDetails("Unable to process JSON", HttpStatus.BAD_REQUEST.value());
            RuntimeException exception = new InputFormatException(errorDetails.getMessage());
            throw exception;
        }

        if(p.matcher(accountsInputDTO.getEmail()).matches()==false)
        {
            ErrorDetails errorDetails = new ErrorDetails("Invalid Email", HttpStatus.FORBIDDEN.value());
            RuntimeException exception = new InputFormatException(errorDetails.getMessage());
            throw exception;
        }

        Optional<Account> accountOptional = accountRepository.findByEmail(accountsInputDTO.getEmail());
        if(accountOptional.isPresent())
        {
            ErrorDetails errorDetails = new ErrorDetails("Account with same email already exists",HttpStatus.CONFLICT.value());
            RuntimeException exception = new ResourceAlreadyExistsException(errorDetails.getMessage());
            throw exception;
        }
        Account account = new Account(accountsInputDTO.getCustomerName(), accountsInputDTO.getEmail(),
                accountsInputDTO.getAuthLimit(),0,currentTimestamp,currentTimestamp);
        accountRepository.save(account);
        Optional<Account> optionalAccount = accountRepository.findByEmail(accountsInputDTO.getEmail());
        Account a1= optionalAccount.get();
        OutputDTO outputDTO = new OutputDTO("Account successfully created", a1.getAcc_no());
        customMetricService.incrementCounter();
        return outputDTO;
    }

    public ResponseEntity<Account> getByAccno(Long id) throws Exception{
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if(!optionalAccount.isPresent())
        {
            ErrorDetails errorDetails = new ErrorDetails("Account Does Not Exists", HttpStatus.NOT_FOUND.value());
            RuntimeException exception = new ResourceUnavailableException(errorDetails.getMessage());
            throw exception;
        }
        Account account= optionalAccount.get();
        return new ResponseEntity<>(account,HttpStatus.OK);

    }

    public List<Account> getAllAccounts() throws Exception{
        List<Account> account = accountRepository.findAll();
        if(account.size()<=0)
        {
            ErrorDetails errorDetails = new ErrorDetails("No Account Exists", HttpStatus.NOT_FOUND.value());
            RuntimeException exception = new ResourceUnavailableException(errorDetails.getMessage());
            throw exception;
        }
        return account;

    }


}
