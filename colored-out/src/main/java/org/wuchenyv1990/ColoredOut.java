package org.wuchenyv1990;

import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;

import java.util.function.Function;

/**
 * 按需添加样式
 *
 * @author wuchenyv1990@qq.com
 */
public enum ColoredOut {

    /**
     * 红色
     */
    RED(str -> new Object[]{AnsiColor.RED, str}),

    /**
     * 粗体绿色
     */
    BOLD_GREEN(str -> new Object[]{AnsiColor.GREEN, AnsiStyle.BOLD, str});

    private Function<String, Object[]> elementsfunc;

    ColoredOut(Function<String, Object[]> elementsfunc) {
        this.elementsfunc = elementsfunc;
    }

    public String convert(String str) {
        return str == null
                ? null
                : AnsiOutput.toString(elementsfunc.apply(str));
    }

    public void print(String str) {
        System.out.print(convert(str));
    }

    public void print(boolean b) {
        print(b ? "true" : "false");
    }

    public void print(char c) {
        print(String.valueOf(c));
    }

    public void print(int i) {
        print(String.valueOf(i));
    }

    public void print(long l) {
        print(String.valueOf(l));
    }

    public void print(float f) {
        print(String.valueOf(f));
    }

    public void print(double d) {
        print(String.valueOf(d));
    }

    public void print(Object obj) {
        print(String.valueOf(obj));
    }

    public void println(boolean x) {
        print(x);
        newLine();
    }

    public void println(char x) {
        print(x);
        newLine();
    }

    public void println(int x) {
        print(x);
        newLine();
    }

    public void println(long x) {
        print(x);
        newLine();
    }

    public void println(float x) {
        print(x);
        newLine();
    }

    public void println(double x) {
        print(x);
        newLine();
    }

    public void println(String str) {
        print(str);
        newLine();
    }

    public void println(Object str) {
        print(str);
        newLine();
    }

    private void newLine() {
        System.out.println();
    }

}
