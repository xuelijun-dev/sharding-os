package com.greenbon.account.domain.support.vo;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class InitAccountPageVo {
    /**
     * 开始的行数
     */
    private int startOffset;
    /**
     * 同步的行数
     */
    private int size;

    /**
     * 广告主wxId
     */
    private String wxId;

    public InitAccountPageVo(int startOffset, int size) {
        this.startOffset = startOffset;
        this.size = size;
    }

    public InitAccountPageVo(int startOffset, int size, String wxId) {
        this.startOffset = startOffset;
        this.size = size;
        this.wxId = wxId;
    }


}
