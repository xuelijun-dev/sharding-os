package com.greenbon.account.webservice;


import com.greenbon.account.domain.Account;
import com.greenbon.account.service.AccountService;
import com.greenbon.base.comm.IdsRequest;
import com.greenbon.base.page.PageDTO;
import com.greenbon.base.statuscode.ResponseCode;
import com.greenbon.base.webservice.CommonController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController extends CommonController<AccountService> {

    @PostMapping("add")
    public Object add(@Valid @RequestBody Account account) {
        return ResponseCode.getSuccess(service.add(account));
    }

    @PostMapping("edit")
    public Object edit(@Valid @RequestBody Account account) {
        return ResponseCode.getSuccess(service.edit(account));
    }

    @PostMapping("delete")
    public Object delete(@RequestBody IdsRequest idsRequest) {
        return ResponseCode.getSuccess(service.delete(idsRequest.getIds()));
    }


    @GetMapping("findById")
    public Object findById(Long id) {
        return ResponseCode.getSuccess(service.findById(id));
    }

    @PostMapping("queryPage")
    public Object queryPage(@RequestBody PageDTO dto) {
        return ResponseCode.getSuccess(service.queryPage(dto));
    }

}

