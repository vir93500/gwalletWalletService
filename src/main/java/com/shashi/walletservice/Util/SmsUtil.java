package com.shashi.walletservice.Util;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

public class SmsUtil {

    private static final String apiKey="wQTlRzCc5ra0xtAehsYNkd4yWPv93jDK1EVnBmg7Xb6MSfu8JUtNJTQX5rYeK9GyuRFdBpahDEVc3vfL";
    private static final String sendId="FSTSMS";
    private static final String language="english";
    private static final String route="p";
    public static int sendSms(String message,String senderNumber) {

        try {
            message= URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        final String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+senderNumber;

        HttpResponse response = null;
        try {
            response = Unirest.get(myUrl)
                    .header("cache-control", "no-cache")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        System.out.println(response.getBody());
         System.out.println(response.getHeaders());
           return response.getStatus();




       /* System.out.println("I am fine");
        HttpResponse response = Unirest.get("https://www.fast2sms.com/dev/bulk?authorization=64tJZ9QjIHos8cEe70agdDiM2mBFSNvAwp1LfVTbrlPWOqXKkULu20KyCJjAH9vcsTOp4V6k83SfbrgW&sender_id=FSTSMS&message=This%20is%20a%20test%20message&language=english&route=p&numbers=8447172062")
                .header("cache-control", "no-cache")
                .asString();
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());*/

    }
/*
   public static void main(String[] args) throws URISyntaxException, UnirestException {

    }*/
}
