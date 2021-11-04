package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetAddress;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {
    @Test
    void main() throws IOException {

        assertEquals(String.valueOf(InetAddress.getLocalHost()),Client.main("WHO"));


    }

}
