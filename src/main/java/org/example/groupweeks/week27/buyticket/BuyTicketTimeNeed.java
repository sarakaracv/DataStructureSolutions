package org.example.groupweeks.week27.buyticket;

import java.util.*;
import java.util.stream.Collectors;

public class BuyTicketTimeNeed {
    public int timeRequiredToBuyBrute(int[] tickets, int k) {//runtime 3 ms bruteforce
        int result = 0;
        while (tickets[k] !=0){
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[k] ==0){
                    break;
                }
                if (tickets[i] !=0){
                    tickets[i] -= 1;
                    result++;
                }
            }
        }
        return  result;
    }


    public int timeRequiredToBuysort(int [] tickets, int k){//run time 1 ms mine 2// o(n) run time O(1)
        int count = 0;

        for (int i = 0; i < tickets.length; i++) {
            if(i <= k)
                count += Math.min(tickets[i], tickets[k]);
            else count += Math.min(tickets[k] - 1, tickets[i]);
        }

        return count;
    }


    public int timeRequiredToBuy1(int[] tickets, int k) {
        int ans = 0;
        for (int i = 0; i < tickets.length; i++) {
            ans += Math.min(tickets[i], tickets[k]);

            if (i > k && tickets[i] >= tickets[k]) {
                ans--;
            }
        }

        return ans;
    }

    public int timeRequiredToBuy2(int[] tickets, int k) {
        int ans = 0;
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[k] == 0) {
                    return ans;
                }
                if (tickets[i] != 0) {
                    tickets[i] = tickets[i] - 1;
                    ans++;
                }
            }
        }
        return ans;
    }

    public int timeRequiredToBuy3(int[] arr, int k) {
        int count = 0;
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    arr[i] = arr[i] - 1;
                    count = count + 1;
                }
                if (arr[k] == 0) {
                    return count;
                }
            }
        }
    }

    public int timeRequiredToBuy4(int[] tickets, int k) {// best solution
        if (tickets == null || tickets.length == 0 || k > tickets.length)
            return 0;

        /*
          Intuition: Since 1 ticket is bought in 1 second. Number of tickets bought will give us the total time taken.
          We know we have to buy "tickets[k]" number of tickets. 2 cases possible:

    Case-1: Going in a loop we are purchasing tickets and until we purchase "tickets[k]" number of tickets the people
    infront(left) of us buy tickets which is equal to Math.min(tickets[i], tickets[k]) because tickets[i] can be
    greater/lesser than tickets[k], and we can only buy the minimum of both.
          Ex-1: tickets[i], tickets[k] => 2, 4 implies i'th person can only buy 2 tickets.
          Ex-2: tickets[i], tickets[k] => 5, 3 implies i'th person can only buy 3 tickets and he still
          has 2 more tickets to buy which we dont have to wait for

    Case-2: Once we buy all the required tickets (i.e., tickets[k] becomes 0) we no longer have to buy(count) the tickets
     which are behind(right) of us. That means we only have to buy tickets until the last iteration before which tickets[k]
     becomes 0 i.e., the previous iteration where tickets[k]-1 are the amount of tickets to be bought.

    Note: If above cases don't make sense. Think of it this way, we have divided the cases into 2 parts. One which are
     on & before(to the left) of 'k' and other which are to the right of 'k'
        */


        int timeTaken = 0; // TimeTaken = TicketsBought


        // The way to calculate number of tickets bought
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                timeTaken += Math.min(tickets[i], tickets[k]);  // Case 1
            } else {
                timeTaken += Math.min(tickets[k] - 1, tickets[i]); // Case 2
            }
        }

        return timeTaken;
    }

    public int timeRequiredToBuy5(int[] tickets, int k) {
        int ans = 0;
        for (int i = 0; i <= k; i++) ans += Math.min(tickets[i], tickets[k]);
        for (int i = k + 1; i < tickets.length; i++) ans += Math.min(tickets[i], tickets[k] - 1);
        return ans;
    }

    public int timeRequiredToBuy6(int[] tickets, int k) {
        int seconds = 0;
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] == 0) {
                    continue;
                }
                tickets[i]--;
                seconds++;
                if (tickets[k] == 0) {
                    break;
                }
            }
        }
        return seconds;
    }

    public int timeRequiredToBuy7(int[] tickets, int k) {
        int count = 0;
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0 && tickets[k] > 0) {
                    count++;
                    tickets[i] -= 1;
                }
            }
        }
        return count;
    }

    public int timeRequiredToBuy8mine(int[] tickets, int k) {
        int count=0;
        for (int i=0; i<tickets.length;i++){
            if (tickets[k]==0) break;
            if (tickets[i]==0) count=count;
            else {tickets[i]=tickets[i]-1; count++;
            }
            if (i==tickets.length-1) i=-1;
        }
        return count;

    }

    public int timeRequiredToBuy9(int[] tickets, int k) {
        int res = 0;
        for (int i = 0; i < tickets.length; i++) {
            // if any ticket value is less than the tickets[k], then we consume it completley
            if (tickets[i] <= tickets[k]) {
                res += tickets[i];
            } else { // if ticket value is greater than tickets[k], then the MAX we can dd from this is tickets[k]
                res += tickets[k]; // if tickets[i] > tickets[k] then add tickets[k]
            }

            // if i > k, and tickets[i] >= tickets[k] (we had already added the value of tickets[k] above when tickets[i] > ticket[k])
            // But the people POST position 'k' will only be able to consume the tickets until 'k' gets full exhausted
            // but we have added complete tickets[k] for them above so we need to remove 1 for each idx (since once tickets[k]
            // exhausted we will not move ahead)
            // reduce each by 1
            if (i > k && tickets[i] >= tickets[k]) {
                res--;
            }
        }
        return res;
        // Lets say tickets = [2,4,1,3,4,2,5], k = 3
// Since the people move one-by-one ahead and get 1 ticket at a time so after 1st round the new array would be
// [1,3,0,2,3,1,4], remove 0 from queue
// after second round -> [0,2,0,1,2,0,3], remove 0 from queue
// after third round -> [0,1,0,0,2,0,3] -> now tickets[3] has been completely consumed (so we will not move forward in QUEUE so the remaining one AFTER k remains in same state before)

// What we noticed:
// ALL the elements BEFORE index 3 which were less than tickets[3] are COMPLETELY consumed
// ALL the elements BEFORE index 3 which were more than tickets[3] are PARTIALLY consumed (consumed by tickets[3])
// ALL the elements AFTER index 3 which were less than tickets[3] are COMPLETELY consumed
// ALL the elements AFTER index 3 which were more than tickets[3] are PARTIALLY consumed (only consumed until tickets[k] doesn't get 0 and nothing after that)

// TC : O(N)
// SC : O(1)
    }

    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums)
            if (min > i)
                min = i;
        return min;
    }

    public int timeRequiredToBuy10(int[] tickets, int k) {
        int min = findMin(tickets);
        int n = tickets.length;
        int time = 0;
        for (int i = 0; i < n; i++)
            tickets[i] -= min;
        if (tickets[k] == 0)
            return n * (min - 1) + (k + 1);
        time = n * min;
        while (tickets[k] > 0) {
            for (int i = 0; i < n; i++) {
                if (i == k && tickets[i] == 1)
                    return time + 1;
                if (tickets[i] > 0) {
                    time += 1;
                    tickets[i] -= 1;
                }
            }
        }
        return time;
    }

    public int timeRequiredToBuy11(int[] tickets, int k) {
        int time = 0, flag = 1;
        while (flag == 1) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    time++;
                    if (i == k && tickets[i] == 0) {
                        flag = 0;
                        break;
                    }
                }
            }
        }
        return time;
    }
    public int timeRequiredToBuy12(int [] tickets,int k){
        int count=0;
        while(tickets[k]!=0){
            for(int i=0;i<tickets.length;i++){
                if(tickets[i]==0)
                    continue;
                else{
                    tickets[i]--;
                    count++;
                }
                if(tickets[k]==0)
                    break;
            }
            if(tickets[k]==0)
                break;
        }
        return count;
    }

    public int timeRequiredToBuyQueue(int[] tickets, int k) {

        if (tickets[k] == 0) return 0;

        tickets[k] = -1 * tickets[k];

        Deque<Integer> queue = new ArrayDeque<>();
        for (int n : tickets) {
            if (n != 0) queue.offerLast(n);
        }

        int timeTaken = 0;

        while (!queue.isEmpty()) {
            int ticket = queue.pollFirst();

            boolean target = ticket < 0;

            if (ticket < 0) ticket += 1;
            else ticket -= 1;

            ++timeTaken;

            if (ticket == 0 && target) break;
            if (ticket != 0) queue.offerLast(ticket);
        }
        return timeTaken;
    }
    public int timeRequiredToBuyQueue2(int[] tickets, int k) {
        Queue<Integer> ticketQueue = Arrays.stream(tickets).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        int totalTime = 0;
        while (!ticketQueue.isEmpty()) {

            int currentTicketCount = ticketQueue.poll()-1;
            totalTime++;
            int currentIndex = 0;
            if (currentTicketCount == 0){
                if (currentIndex == k){
                    return totalTime;
                }
                else if (currentIndex < k){
                    k--;
                }
            }
            else {
                ticketQueue.add(currentTicketCount);
                if (k > 0){
                    k--;
                }
                else if (k == 0){
                    k = ticketQueue.size() - 1;
                }
            }
        }

        return -1;

    }
    public int timeRequiredToBuyQueue3(int[] tickets, int k) {
        Queue<Integer> ticketQueue = Arrays.stream(tickets).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        int totalTime = 0;
        int currentIndex = 0;
        while (!ticketQueue.isEmpty()) {

            if (ticketQueue.peek() != 0) {
                int currentTicketCount = ticketQueue.poll()-1;
                ticketQueue.add(currentTicketCount);
                totalTime++;
                if (currentIndex==k && currentTicketCount==0){
                    break;
                }
            } else {
                ticketQueue.add(ticketQueue.poll());
            }

            currentIndex++;
            if (currentIndex == tickets.length) {
                currentIndex = 0;
            }
        }

        return totalTime;
    }
    public int timeRequiredToBuyQueue4(int[] tickets, int k) {// run time 27 sn
        Deque<Integer> numbers= new ArrayDeque<>();
        for (int i = 0; i < tickets.length; i++) {
            numbers.add(tickets[i]);
        }
        int count=0;
        int counter=0;

        while(count<10000){

            if(counter%numbers.size()==k && numbers.peek()==1) {
                return ++count;
            }
            if(numbers.peek()>0){
                numbers.add(numbers.pop()-1);
                count++;
                counter++;
            } else if(numbers.peek()==0){
                numbers.add(numbers.pop());
                counter++;
            }

        }
        return count;
    }
    public int timeRequiredToBuyQueue5(int[] tickets, int k) {//24 ms
        Queue<Integer> q = new LinkedList<>();
        int count  = 0;
        for(int i=0;i<tickets.length;i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            ++count;
            int front = q.poll();
            if(tickets[front] >= 1){
                tickets[front] -= 1;
            }
            if(k != front && tickets[front] == 0) continue;
            if(k == front && tickets[front] == 0) break;
            q.add(front);
        }

        return count;
    }
    public int timeRequiredToBuyQueue6(int[] tickets, int k) {//23 ms
        Queue<Integer> ticketQueue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < tickets.length; i++) {
            ticketQueue.add(i);
        }
        while(!ticketQueue.isEmpty()) {
            count++;
            int first = ticketQueue.poll();
            if(tickets[first] >= 1) {
                tickets[first] -= 1;
            }
            if(first != k && tickets[first] == 0)  continue;
            if(tickets[first] == 0 && first == k)  break;
            ticketQueue.add(first);
        }
        return count;
    }


}
