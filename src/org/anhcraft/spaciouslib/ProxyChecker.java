package org.anhcraft.spaciouslib;

import org.anhcraft.spaciouslib.utils.Group;
import org.anhcraft.spaciouslib.utils.IOUtils;
import org.anhcraft.spaciouslib.utils.ProxyUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProxyChecker {
    public static void main(String[ ]args){
        List<String> str = new ArrayList<>();
        long cooldown;
        for(Group<String, Integer> proxy : ProxyUtils.getAll()) {
            cooldown = System.currentTimeMillis();
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + UUID.randomUUID().toString().replace("-", "")).openConnection(
                        new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy.getA(), proxy.getB()))
                );
                connection.setConnectTimeout(2000);
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
                connection.setRequestMethod("GET");
                String json = IOUtils.toString(connection.getInputStream());
                System.out.println("Success: \""+proxy.getA()+"\","+proxy.getB());
                str.add("put(\""+proxy.getA()+"\","+proxy.getB()+");");
            } catch(IOException e) {
                System.out.println("Err: \""+proxy.getA()+"\","+proxy.getB());
            }
        }
        System.out.println("==========================================");
        for(String s : str){
            System.out.println(s);
        }
    }
}
