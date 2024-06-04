package com.java.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiracleFord {

    /**
     * songs sum will be multiple of 60;
     * @param songs
     * @return
     */
    public static long playlist(List<Integer> songs) {
        // Write your code here
        long pairs = 0;
        for (int i=0; i<songs.size(); i++){
            for( int j= i+1; j<songs.size(); j++){
                int sum = songs.get(i)+ songs.get(j);
                if(sum%60==0){
                    pairs = pairs+1;
                }
            }
        }

        return pairs;

    }

    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        // Write your code here
        int retValue=0 ;
        Map<String,Float> priceMap= new HashMap<String,Float>();

        for(int i=0; i<products.size(); i++){
            priceMap.put(products.get(i), productPrices.get(i));
        }

        for(int i=0; i<productSold.size(); i++){
            // if(priceMap.get(productSold.get(i))!=soldPrice.get(i)){
            //     retValue++;
            // }

            if(Float.compare(priceMap.get(productSold.get(i)), soldPrice.get(i))!=0){
                retValue++;
            }
        }


        return retValue;
    }

}
