package org.zwx.delegate.simple;

import org.zwx.delegate.simple.printer.CanonPrinter;
import org.zwx.delegate.simple.printer.EsponPrinter;
import org.zwx.delegate.simple.printer.HPPrinter;

public class App {
    public static void main(String[] args) {

        Printer hp = new PrintController(new HPPrinter());
        Printer canon = new PrintController(new CanonPrinter());
        Printer espon = new PrintController(new EsponPrinter());
        String msg = "hello printer";

        hp.print(msg);
        canon.print(msg);
        espon.print(msg);
    }
}
