package edu.sun.mb;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-7-1
 * Time: 下午12:04
 * To change this template use File | Settings | File Templates.
 */
public class AppLifyCycle implements PhaseListener {
    public void afterPhase(PhaseEvent phaseEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
        System.out.println("after phase :" + phaseEvent.getPhaseId().toString());
    }

    public void beforePhase(PhaseEvent phaseEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
        System.out.println("after phase :" + phaseEvent.getPhaseId());
    }

    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
