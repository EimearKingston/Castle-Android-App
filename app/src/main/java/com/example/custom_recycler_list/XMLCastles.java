package com.example.custom_recycler_list;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLCastles {
    //private Castle[] castles;
    private ArrayList<Castle> castles;
    private Context context;

    public XMLCastles(Context context){
        this.context=context;
        this.castles = new ArrayList<>();

        //make an inputstream,docbuilder and xmldoc
        InputStream stream = null;
        DocumentBuilder builder = null;
        Document xmldoc = null;

        //file located to sdcard
//        try{
//            String filePath = Environment.getExternalStorageDirectory().getPath()+"/landmarks.xml";
//            stream = new FileInputStream(filePath);
//            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            xmldoc = builder.parse(stream);
//        }catch(Exception e){
//
//        }
        try{
            //file located to resource raw
            stream = this.context.getResources().openRawResource(R.raw.castles);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = builder.parse(stream);
        }catch(Exception e){

        }

        //slice xmldoc into 4 nodelists
        NodeList nameList = xmldoc.getElementsByTagName("name");
        NodeList descriptionList = xmldoc.getElementsByTagName("description");
        NodeList imageList = xmldoc.getElementsByTagName("image");
        NodeList urlList = xmldoc.getElementsByTagName("url");
        NodeList countyList = xmldoc.getElementsByTagName("county");
        NodeList provinceList = xmldoc.getElementsByTagName("province");
        NodeList latitudeList = xmldoc.getElementsByTagName("latitude");
        NodeList longitudeList = xmldoc.getElementsByTagName("longitude");
        NodeList yearList = xmldoc.getElementsByTagName("year");

        //traverse these lists
        for (int i = 0; i < nameList.getLength(); i++) {
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String description = descriptionList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();
            String county = countyList.item(i).getFirstChild().getNodeValue();
            String province = provinceList.item(i).getFirstChild().getNodeValue();
            int year = Integer.parseInt(yearList.item(i).getFirstChild().getNodeValue());
            double latitude = Double.parseDouble(latitudeList.item(i).getFirstChild().getNodeValue());
            double longitude = Double.parseDouble(longitudeList.item(i).getFirstChild().getNodeValue());

            castles.add(new Castle(name, image, description, url, latitude, longitude, county, province, year));
        }
//        this.castles = new Castle[nameList.getLength()];
//        for(int i=0;i<nameList.getLength();i++){
//            String name = nameList.item(i).getFirstChild().getNodeValue();
//            String image = imageList.item(i).getFirstChild().getNodeValue();
//            String description = descriptionList.item(i).getFirstChild().getNodeValue();
//            String url = urlList.item(i).getFirstChild().getNodeValue();
//            String county = countyList.item(i).getFirstChild().getNodeValue();
//            String province = provinceList.item(i).getFirstChild().getNodeValue();
//            double latitude = Double.parseDouble(latitudeList.item(i).getFirstChild().getNodeValue());
//            double longitude = Double.parseDouble(longitudeList.item(i).getFirstChild().getNodeValue());
//            this.castles[i] = new Castle(name, image, description, url, latitude, longitude, county, province);
//        }

    }

    public int getCount(){return this.castles.size();}
    public Castle getCastle(int index){return this.castles.get(index);}

    public String [] getNames(){
        String [] names = new String[this.getCount()];
        for(int i=0;i<getCount();i++){
            names[i]=getCastle(i).getName();
        }
        return names;

    }
    public ArrayList<Castle> getCastles() {
        return this.castles;
    }


    public void sortProvince(){
        Collections.sort(castles, new Comparator<Castle>(){
            @Override
            public int compare(Castle castle1, Castle castle2){
                return castle1.getProvince().compareTo(castle2.getProvince());            }
        });

    }
    public void sortByYear() {
        Collections.sort(castles, new Comparator<Castle>() {
            @Override
            public int compare(Castle castle1, Castle castle2) {
                return Integer.compare(castle1.getYear(), castle2.getYear());
            }
        });
    }
    public void sortByYearDesc() {
        Collections.sort(castles, new Comparator<Castle>() {
            @Override
            public int compare(Castle castle1, Castle castle2) {
                return Integer.compare(castle2.getYear(), castle1.getYear());
            }
        });
    }
}
