package com.greenbon.account.webservice;


import com.greenbon.account.domain.AccountAssociate;
import com.greenbon.account.service.AccountAssociateService;
import com.greenbon.base.comm.IdsRequest;
import com.greenbon.base.controller.CommonController;
import com.greenbon.base.page.PageDTO;
import com.greenbon.base.statuscode.ResponseCode;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/associate")
public class AccountAssociateController extends CommonController<AccountAssociateService> {

    @PostMapping("add")
    public Object add(@Valid @RequestBody AccountAssociate associate) {
        return ResponseCode.getSuccess(service.add(associate));
    }

    @PostMapping("edit")
    public Object edit(@Valid @RequestBody AccountAssociate associate) {
        return ResponseCode.getSuccess(service.edit(associate));
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

