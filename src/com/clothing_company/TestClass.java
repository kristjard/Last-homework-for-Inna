package com.clothing_company;

import com.clothing_company.product.Product;
import com.clothing_company.warehouse.Warehouse;

import java.util.HashSet;
import java.util.Set;

public class TestClass {

    public static void main(String[] args) {
        Product ps1 = new Product("sokid", 42);
        Product ps2 = new Product("sokid", 42);
        Product pk1 = new Product("kindad", 10);
        Product pk2 = new Product("kindad", 9);
        Product pm = new Product("mantel", 60);
        Product pp = new Product("püksid", 56);

        System.out.println("ps1 ?= ps1: " + ps1.equals(ps1) );
        System.out.println("ps1 ?= ps2: " + ps1.equals(ps2) );
        System.out.println("pk1 ?= pk2: " + pk1.equals(pk2) );
        Set<Product> productTestSet = new HashSet<Product>();
        System.out.println("lisan ps1: " + productTestSet.add(ps1) );
        System.out.println("lisan ps2: " + productTestSet.add(ps2) );
        System.out.println("otsin nr.42 sokke: "+ productTestSet.contains(new Product("sokid", 42)) );


        Warehouse w = new Warehouse();
        w.receive(ps1, "A");
        w.receive(pk1, "A");
        w.receive(pk2, "B");
        w.receive(ps2, "B");
        w.receive(pm, "B");
        w.receive(pp, "L");
        System.out.println( ps1 + " on laos " + w.getItemCount(ps1) + " tk"); //2tk
        System.out.println( pk1 + " on laos " + w.getItemCount(pk1) + " tk"); //1tk

        Product po1 = new Product("sokid", 42);
        w.receive(po1,"X"); //paneme ikka lattu ka

        // väljastame laost kauba:
        String shelfId = w.dispatchAny(po1);
        if (shelfId != null) {
            System.out.println( "Väljastatud " + po1 + " asukohalt " + shelfId);
        } else {
            System.out.println( "Toodet, " + po1 + ", ei leitud loast");
        }
        // kontrolliks prindime välja laoseisu ja vaatame, kas antud kauba kogus on vähenenud
        System.out.println( ps1 + " on laos " + w.getItemCount(ps1) + " tk"); //2tk ;)

        // kontrollime triibuliste sokkide arvu
        System.out.println(ps2 + " on laos " + w.getProductCount(ps2) + " tk.");
        // nõudlik klient tahab ka tribulisi sokke ps1
        System.out.println(w.dispatchSpecific(ps2));
        // teine nõudlik klient soovib samuti samu sokke aga nüüd need otsas
        System.out.println(w.dispatchSpecific(ps2));

        // kontrolliks prindime ühe korra veel välja laoseisu ja vaatame, kas antud kauba kogus on vähenenud
        System.out.println( ps1 + " on laos " + w.getItemCount(ps1) + " tk"); //0tk

        w.writeToCsv("/home/kristjan/data.txt");





    }
}
