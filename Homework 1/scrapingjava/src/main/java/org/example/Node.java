package org.example;

import java.util.ArrayList;

public class Node {
    String name;
    String enName;
    String phone;
    String email;
    String website;
    String opening_hours;
    String id;
    String lat;
    String lon;
    String religion;

    public Node(String name, String enName, String phone, String email, String website, String opening_hours, String id, String lat, String lon, String religion) {
        this.name = name;
        this.enName = enName;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.opening_hours = opening_hours;
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        if (religion.equals("christian"))
            this.religion = "Христијанство";
        else if (religion.equals("muslim"))
            this.religion = "Ислам";
        else if (religion.isEmpty())
            this.religion = "";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Pipe<StringBuilder, String> makingToString = new Pipe<StringBuilder, String>();
        OptionalFilter optionalFilter = new OptionalFilter();
        MandatoryFilter mandatoryFilter = new MandatoryFilter();

        makingToString.addFilter(optionalFilter);
        makingToString.addFilter(optionalFilter);
        makingToString.addFilter(optionalFilter);
        makingToString.addFilter(optionalFilter);
        makingToString.addFilter(optionalFilter);
        makingToString.addFilter(optionalFilter);
        makingToString.addFilter(optionalFilter);
        makingToString.addFilter(mandatoryFilter);
        makingToString.addFilter(mandatoryFilter);
        makingToString.addFilter(mandatoryFilter);

        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(name);
        arrayList.add(enName);
        arrayList.add(religion);
        arrayList.add(website);
        arrayList.add(opening_hours);
        arrayList.add(phone);
        arrayList.add(email);
        arrayList.add(id);
        arrayList.add(lat);
        arrayList.add(lon);

        sb=makingToString.runFilters(sb,arrayList);

//        sb.append(name).append(",");
//        if (!enName.isEmpty())
//            sb.append(enName).append(",");
//        else sb.append("null").append(",");
//        if (!religion.isEmpty())
//            sb.append(religion).append(",");
//        else sb.append("null").append(",");
//        if (!website.isEmpty())
//            sb.append(website).append(",");
//        else sb.append("null").append(",");
//        if (!opening_hours.isEmpty())
//            sb.append(opening_hours).append(",");
//        else sb.append("null").append(",");
//        if (!phone.isEmpty())
//            sb.append(enName).append(",");
//        else sb.append("null").append(",");
//        if (!email.isEmpty())
//            sb.append(email).append(",");
//        else sb.append("null").append(",");
//        sb.append(id).append(",");
//        sb.append(lat).append(",");
//        sb.append(lon);
        return sb.toString();
    }
}

