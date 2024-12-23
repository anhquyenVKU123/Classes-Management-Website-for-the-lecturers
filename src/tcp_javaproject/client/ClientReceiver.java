package tcp_javaproject.client;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceiver implements Runnable{
    private Socket socket;
    private ClientGUI clientGUI;
    private DataInputStream dis;
    private String message;
    private String imagePath;
    private final String IMAGE_FOLDER = "D://LTM//TCP_JavaProject//src//tcp_javaproject//resources//images//client";
    private final String FILE_FOLDER = "D://LTM//TCP_JavaProject//src//tcp_javaproject//resources//files//client";
    private final String VIDEO_FOLDER = "D://LTM//TCP_JavaProject//src//tcp_javaproject//resources//videos//client";
    private final String AUDIO_FOLDER = "D://LTM//TCP_JavaProject//src//tcp_javaproject//resources//audios//client";
    public ClientReceiver(Socket socket, ClientGUI clientGUI) {
        this.socket = socket;
        this.clientGUI = clientGUI;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public void run() {
        try {
            dis = new DataInputStream(socket.getInputStream());
            while (!socket.isClosed()) {
                String header = dis.readUTF();
                if ("TEXT".equals(header)) {
                    message = dis.readUTF();
                    processMessage(message);

                } else if ("IMAGE".equals(header)) {
                    String imageName = dis.readUTF(); // Image Name 
                    int imageSize = dis.readInt();   // Image Size
                    byte[] imageData = new byte[imageSize];
                    dis.readFully(imageData);    // Read image data
                    processImage(imageName, imageData);
                } else if ("FILE".equals(header)){
                    String fileName = dis.readUTF();
                    int fileLength = dis.readInt();
                    byte[] fileBytes = new byte[fileLength];
                    dis.readFully(fileBytes);
                    processFile(fileName, fileBytes);
                } else if ("VIDEO".equals(header)){
                    String videoName = dis.readUTF();
                    int videoLength = dis.readInt();
                    byte[] videoBytes = new byte[videoLength];
                    dis.readFully(videoBytes);
                    processVideo(videoName, videoBytes);
                } else if ("AUDIO".equals(header)){
                    String audioName = dis.readUTF();
                    int audioLength = dis.readInt();
                    byte[] audioBytes = new byte[audioLength];
                    dis.readFully(audioBytes);
                    processAudio(audioName, audioBytes);
                }
            }
        } catch (IOException e) {
            System.err.println("Error receiving data: " + e.getMessage());
        }
    }
    
    public void processMessage(String message) throws IOException{
        if ("stop".equalsIgnoreCase(message)) {
            clientGUI.appendNotification("Server is stopping...");
            socket.close();
        } else if ("disconnect".equalsIgnoreCase(message)) {
            clientGUI.appendNotification("You are disconnected by the Server!!!");
            socket.close();
        } else if ("restart".equalsIgnoreCase(message)) {
            clientGUI.connect();
        } else {
            String notification = "Server: " + message;
            clientGUI.appendNotification(notification);
        }
    }
    
    public void processImage(String imageName, byte[] imageData){
        try {
            // Lưu file ảnh vào thư mục tạm
            File outputDir = new File(IMAGE_FOLDER);
            if (!outputDir.exists()) outputDir.mkdir();

            File imageFile = new File(outputDir, imageName);
            try (FileOutputStream fos = new FileOutputStream(imageFile)) {
                fos.write(imageData);
            }
            // Add Image name and Image path to clientGUI
            clientGUI.addImage(imageName, imageFile.getAbsolutePath());
            clientGUI.appendNotification("Received image: " + imageName);
        } catch (IOException e) {
            clientGUI.appendNotification("Error saving image: " + e.getMessage());
        }
    }
    
    public void processFile(String fileName, byte[] fileData){
        try {
            // Save file into directory
            File outputDir = new File(FILE_FOLDER);
            if (!outputDir.exists()) outputDir.mkdir();

            File file = new File(outputDir, fileName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(fileData);
            }
            // Add Image name and Image path to clientGUI
            clientGUI.addFile(fileName, file.getAbsolutePath());
            clientGUI.appendNotification("Received file: " + fileName);
        } catch (IOException e) {
            clientGUI.appendNotification("Error saving file: " + e.getMessage());
        }
    }
    
    public void processVideo(String videoName, byte[] videoData){
        try {
            // Save file into directory
            File outputDir = new File(VIDEO_FOLDER);
            if (!outputDir.exists()) outputDir.mkdir();

            File file = new File(outputDir, videoName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(videoData);
            }
            // Add Image name and Image path to clientGUI
            clientGUI.addVideo(videoName, file.getAbsolutePath());
            clientGUI.appendNotification("Received video file: " + videoName);
        } catch (IOException e) {
            clientGUI.appendNotification("Error saving file: " + e.getMessage());
        }
    }
    
    public void processAudio(String audioName, byte[] audioData){
        try {
            // Save file into directory
            File outputDir = new File(AUDIO_FOLDER);
            if (!outputDir.exists()) outputDir.mkdir();

            File file = new File(outputDir, audioName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(audioData);
            }
            // Add Image name and Image path to clientGUI
            clientGUI.addAudio(audioName, file.getAbsolutePath());
            clientGUI.appendNotification("Received audio file: " + audioName);
        } catch (IOException e) {
            clientGUI.appendNotification("Error saving file: " + e.getMessage());
        }
    }
}
