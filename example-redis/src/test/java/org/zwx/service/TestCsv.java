package org.zwx.service;

import org.junit.Test;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.CsvListWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestCsv {

    @Test
    public void testFilterInput() {
        try {
            InputStream is = new FileInputStream("D:/test2.csv");
            CsvListReader clr = new CsvListReader(new InputStreamReader(is), CsvPreference.EXCEL_PREFERENCE);

            String[] headers = clr.getHeader(true);
            List<String> li = new ArrayList<>();

            while (clr.read() != null) {

            }

            li.add("2a");
            li.add("3b");
            li.add("22c");
            li.add("11d");
            Iterator<String> it = li.iterator();

            while (it.hasNext()) {
                String s = it.next();
                if (s.startsWith("2")) {
                    it.remove();
                }
            }

            OutputStream out = new ByteArrayOutputStream();
            CsvListWriter clw = new CsvListWriter(new PrintWriter(out), CsvPreference.EXCEL_PREFERENCE);

            clw.write(li);
            clw.flush();

            InputStream is2 = new ByteArrayInputStream(((ByteArrayOutputStream) out).toByteArray());
            CsvListReader clr2 = new CsvListReader(new InputStreamReader(is2), CsvPreference.EXCEL_PREFERENCE);
            List<String> li2 = clr2.read();

            li2.forEach(System.out::println);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
