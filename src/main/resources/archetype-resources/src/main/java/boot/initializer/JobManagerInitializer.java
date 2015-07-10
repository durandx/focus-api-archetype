#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.boot.initializer;

import io.vertigo.core.spaces.component.ComponentInitializer;
import io.vertigo.tempo.job.JobManager;

import javax.inject.Inject;

/**
 * Initialisation du manager des jobs.
 *
 * @author jmforhan
 */
public final class JobManagerInitializer implements ComponentInitializer<JobManager> {

    /**
     * Construit une instance de JobManagerInitializer.
     */
    @Inject
    public JobManagerInitializer() {
        super();
    }

    /** {@inheritDoc} */
    @Override
    public void init(final JobManager manager) {
        // manager.scheduleNow(JobIndexerMovie.getJobDefinition());
        // manager.scheduleNow(JobIndexPeople.getJobDefinition());
    }
}
