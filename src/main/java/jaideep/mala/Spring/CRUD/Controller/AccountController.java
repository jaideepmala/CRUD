package jaideep.mala.Spring.CRUD.Controller;

import jaideep.mala.Spring.CRUD.DTO.AccountsInputDTO;
import jaideep.mala.Spring.CRUD.DTO.OutputDTO;
import jaideep.mala.Spring.CRUD.Model.Account;
import jaideep.mala.Spring.CRUD.Service.AccountService;
import jaideep.mala.Spring.CRUD.redis.RedisClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    RedisClientImpl redisClient;
    @PostMapping(value="/create")
    public ResponseEntity<?> addAccount(@RequestBody AccountsInputDTO accountsInputDTO) throws Exception {
        OutputDTO r1 =accountService.createAccount(accountsInputDTO);
        return new ResponseEntity<>(r1, HttpStatus.CREATED);
    }
    @GetMapping(value = "/getallusers")
    public List<Account> getAllAccounts() throws Exception{
        List<Account> li = accountService.getAllAccounts();
        return li;

    }
    @GetMapping(value = "/getuser/{acc_no}")
    public ResponseEntity<?> getAccountById(@PathVariable (value = "acc_no") Long acc_no) throws Exception
    {
        ResponseEntity<Account> accountByid = accountService.getByAccno(acc_no);
        return new ResponseEntity<>(accountByid, HttpStatus.OK);
    }
    @GetMapping(value = "/gettkey")
    public Integer getkey(@RequestParam String key)
    {
        if(redisClient.getValue(key)==null){
            System.out.println("null");
            return 0;
        }else
        {
            return Integer.parseInt((String) redisClient.getValue(key));
        }
    }
    @PostMapping(value = "/settkey")
    public String setkey(@RequestParam String key)
    {
       redisClient.setValue(key,"1");
       return "done";
    }
    @GetMapping(value = "/increment")
    public String increment(@RequestParam String key)
    {
        redisClient.increment(key);
        return "done";
    }
    @GetMapping(value = "/getexpire")
    public Long getExpire(@RequestParam String key)
    {
        return redisClient.getExpire(key);

    }
    @PostMapping(value =  "/delete")
    public void delete()
    {
        redisClient.deleteKey("mykey123");
    }
}

