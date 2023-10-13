package com.example.AnalyticsService;

import com.timgroup.statsd.StatsDClient;
import com.timgroup.statsd.NonBlockingStatsDClient;

public class Stats {
    public static void main(String[] args) {
        // Replace with your StatsD server host and port
        String statsDHost = "statsd-host";
        int statsDPort = 8125;

        // Initialize the StatsD client
        StatsDClient statsD = new NonBlockingStatsDClient("my-app", statsDHost, statsDPort);

        // Send a counter metric
        statsD.increment("myapp.page.views");

        // Send a gauge metric
        statsD.recordGaugeValue("myapp.memory.usage", 75);

        // Send a timer metric
        statsD.recordExecutionTime("myapp.request.latency", 500);

        // Close the StatsD client when done
        statsD.close();
    }
}
