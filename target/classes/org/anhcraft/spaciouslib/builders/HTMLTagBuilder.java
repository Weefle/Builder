package org.anhcraft.spaciouslib.builders;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HTMLTagBuilder {
    private HTMLTagBuilder previous;
    private String name;
    private HashMap<String, String> attributes = new HashMap<>();
    private LinkedList<Object> content = new LinkedList<>();
    private boolean special;

    /**
     * Creates a new HTML tag
     * @param name the tag's name
     */
    public HTMLTagBuilder(String name){
        this.name = name;
        this.special = name.equalsIgnoreCase("area")
                || name.equalsIgnoreCase("base")
                || name.equalsIgnoreCase("br")
                || name.equalsIgnoreCase("col")
                || name.equalsIgnoreCase("command")
                || name.equalsIgnoreCase("embed")
                || name.equalsIgnoreCase("hr")
                || name.equalsIgnoreCase("img")
                || name.equalsIgnoreCase("input")
                || name.equalsIgnoreCase("keygen")
                || name.equalsIgnoreCase("link")
                || name.equalsIgnoreCase("menuitem")
                || name.equalsIgnoreCase("meta")
                || name.equalsIgnoreCase("param")
                || name.equalsIgnoreCase("source")
                || name.equalsIgnoreCase("track")
                || name.equalsIgnoreCase("wbr");
    }

    /**
     * Adds a non-value attribute
     * @param name the attribute's name
     * @return this object
     */
    public HTMLTagBuilder attr(String name){
        attributes.put(name, null);
        return this;
    }

    /**
     * Adds an attribute
     * @param name the attribute's name
     * @param value the attribute's value
     * @return this object
     */
    public HTMLTagBuilder attr(String name, String value){
        attributes.put(name, value);
        return this;
    }

    /**
     * Appends a raw text into this tag
     * @param text a text
     * @return this object
     */
    public HTMLTagBuilder text(String text){
        content.add(text.replace("<", "&lt;").replace(">", "&gt;"));
        return this;
    }

    /**
     * Appends a HTML code into this tag
     * @param html a HTML code
     * @return this object
     */
    public HTMLTagBuilder html(String html){
        content.add(html);
        return this;
    }

    /**
     * Appends a HTMLTagBuilder object into this tag
     * @param htmlTagBuilder a HTMLTagBuilder object
     * @return this object
     */
    public HTMLTagBuilder html(HTMLTagBuilder htmlTagBuilder) {
        content.add(htmlTagBuilder);
        return this;
    }

    /**
     * Creates a new tag, appends it then accesses it
     * @param name the tag's name
     * @return the tag's HTMLTagBuilder object
     */
    public HTMLTagBuilder tag(String name) {
        HTMLTagBuilder htmlTagBuilder = new HTMLTagBuilder(name);
        content.add(htmlTagBuilder);
        htmlTagBuilder.previous = this;
        return htmlTagBuilder;
    }

    /**
     * Backs to the previous builder
     * @return the previous HTMLTagBuilder object
     */
    public HTMLTagBuilder back(){
        return previous;
    }

    /**
     * Builds this tag and its children into complete HTML code
     * @return HTMl code
     */
    public String build(){
        StringBuilder html = new StringBuilder("<" + name);
        for(Map.Entry<String, String> attr: attributes.entrySet()){
            html.append(" ").append(attr.getKey()).append("=");
            if(attr.getValue() != null){
                html.append('"').append(attr.getValue()).append('"');
            }
        }
        if(special) {
            html.append(" />");
        } else {
            html.append(">");
            for(Object tag : content) {
                if(tag instanceof String) {
                    html.append(tag);
                } else if(tag instanceof HTMLTagBuilder) {
                    html.append(((HTMLTagBuilder) tag).build());
                }
            }
            html.append("</").append(name).append(">");
        }
        return html.toString();
    }
}
