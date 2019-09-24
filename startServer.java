package iotserver;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class startServer {
	static ExecutorService executorService;
	ServerSocket serverSocket;
	List<Client> connections = new Vector<Client>();
	public startServer() {}
	public void start() {
		executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors());
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5000));
		} catch(Exception e) {
			if(!serverSocket.isClosed()) { stop();}
			return;
		}
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("startserver");
			
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						String mess = "[connect" + socket.getRemoteSocketAddress() + 
								": " + Thread.currentThread().getName() + "]";
						System.out.println(mess);
						Client client = new Client(socket);
						connections.add(client);
						System.out.println("num of " + connections.size() + "]");
					} catch (Exception e) {
						if(!serverSocket.isClosed()) { stop();}
						break;
					}
				}
			}
		};
		executorService.submit(runnable);
	}
	
	public void stop() {
		try {
			Iterator<Client> iterator = connections.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			if(serverSocket!=null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			if(executorService!=null && !executorService.isShutdown()) {
				executorService.isShutdown();
			}
		} catch (Exception e) {}
		}
	
	class Client {
		Socket socket;
		
		Client(Socket socket) {
			this.socket = socket;
			trans();
		}
		
		void trans() {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					selctOpt selctopt = new selctOpt(socket);
					selctopt.submitLog ();;
				}
			};
			executorService.submit(runnable);
		}
	}
}
