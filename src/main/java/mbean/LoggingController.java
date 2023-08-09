package mbean;

import transformer.StringTransformer;

public class LoggingController implements LoggingControllerMBean {

    @Override
    public boolean isLoggingEnabled() {
        return StringTransformer.isLoggingEnabled();
    }

    @Override
    public void setLoggingEnabled(boolean enabled) {
        StringTransformer.setLoggingEnabled(enabled);
    }
}