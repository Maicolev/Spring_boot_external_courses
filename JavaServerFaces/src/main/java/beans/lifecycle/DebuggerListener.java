package beans.lifecycle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class DebuggerListener implements PhaseListener {
    Logger log = LogManager.getRootLogger();

    @Override
    public void afterPhase(PhaseEvent event) {
        if (log.isInfoEnabled()){
            log.info("After phase: " + event.getPhaseId().toString());
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        if (log.isInfoEnabled()){
            log.info("Before phase: " + event.getPhaseId().toString());
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
