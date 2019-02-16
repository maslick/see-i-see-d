package io.maslick.cicd;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class App {

	private static final Charset CHARSET = StandardCharsets.UTF_8;
	private static final String HEADER_CONTENT_TYPE = "Content-Type";
	private static final int STATUS_OK = 200;


	public static void main(String[] args) throws Exception {
		int port = Integer.parseInt(System.getProperty("port", "8000"));

		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
		server.createContext("/", he -> {
			final Headers headers = he.getResponseHeaders();
			headers.set(HEADER_CONTENT_TYPE, String.format("application/json; charset=%s", CHARSET));

			String payload = "{\"hello\": \"Hello world\"}";
			final byte[] respBody = payload.getBytes(CHARSET);

			he.sendResponseHeaders(STATUS_OK, respBody.length);
			he.getResponseBody().write(respBody);
		});
		server.setExecutor(null);
		server.start();
		System.out.println("Server started on port: " + port);
	}
}