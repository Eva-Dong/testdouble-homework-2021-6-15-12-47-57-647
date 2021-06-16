package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    @Test
    public void should_return_expect_value_when_call_print_line(){
        //given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Console console = new Console();

        //when
        console.printLine("D");

        //then
        assertEquals("D\r\n", output.toString());
    }

}