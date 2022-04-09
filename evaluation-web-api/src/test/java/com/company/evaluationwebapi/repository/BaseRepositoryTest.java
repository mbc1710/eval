package com.company.evaluationwebapi.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.company.evaluationwebapi.BaseTest;
import com.company.evaluationwebapi.OrderedRunner;


@RunWith(OrderedRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public abstract class BaseRepositoryTest extends BaseTest {

    @MockBean
    protected PriceRepository priceRepository;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    
    @Before
    public void setup () {
        MockitoAnnotations.initMocks(this);
    }

}
