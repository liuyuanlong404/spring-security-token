package org.lakers.controller;

import lombok.Data;
import org.lakers.config.web.Sensitive;
import org.lakers.config.web.SensitiveStrategy;

/**
 * Created on 2023/3/8 10:54
 *
 * @author lakers
 */
@Data
public class SensitiveTest {

    @Sensitive(SensitiveStrategy.ID_CARD)
    private String idCard = "610323199704244237";

    @Sensitive(SensitiveStrategy.MOBILE)
    private String mobile = "17691354437";

    @Sensitive(SensitiveStrategy.EMAIL)
    private String email = "1501862490@qq.com";

    @Sensitive(SensitiveStrategy.BANK_CARD)
    private String bankCard = "6210903600001081560";

    private SensitivePo sensitivePo;
}
