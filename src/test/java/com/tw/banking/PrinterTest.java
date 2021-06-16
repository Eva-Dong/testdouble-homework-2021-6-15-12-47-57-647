package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class PrinterTest {

    @Test
    public void should_return_correct_statement_line_when_call_statement_line_method(){
        //given
        Console console = mock(Console.class);
        Printer printer = new Printer(console);
        Transaction transaction = new Transaction("16/06/2021", 1);

        //when
        String result = printer.statementLine(transaction, 1);

        //then
        assertEquals("16/06/2021 | 1 | 1", result);
    }

}