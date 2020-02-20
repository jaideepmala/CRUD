package jaideep.mala.Spring.CRUD.CustomMetric;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomMetricService {

    private final MeterRegistry meterRegistry;
    private Counter createHitCounter;

    public CustomMetricService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        createHitCounter = Counter.builder("create.hit")
                .description("No of Create api hit")
                .register(meterRegistry);

    }
    public void incrementCounter()
    {
        createHitCounter.increment(1.0);
    }
}

