package com.vprooks.urgLibJavaWrapper;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * <i>native declaration : urg_ring_buffer.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class ring_buffer_t extends Structure {
    /**
     * !<  Pointer to the data buffer<br>
     * C type : char*
     */
    public Pointer buffer;
    /**
     * !<  Buffer size
     */
    public int buffer_size;
    /**
     * !<  Index of the first entry of the buffer
     */
    public int first;
    /**
     * !<  Index of the last entry of the buffer
     */
    public int last;

    public ring_buffer_t() {
        super();
    }

    protected List<?> getFieldOrder() {
        return Arrays.asList("buffer", "buffer_size", "first", "last");
    }

    /**
     * @param buffer      !<  Pointer to the data buffer<br>
     *                    C type : char*<br>
     * @param buffer_size !<  Buffer size<br>
     * @param first       !<  Index of the first entry of the buffer<br>
     * @param last        !<  Index of the last entry of the buffer
     */
    public ring_buffer_t(Pointer buffer, int buffer_size, int first, int last) {
        super();
        this.buffer = buffer;
        this.buffer_size = buffer_size;
        this.first = first;
        this.last = last;
    }

    public ring_buffer_t(Pointer peer) {
        super(peer);
    }

    public static class ByReference extends ring_buffer_t implements Structure.ByReference {

    }

    public static class ByValue extends ring_buffer_t implements Structure.ByValue {

    }
}

