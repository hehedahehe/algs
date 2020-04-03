package com.ruibo.demo.server;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

public class DemoServer {

   private List<Request> requestList = new LinkedList<>();




    public static void start() {

    }

    private  class Handler implements Runnable{

        @Override
        public void run() {
            while (!requestList.isEmpty()){}
        }
    }

    public static class Request {
        private String content;

        public Request(String content) {
            this.content = content;
        }

        public String getContent(){
            return this.content;
        }
    }

}
