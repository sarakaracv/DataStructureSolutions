package org.example.groupweeks;

import java.util.HashMap;
import java.util.Map;
public class Portfolio {
    private Map<String, Integer> shares; // data structure to store shares for each stock

        public Portfolio() {
            shares = new HashMap<>();
        }

        public void addShares(String stock, int numShares) {
            if (shares.containsKey(stock)) {
                shares.put(stock, shares.get(stock) + numShares);
            } else {
                shares.put(stock, numShares);
            }
        }

        public double proportion(String stock) {
            int totalShares = 0;
            for (int numShares : shares.values()) {
                totalShares += numShares;
            }
            if (totalShares == 0 || !shares.containsKey(stock)) {
                return 0;
            } else {
                return (double) shares.get(stock) / totalShares;
            }
        }

        // second solution
    private int totalShare;
        private HashMap<String,Integer> stocks= new HashMap<String,Integer>();

        public void addShares2(String stock, int shares){
            Integer currentShares=stocks.get(stock);
            if(currentShares==null) stocks.put(stock,currentShares);
            shares+=shares;
            totalShare++;
        }
        public double proportion2(String stock){
            return stocks.get(stock)/totalShare;
        }
    }