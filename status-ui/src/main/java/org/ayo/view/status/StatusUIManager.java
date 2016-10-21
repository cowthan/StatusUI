package org.ayo.view.status;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class StatusUIManager {

    private Map<String, StatusProvider> map = new HashMap<>();
    private StatusProvider currentStatusProvider;


    public void addStatusProvider(StatusProvider p){
        map.put(p.getStatus(), p);
    }

    public void show(String status){
        if(currentStatusProvider != null) currentStatusProvider.hideStatusView();
        StatusProvider p = map.get(status);
        if(p != null){
            p.showStatusView();
            currentStatusProvider = p;
        }
    }

    public void clearStatus(){
        if(currentStatusProvider != null) {
            currentStatusProvider.hideStatusView();
            currentStatusProvider.showContentView();
        }
    }

}
