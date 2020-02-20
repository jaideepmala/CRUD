package jaideep.mala.Spring.CRUD.Controller;

import jaideep.mala.Spring.CRUD.DTO.CreditResponseDTO;
import jaideep.mala.Spring.CRUD.DTO.DebitResponseDTO;
import jaideep.mala.Spring.CRUD.DTO.TransactionInputDTO;
import jaideep.mala.Spring.CRUD.Model.Statement;
import jaideep.mala.Spring.CRUD.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/my")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @PostMapping(value = "/debit")
    public ResponseEntity<?> debit(@RequestBody TransactionInputDTO transactionInputDTO) throws Exception
    {
        DebitResponseDTO r =  transactionService.debitApi(transactionInputDTO);
        return new ResponseEntity<DebitResponseDTO>(r, HttpStatus.CREATED);
    }


    @PostMapping(value = "/credit")
    public ResponseEntity<?> credit(@RequestBody TransactionInputDTO transactionInputDTO) throws Exception
    {
        CreditResponseDTO r =  transactionService.creditApi(transactionInputDTO);
        return new ResponseEntity<CreditResponseDTO>(r, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getStatement/{acc_no}")
    public ResponseEntity<List<?>> statement(@PathVariable(name ="acc_no") Long acc_no) throws Exception
    {
        List<Statement> li = new ArrayList<>(transactionService.generateStatement(acc_no));
        return new ResponseEntity<List<?>>(li,HttpStatus.OK);
    }

}

