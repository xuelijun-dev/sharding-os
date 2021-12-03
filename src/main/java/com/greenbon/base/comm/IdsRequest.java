package com.greenbon.base.comm;

import lombok.Data;

import java.util.List;


@Data
public class IdsRequest {

    private List<Long> ids;

    private Integer type = -1;

}
