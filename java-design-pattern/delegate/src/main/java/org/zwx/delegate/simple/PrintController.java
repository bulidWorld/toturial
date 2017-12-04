package org.zwx.delegate.simple;

public class PrintController implements Printer {

    private Printer actualPrinter;

    public PrintController(Printer actualPrinter) {
        this.actualPrinter = actualPrinter;
    }

    @Override
    public void print(String msg) {
        actualPrinter.print(msg);
    }
}
