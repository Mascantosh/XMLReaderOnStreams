package com.company.xml;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class XmlTag {
    private final String name;
    private final String text;
    private final Map<String, XmlTag> tags;
    private final Map<String, String> attributes;

    public XmlTag(String name) {
        this(name, "");
    }

    public XmlTag(String name, String text) {
        this(name, text, Collections.emptyMap());
    }

    public XmlTag(String name, String text, Map<String, XmlTag> tags) {
        this(name, text, tags, Collections.emptyMap());
    }

    public XmlTag(String name, String text, Map<String, XmlTag> tags, Map<String, String> attributes) {
        this.name = name;
        this.text = text;
        this.tags = tags;
        this.attributes = attributes;
    }

    public Map<String, String> attributes() {
        return attributes;
    }

    public Map<String, XmlTag> tags() {
        return tags;
    }

    public Optional<String> attribute(String name) {
        return Optional.ofNullable(attributes.get(name));
    }

    public Optional<XmlTag> tag(String name) {
        return Optional.ofNullable(tags.get(name));
    }

    public String text() {
        return text;
    }

    public String name() {
        return name;
    }
}
