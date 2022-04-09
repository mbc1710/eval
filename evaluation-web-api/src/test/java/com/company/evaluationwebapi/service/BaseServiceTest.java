package com.company.evaluationwebapi.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.company.evaluationwebapi.BaseTest;
import com.company.evaluationwebapi.OrderedRunner;
import com.company.evaluationwebapi.repository.PriceRepository;
import com.company.evaluationwebapi.service.impl.PriceServiceImpl;

@RunWith(OrderedRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public abstract class BaseServiceTest extends BaseTest {

    @Mock
    protected PriceRepository priceRepository;

    @InjectMocks
    protected PriceServiceImpl priceServiceImpl;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

}
