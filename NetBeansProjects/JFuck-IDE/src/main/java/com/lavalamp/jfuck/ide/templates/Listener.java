package com.lavalamp.jfuck.ide.templates;

/**
 *
 * @author shabman avia.shabbyman@gmail.com
 */
public abstract class Listener {
    
    public abstract void onAction();
    
    public abstract void onActionFired(Object sender);
    
    public abstract void onActionEnd();
    
    public void addCallback(ListenerCallback c) {
        c.callback();
    }
    
}
