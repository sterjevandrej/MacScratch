package org.example;

public class OptionalFilter implements Filter<StringBuilder, String> {

    @Override
    public StringBuilder execute(StringBuilder input, String extra) {
        if (!extra.isEmpty())
            return input.append(extra).append(",");
        return input.append("null").append(",");
    }
}
