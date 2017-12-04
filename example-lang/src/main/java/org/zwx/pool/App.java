package org.zwx.pool;


public class App {

    public static void main(String[] args)
    {
        SimplePool pool = SimplePool.getInstance();
        Process process = null;
        try {
            process = pool.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            pool.retunObject(process);
        }

    }
}
