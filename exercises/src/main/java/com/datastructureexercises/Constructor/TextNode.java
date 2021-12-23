package com.datastructureexercises.Constructor;

import java.util.Arrays;
import java.util.List;

/**
 * @author liutianlong
 */
public class TextNode implements Node {
    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    @Override
    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Node> children() {
        return Arrays.asList();
    }

    @Override
    public String toXml() {
        return text;
    }
}
