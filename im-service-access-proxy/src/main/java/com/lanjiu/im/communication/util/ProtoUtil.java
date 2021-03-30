package com.lanjiu.im.communication.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * 8 ==》string
 * @author zha_gtao
 * @data 2020/6/10 10:07
 */
public class ProtoUtil {

    public static void main(String[] args) throws IOException {
        String data="\\351\\273\\204\\346\\273\\241\\350\\213\\261 \\346\\210\\221\\345\\210\\232\\347\\224\\250\\345\\212\\252\\346\\257\\224\\344\\272\\232\\346\\265\\213\\350\\257\\225\\344\\272\\206\\344\\270\\213\\357\\274\\214\\344\\270\\215\\345\\274\\200\\345\\220\\257\\351\\200\\200\\345\\207\\272\\346\\270\\205\\347\\220\\206\\346\\266\\210\\346\\201\\257\\344\\270\\215\\344\\274\\232\\345\\260\\217\\346\\266\\210\\345\\244\\261\\357\\274\\214\\344\\270\\224\\346\\234\\252\\350\\257\\273\\346\\266\\210\\346\\201\\257\\347\\272\\242\\347\\202\\271\\346\\217\\220\\351\\206\\222\\351\\203\\275\\345\\234\\250\\347\\232\\204\\343\\200\\202";
        System.out.println(getOct(data));

    }

    public static String getOct(String s) throws UnsupportedEncodingException {
        String[] as  = s.split("\\\\");
        byte[] arr  = new byte[as.length -1];
        for (int i = 1; i <as.length; i++){
            int sum =0;
            int base = 64;
            for (char c :as[i].toCharArray()){
                sum += base * ((int)c -'0');
                base /= 8;
            }
            if (sum >= 128 ){sum = sum - 256;}
            arr[i-1]  = (byte)sum;
        }
        return  new String(arr,"UTF-8");
    }
}