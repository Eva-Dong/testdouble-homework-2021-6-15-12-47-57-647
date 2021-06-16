package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    @Test
    public void should_return_1_when_self_date_is_after_another_date(){
        //given
        Transaction transaction1 = new Transaction("16/06/2021", 1);
        Transaction transaction2 = new Transaction("17/06/2021", 1);

        //when + when
        assertEquals(1, transaction2.compareTo(transaction1));
    }

    @Test
    public void should_return_negative_one_when_self_date_is_before_another_date(){
        //given
        Transaction transaction1 = new Transaction("16/06/2021", 1);
        Transaction transaction2 = new Transaction("17/06/2021", 1);

        //when + when
        assertEquals(-1, transaction1.compareTo(transaction2));
    }

}