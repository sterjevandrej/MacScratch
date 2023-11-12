package org.example;

public class MandatoryFilter implements Filter<StringBuilder, String> {

    @Override
    public StringBuilder execute(StringBuilder input, String extra) {
        return input.append(extra).append(",");
    }
}
