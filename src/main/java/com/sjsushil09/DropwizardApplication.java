package com.sjsushil09;

import com.sjsushil09.health.TemplateHealthCheck;
import com.sjsushil09.resources.HelloWorldResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class DropwizardApplication extends Application<DropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropwizardConfiguration configuration,
                    final Environment environment) {
        HelloWorldResource helloWorldResource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        environment.jersey().register(helloWorldResource);


        TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template",healthCheck);
    }

}
