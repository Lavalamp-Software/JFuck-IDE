package com.lavalamp.jfuck.ide;

import com.lavalamp.jfuck.ide.events.ActionListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URISyntaxException;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shabman avia.shabbyman@gmail.com
 */
public class Launch {
    
    private static final ActionListener al = new ActionListener();
    
    public static void main(String[] args) {
        try {
            URL urlPyPath = ClassLoader.getSystemResource("plugins/rpc/example.py");
            
            ProcessBuilder pb = new ProcessBuilder("python3", urlPyPath.toURI().getPath(), "Idling", System.getProperty("os.name"));
            Process p = pb.start();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            Object ret;
            while ((ret = in.readLine()) != null) {
                System.out.println(ret);
            }
        } catch (IOException | URISyntaxException e) {
            Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, e);
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                al.fireWidgetProperty("close");
                System.out.println("Operation Ended.");
            }
        });
    }
}
