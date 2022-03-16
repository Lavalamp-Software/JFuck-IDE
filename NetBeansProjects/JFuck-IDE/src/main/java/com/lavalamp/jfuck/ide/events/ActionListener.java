package com.lavalamp.jfuck.ide.events;

import com.lavalamp.jfuck.ide.templates.Listener;
import com.lavalamp.jfuck.ide.templates.Widget;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shabman avia.shabbyman@gmail.com
 */
public class ActionListener {
    
    private static final List<Widget> widgets = new ArrayList<>();
    private static final List<Listener> listeners = new ArrayList<>();
    
    public ActionListener() {
        
    }
    
    public static void addWidgetListener(Widget w) {
        widgets.add(w);
    }
    
    public static void addListener(Listener c) {
        listeners.add(c);
    }
    
    public void fireListener() {
        listeners.forEach(e -> {
            e.onAction();
            e.onActionFired(this);
            e.addCallback(Listener::onActionEnd);
        });
    }
    
    public void fireWidgetProperty(String event) {
        switch (event.toLowerCase()) {
            case "create" -> widgets.forEach(Widget::create);
            case "pause" -> widgets.forEach(Widget::pause);
            case "close" -> widgets.forEach(Widget::close);
        }
    }
    
    public void fireWidgetPropertyClass(Widget c, String event) {
        switch (event.toLowerCase()) {
            case "create" -> c.create();
            case "pause" -> c.pause();
            case "close" -> c.close();
        }
    }
}
