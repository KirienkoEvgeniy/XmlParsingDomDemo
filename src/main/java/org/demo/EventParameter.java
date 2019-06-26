package org.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventParameter {

    private int priority;
    private String log_level;
    private String source;

}
