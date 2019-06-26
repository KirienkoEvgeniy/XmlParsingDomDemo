package org.demo;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Event {

    private String event_id;
    private String event_date;
    private List<EventParameter> eventParameter = new ArrayList<>();

}
