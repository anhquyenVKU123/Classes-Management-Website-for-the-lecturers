package tcp_javaproject.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ServerGUI serverGUI;
    private String clientName;
    private DataInputStream dis;
    private ClientChatFrame clientWindow;
    private DataOutputStream dos;
    private final String IMAGE_FOLDER = "D://LTM//TCP_JavaProject//src//tcp_javaproject//resources//images//server";
    private final String FILE_FOLDER = "D://LTM//TCP_JavaProject//src//tcp_javaproject//resources//files//server";
    private final String VIDEO_FOLDER = "D://LTM//TCP_JavaProject//src//tcp_javaproject//resources//videos//server";
    private final String AUDIO_FOLDER = "D://LTM//TCP_JavaProject//src//tcp_javaproject//resources//audios//server";

    public String getClientName() {
        return clientName;
    }

    public ClientHandler(Socket clientSocket, ServerGUI serverGUI, ClientChatFrame clientWindow) {
        this.clientSocket = clientSocket;
        this.serverGUI = serverGUI;
        this.clientWindow = clientWindow;
        this.clientName = "Client-" + clientSocket.getPort();
    }

    @Override
    public void run() {
        try {
            serverGUI.addClientToComboBox(clientName);       
            dis = new DataInputStream(clientSocket.getInputStream());
            while (true) {
                String header = dis.readUTF();
                if ("TEXT".equals(header)){
                    String message = dis.readUTF();
                    processMessageFromClient(message);
                } else if ("IMAGE".equals(header)){
                    String imageName = dis.readUTF(); // Image Name 
                    int imageSize = dis.readInt();   // Image Size
                    byte[] imageData = new byte[imageSize];
                    dis.readFully(imageData);    // Read image data
                    processImageFromClient(imageName, imageData);
                } else if ("FILE".equals(header)){
                    String fileName = dis.readUTF();
                    int fileLength = dis.readInt();
                    byte[] fileBytes = new byte[fileLength];
                    dis.readFully(fileBytes);
                    processFileFromClient(fileName, fileBytes);
                } else if ("VIDEO".equals(header)) {
                    String videoName = dis.readUTF();
                    int videoLength = dis.readInt();
                    byte[] videoBytes = new byte[videoLength];
                    dis.readFully(videoBytes);
                    processVideoFromClient(videoName, videoBytes);
                } else if ("AUDIO".equals(header)) {
                    String audioName = dis.readUTF();
                    int audioLength = dis.readInt();
                    byte[] audioBytes = new byte[audioLength];
                    dis.readFully(audioBytes);
                    System.out.print("Audio");
                    processAudioFromClient(audioName, audioBytes);
                } 
            }
        } catch (IOException e) {
            try {
                serverGUI.appendNotification("Disconnected: " + clientName);
                clientSocket.close();
                serverGUI.refreshListOfClient();
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void processMessageFromClient(String message){
        if ("DISCONNECT".equalsIgnoreCase(message)) {
            try {
                clientWindow.appendNotification(clientName + " : has disconnectd");
                clientSocket.close();
                serverGUI.removeClientFromComboBox(clientName);
                return;
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        clientWindow.appendNotification(clientName + " : " + message);
    }
    
    public void processImageFromClient(String imageName, byte[] imageData){
        try {
            // Lưu file ảnh vào thư mục tạm
            File outputDir = new File(IMAGE_FOLDER);
            if (!outputDir.exists()) outputDir.mkdir();

            File imageFile = new File(outputDir, imageName);
            try (FileOutputStream fos = new FileOutputStream(imageFile)) {
                fos.write(imageData);
            }
            // Add Image name and Image path to clientGUI
            clientWindow.addImage(imageName, imageFile.getAbsolutePath());
            clientWindow.appendNotification("Received image: " + imageName);
        } catch (IOException e) {
            clientWindow.appendNotification("Error saving image: " + e.getMessage());
        }
    }
    
    public void processFileFromClient(String fileName, byte[] fileData){
        try {
            // Save file into directory
            File outputDir = new File(FILE_FOLDER);
            if (!outputDir.exists()) outputDir.mkdir();

            File file = new File(outputDir, fileName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(fileData);
            }
 
            clientWindow.addFile(fileName, file.getAbsolutePath());
            clientWindow.appendNotification("Received file: " + fileName);
        } catch (IOException e) {
            clientWindow.appendNotification("Error saving file: " + e.getMessage());
        }
    }
    
    public void processVideoFromClient(String videoName, byte[] videoData){
        try {
            // Save file into directory
            File outputDir = new File(VIDEO_FOLDER);
            if (!outputDir.exists()) outputDir.mkdir();

            File file = new File(outputDir, videoName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(videoData);
            } 
            clientWindow.addVideo(videoName, file.getAbsolutePath());
            clientWindow.appendNotification("Received file: " + videoName);
        } catch (IOException e) {
            clientWindow.appendNotification("Error saving file: " + e.getMessage());
        }
    }
    
    public void processAudioFromClient(String audioName, byte[] audioData){
        try {
            // Save file into directory
            File outputDir = new File(AUDIO_FOLDER);
            if (!outputDir.exists()) outputDir.mkdir();

            File file = new File(outputDir, audioName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(audioData);
            } 
            clientWindow.addAudio(audioName, file.getAbsolutePath());
            clientWindow.appendNotification("Received file: " + audioName);
        } catch (IOException e) {
            clientWindow.appendNotification("Error saving file: " + e.getMessage());
        }
    }
    
    public boolean isConnected() {
        try {
            // Kiểm tra xem socket có thể đọc và không đóng
            return clientSocket != null && !clientSocket.isClosed() && clientSocket.isConnected();
        } catch (Exception e) {
            return false;  // Nếu có ngoại lệ, coi như không còn kết nối
        }
    }

    public void sendMessage(String message){
        try {
            dos = new DataOutputStream(clientSocket.getOutputStream());
            dos.writeUTF("TEXT"); // Header xác định loại dữ liệu
            dos.writeUTF(message); // Gửi nội dung tin nhắn
            dos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessageToSelectedClient(String message){
        if (isConnected()) {
            try {
                dos = new DataOutputStream(clientSocket.getOutputStream());
                dos.writeUTF("TEXT"); // Header xác định loại dữ liệu
                dos.writeUTF(message); // Gửi nội dung tin nhắn
                dos.flush();
            } catch (IOException e) {
                clientWindow.appendNotification("Error sending message: " + e.getMessage());
            }
        } else {
            clientWindow.appendNotification("This client has been disconnected!!!");
        }
    }
    
    public void sendImageToSelectedClient(File imageFile){
        if (isConnected()) {
            try {
                dos = new DataOutputStream(clientSocket.getOutputStream());
                dos.writeUTF("IMAGE"); // Header xác định loại dữ liệu
                dos.writeUTF(imageFile.getName()); // Gửi tên file
                
                byte[] fileBytes = Files.readAllBytes(imageFile.toPath());
                dos.writeInt(fileBytes.length); // Gửi độ dài nội dung
                dos.write(fileBytes); // Gửi nội dung ảnh
                dos.flush();
            } catch (IOException e) {
                clientWindow.appendNotification("Error sending message: " + e.getMessage());
            }
        } else {
            clientWindow.appendNotification("This client has been disconnected!!!");
        }
    }
    
    public void sendFileToSelectedClient(File file){
        if (isConnected()) {
            try {
                dos = new DataOutputStream(clientSocket.getOutputStream());
                dos.writeUTF("FILE"); // Header xác định loại dữ liệu
                dos.writeUTF(file.getName()); // Gửi tên file
                
                byte[] fileBytes = Files.readAllBytes(file.toPath());
                dos.writeInt(fileBytes.length); // Gửi độ dài nội dung
                dos.write(fileBytes); // Gửi nội dung file
                dos.flush();
            } catch (IOException e) {
                clientWindow.appendNotification("Error sending message: " + e.getMessage());
            }
        } else {
            clientWindow.appendNotification("This client has been disconnected!!!");
        }
    }
    
    public void sendVideoToSelectedClient(File file){
        if (isConnected()) {
            try {
                dos = new DataOutputStream(clientSocket.getOutputStream());
                dos.writeUTF("VIDEO"); // Header xác định loại dữ liệu
                dos.writeUTF(file.getName()); // Gửi tên file
                
                byte[] fileBytes = Files.readAllBytes(file.toPath());
                dos.writeInt(fileBytes.length); // Gửi độ dài nội dung
                dos.write(fileBytes); // Gửi nội dung file
                dos.flush();
            } catch (IOException e) {
                clientWindow.appendNotification("Error sending message: " + e.getMessage());
            }
        } else {
            clientWindow.appendNotification("This client has been disconnected!!!");
        }
    }
    
    public void sendAudioToSelectedClient(File file) {
        if (isConnected()) {
            try {
                dos = new DataOutputStream(clientSocket.getOutputStream());
                dos.writeUTF("AUDIO"); // Header xác định loại dữ liệu
                dos.writeUTF(file.getName()); // Gửi tên file
                
                byte[] fileBytes = Files.readAllBytes(file.toPath());
                dos.writeInt(fileBytes.length); // Gửi độ dài nội dung
                dos.write(fileBytes); // Gửi nội dung file
                dos.flush();
            } catch (IOException e) {
                clientWindow.appendNotification("Error sending message: " + e.getMessage());
            }
        } else {
            clientWindow.appendNotification("This client has been disconnected!!!");
        }
    }
    
    public void disconnectClient(){
        try {
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void openInNewWindow(String nameClient){
        clientWindow = new ClientChatFrame(serverGUI);
        clientWindow.setNameClientLabel(nameClient);
        clientWindow.setTitle(clientName);
        clientWindow.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        clientWindow.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
                serverGUI.closeClientChat(clientName);
            }
        });
        clientWindow.setVisible(true);
    }
    
}
