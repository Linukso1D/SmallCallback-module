/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.callback;

import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author maxxl
 */
public class HttpServer {

   

    public static class SocketProcessor implements Runnable {

        private Socket s;
        private InputStream is;
        private OutputStream os;

        SocketProcessor(Socket s) throws Throwable {
            this.s = s;
            this.is = s.getInputStream();
            this.os = s.getOutputStream();
        }

	  @Override
        public void run() {
            try {
                readInputHeaders();
			writeResponse("<html><body><form id=\"lol\">\n" +
			  "<input name=\"phone\" />\n" +
			  "<input type=\"submit\" value=\"OK\">\n" +
			  "</form></body></html>");
		    
            } catch (Throwable t) {
                /*do nothing*/
            } finally {
                try {
                    s.close();
                } catch (Throwable t) {
                    /*do nothing*/
                }
            }
            System.err.println("Client processing finished");
        }

        private void writeResponse(String s) throws Throwable {
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Server: Linukso1D_True/ahaa\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + s.length() + "\r\n" +
			  "Access-Control-Allow-Origin: *\r\n" +
                    "Connection: close\r\n\r\n";
            String result = response + s;
            os.write(result.getBytes());
            os.flush();
        }

        private void readInputHeaders() throws Throwable {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while(true) {
		   
                String s = br.readLine();
		    if(s.contains("phone")&&s.contains("GET")&&!s.contains("= "))
		    {
String newS;
int start = s.indexOf("=");
int end = s.indexOf("HTTP");
newS = s.substring(start+1, end);
		    ToForm fr= ToForm.getInstance();
		    Main Ma = Main.getInstanceMain();
		    fr.initState(newS);
		    JList list = Ma.getjList1();
		    list.setModel(fr.GetListModel());
		   
		    
		
		    }
		    if(s == null || s.trim().length() == 0) {
                    break;
                }
            }
        }
    }
}