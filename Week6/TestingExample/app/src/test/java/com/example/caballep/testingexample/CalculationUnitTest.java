package com.example.caballep.testingexample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculationUnitTest {

    Calculation calculation;

    Addition addition;
    Subtract subtract;
    Multiplication multiplication;
    Division division;

    @Before
    public void setUp() {
        addition = spy(Addition.class);
        subtract = mock(Subtract.class);
        multiplication = mock(Multiplication.class);
        division = mock(Division.class);

        calculation = new Calculation(addition, subtract, multiplication, division);
        calculation.setVal1(9);
        calculation.setVal2(9);
    }

    @Test
    public void testing_addition_should_add_two_numbers(){
        //when(addition.add(9,9)).thenReturn(27);
        assertEquals(calculation.addition(), 23);
    }

    @Test
    public void testing_check_if_method_is_beeing_called(){
        calculation.addition();
        verify(addition).doNothing();
    }
}
