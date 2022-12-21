package org.example.groupweeks.week27.buyticket;


public class TicketImp {
    public static void main(String[] args) {
        /*
        There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and
        the (n - 1)th person is at the back of the line.

You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person would

like to buy is tickets[i].

Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go back
 to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not have
 any tickets left to buy, the person will leave the line.

Return the time taken for the person at position k (0-indexed) to finish buying tickets.
         */

        int tickets[] = {2, 4, 1, 3, 4, 2, 5};
        int k = 3;


        //answer is 15 but always trying to create object it give like other number
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy12(tickets,k));//15
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuyQueue(tickets,k));//15-0
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy11(tickets,k));//15--15
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy10(tickets,k));//15-3
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy9(tickets,k));//15--2--3
        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy8mine(tickets,k));//2 ms O(n)
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy7(tickets,k));//0
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy6(tickets,k));//0
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy5(tickets,k));//-3
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy4(tickets,k));//-3
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy3(tickets,k));//0
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy2(tickets,k));//0
//        System.out.println(new BuyTicketTimeNeed().timeRequiredToBuy1(tickets,k));//-3



    }
}