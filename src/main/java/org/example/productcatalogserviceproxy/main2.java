package org.example.productcatalogserviceproxy;

import java.util.List;

public class main2 {
    public static void main(String a[]) {
        List<Integer> l1 = List.of(1, 2);
        List<String> l2 = List.of("aaa");
        System.out.println(l1.getClass().getName());
        System.out.println(l2.getClass().getName());
    }
}