package main.java.pasksoftware.assigment3;

import java.time.LocalDateTime;

public class Request {
    public final String ip;
    public final LocalDateTime timestamp;
    public final String body;
    private static int requestNumber;

    public Request(String ip, LocalDateTime timestamp) {
        this.ip = ip;
        this.timestamp = timestamp;
        this.requestNumber = requestNumber + 1;
        this.body = String.format("request nr %d", requestNumber);
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "Request{" +
                "ip='" + ip + '\'' +
                ", timestamp=" + timestamp +
                ", body='" + body + '\'' +
                '}';
    }
}
