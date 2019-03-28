package org.anhcraft.spaciouslib.utils;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ProxyUtils {
    private static Set<Group<String, Integer>> list = new HashSet<>();

    static {
        put("194.126.183.141",53281);
        put("177.204.85.203",80);
        put("80.211.189.165",3128);
        put("147.135.210.114",54566);
        put("124.158.4.3",8080);
        put("192.116.142.153",8080);
        put("185.85.21.6",53281);
        put("185.93.3.123",8080);
        put("113.161.173.10",3128);
        put("5.197.183.222",8080);
        put("152.231.81.122",53281);
        put("94.130.14.146",31288);
    }

    public static Set<Group<String, Integer>> getAll(){
        return list;
    }

    public static void remove(String address, int port){
        Group<String, Integer> group = new Group<>(address, port);
        list.remove(group);
    }

    public static void put(String address, int port){
        Group<String, Integer> group = new Group<>(address, port);
        list.add(group);
    }

    public static Proxy getRandom(Proxy.Type type){
        if(list.size() == 0){
            return null;
        }
        Group<String, Integer> proxy = RandomUtils.pickRandom(new ArrayList<>(list));
        return new Proxy(type, new InetSocketAddress(proxy.getA(), proxy.getB()));
    }
}
