package com.company.xml;

import java.util.Map;

public class ParsableTag {
    //TODO add namespace
    private final String name;
    private final Map<String, ParsableTag> parsableTags;
    private final Map<String, String> parsableAttributes;
    private final boolean text;

    public ParsableTag(String name, Map<String, ParsableTag> parsableTags, Map<String, String> parsableAttributes, boolean text) {
        this.name = name;
        this.parsableTags = parsableTags;
        this.parsableAttributes = parsableAttributes;
        this.text = text;
    }
}
