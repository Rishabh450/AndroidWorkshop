package com.pcon.androidworkshop;




public class Callbacks implements ICallBack
{
    // instance variables - replace the example below with your own

    int o;
    @Override
    public void callback(int o)
    {
        this.o=o;

        System.out.println(o);

    }

    Bad b = new Bad(this);


}

class Bad {
    ICallBack i;
    Bad(ICallBack i)
    {
        this.i = i;
        Thread t = new Thread(new Runnable(){
            @Override
            public void run()
            {
                for(int i=1;i<10000;i++)
                {
                }
                i.callback(100);
            }
        });
        try {
            t.sleep(5000);
        }
        catch(InterruptedException e)
        {

        }



        t.start();


    }

}

interface ICallBack {
    public void callback(int o);


}
