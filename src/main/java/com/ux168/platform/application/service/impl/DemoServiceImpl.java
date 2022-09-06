package com.ux168.platform.application.service.impl;

import com.ux168.platform.application.dto.MoneyModel;
import com.ux168.platform.application.service.DemoService;
import com.ux168.platform.domain.blog.service.BlogUserBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private BlogUserBizService blogUserBizService;

    @Override
    public MoneyModel getMoneyModel() {
        String s = blogUserBizService.get();
        MoneyModel moneyModel = new MoneyModel();
        moneyModel.setName(s);
        return moneyModel;
    }
}
