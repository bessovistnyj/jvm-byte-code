package ru.napadovskiu.parseDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParseDate {

    private Map<String, String> mapMounts = new HashMap<>();


    public ParseDate() {
        this.mapMounts.put("янв","01");
        this.mapMounts.put("фев","02");
        this.mapMounts.put("мар","03");
        this.mapMounts.put("апр","04");
        this.mapMounts.put("май","05");
        this.mapMounts.put("июн","06");
        this.mapMounts.put("июл","07");
        this.mapMounts.put("авг","08");
        this.mapMounts.put("сен","09");
        this.mapMounts.put("окт","10");
        this.mapMounts.put("ноя","11");
        this.mapMounts.put("дек","12");

    }

    public Date getDateFromString(String stringDate) throws ParseException {
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(stringDate.contains("вчера")) {
            result = sdf.parse(sdf.format(new Date()));
        } else if(stringDate.contains("сегодня")) {
            Instant now = Instant.now(); //current date
            Instant before = now.minus(Duration.ofDays(1));

            Date dateBefore = Date.from(before);
            result = sdf.parse(sdf.format(dateBefore));
        } else {

            String sDay = stringDate.substring(0,2);
            String strMounth = stringDate.substring(sDay.length(),sDay.length()+4);
            String sMounth = this.mapMounts.get(strMounth.replaceAll(" ",""));
            String sYear = stringDate.substring(sDay.length()+strMounth.length(),sDay.length()+strMounth.length()+2);
            String strDate = new String(sYear+"-"+sMounth+"-"+sDay);//+" "+sHour+":"+sMin);
            result = sdf.parse(strDate);
        }

        return result;
    }



}
