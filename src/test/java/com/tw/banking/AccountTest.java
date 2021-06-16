package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class AccountTest {

    @Test
    public void should_execute_add_deposit_method_when_call_deposit(){
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);

        //when
        account.deposit(1);

        //then
        verify(transactionRepository).addDeposit(1);
    }

    @Test
    public void should_execute_add_withdraw_method_when_call_withdraw(){
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);

        //when
        account.withdraw(1);

        //then
        verify(transactionRepository).addWithdraw(1);
    }

    @Test
    public void should_execute_print_method_and_result_is_expected(){
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);
        List<Transaction> list = new ArrayList<>();
        doReturn(list).when(transactionRepository).allTransactions();

        //when
        account.printStatement();

        //then
        verify(printer).print(list);
    }

}