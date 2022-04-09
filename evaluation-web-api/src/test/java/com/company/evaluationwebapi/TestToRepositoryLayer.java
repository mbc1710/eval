package com.company.evaluationwebapi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.company.evaluationwebapi.repository.PriceRepositoryTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ PriceRepositoryTest.class })
public class TestToRepositoryLayer {
}