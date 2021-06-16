package com.tw.banking;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    public void should_return_header_format_when_call_print_method_without_transactions(){
        //given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Console console = new Console();
        Printer printer = new Printer(console);
        List<Transaction> transactions = Lists.newArrayList();

        //when
        printer.print(transactions);

        //then
        assertEquals("DATE | AMOUNT | BALANCE\r\n", output.toString());
    }

    @Test
    public void should_return_correct_format_when_call_print_method_with_transactions(){
        //given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Console console = new Console();
        Printer printer = new Printer(console);
        List<Transaction> transactions =
                Lists.newArrayList(new Transaction("15/06/2021", 100), new Transaction("16/06/2021", 50));

        //when
        printer.print(transactions);

        //then
        assertEquals("DATE | AMOUNT | BALANCE\r\n16/06/2021 | 50 | 150\r\n15/06/2021 | 100 | 100\r\n", output.toString());
    }

}