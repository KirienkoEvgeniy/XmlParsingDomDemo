package org.demo;
public class EventParameter extends Event {
    private String event_id;
    private String event_date;
    private int priority;
    private String log_level;
    private String source;

    public EventParameter(String event_id, String event_date, int priority, String log_level, String source) {
        this.event_id = event_id;
        this.event_date = event_date;
        this.priority = priority;
        this.log_level = log_level;
        this.source = source;
    }

    public EventParameter() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventParameter{");
        sb.append("event_id='").append(event_id).append('\'');
        sb.append(", event_date='").append(event_date).append('\'');
        sb.append(", priority=").append(priority);
        sb.append(", log_level='").append(log_level).append('\'');
        sb.append(", source='").append(source).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getLog_level() {
        return log_level;
    }

    public void setLog_level(String log_level) {
        this.log_level = log_level;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
