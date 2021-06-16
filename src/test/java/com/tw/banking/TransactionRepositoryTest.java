package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class TransactionRepositoryTest {

    @Test
    public void should_add_a_transaction_with_amount_when_call_add_deposit(){
        //given
        Clock clock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        doReturn("16/06/2021").when(clock).todayAsString();

        //when
        transactionRepository.addDeposit(1);

        //then
        assertEquals(1, transactionRepository.transactions.size());
        assertEquals(1, transactionRepository.transactions.get(0).amount());
        assertEquals("16/06/2021", transactionRepository.transactions.get(0).date());
    }

    @Test
    public void should_add_a_transaction_with_amount_when_call_add_withdraw(){
        //given
        Clock clock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        doReturn("16/06/2021").when(clock).todayAsString();

        //when
        transactionRepository.addWithdraw(1);

        //then
        assertEquals(1, transactionRepository.transactions.size());
        assertEquals(-1, transactionRepository.transactions.get(0).amount());
        assertEquals("16/06/2021", transactionRepository.transactions.get(0).date());
    }

}