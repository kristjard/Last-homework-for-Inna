package com.clothing_company.warehouse;


import com.clothing_company.product.Product;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Warehouse {
    private static List<Shelf> shelves;

    public Warehouse() {
        shelves = new ArrayList<>();
    }

    public void receive(Product prod, String loc){
        shelves.add(new Shelf(loc, prod));
    }
    public String dispatchSpecific(Product prod){
        for(Shelf i: shelves){
            if(i.getProduct()==prod){
                shelves.remove(i);
                return "Väljastasin triibulise toote nimetusega: 'sokid', suurus = 42 asukohalt " + i.getLoc() +".";
            }
        }
        String ans = String.format("Kahjuks on toode otsas, asendada sarnase tootega püstakust %s.", dispatchAny(prod));

        return ans;
    }
    public String dispatchAny(Product prod){
        for(Shelf i : shelves){
            if(i.getProduct().equals(prod)){
                shelves.remove(i);
                return i.getLoc();
            }
        }
        return null;
    }

    public int getProductCount(Product prod){
        int count = 0;
        for(Shelf i : shelves){
            if(i.getProduct() == prod){
                count += 1;
            }
        }return count;
    }
    public int getItemCount(Product prod) {
        int count = 0;
        for (Shelf j : shelves) {
            if (j.getProduct().equals(prod)) {
                count += 1;

            }
        }
        return count;
    }
    public static void writeToCsv(String filepath){
        File file = new File(filepath);
        try{
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            List<String[]> data = new ArrayList<String[]>();
            for(Shelf i: shelves){
                data.add(new String[]{i.getProduct().toString(),i.getLoc()});
            }
            writer.writeAll(data);
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
