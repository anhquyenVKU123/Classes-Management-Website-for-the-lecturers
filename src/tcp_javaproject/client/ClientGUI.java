package tcp_javaproject.client;

import java.awt.Desktop;
import java.io.DataOutputStream;
import java.io.File;
import tcp_javaproject.ImageView;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ClientGUI extends javax.swing.JFrame {

    private ImageView imageView;
    private Socket socket;
    private DataOutputStream dos;
    private ClientReceiver clientReceiver;
    private boolean isServerAvailable = false;
    private boolean isShowNotification = false;
    private Thread monitorThread;
    private Thread reconnectThread;
    private volatile boolean running = true;
    private Map<String, String> imageMap = new HashMap<>();
    private Map<String, String> fileMap = new HashMap<>();
    private Map<String, String> videoMap = new HashMap<>();
    private Map<String, String> audioMap = new HashMap<>();
    
    public ClientGUI() {
        initComponents();
        monitorServerConnection();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        clientLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        portTextfield = new javax.swing.JTextField();
        connectServerButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificationFrame = new javax.swing.JTextPane();
        messageTextfield = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        optionsComboBox = new javax.swing.JComboBox<>();
        imgResourceLabel = new javax.swing.JLabel();
        imageComboBox = new javax.swing.JComboBox<>();
        fileResourceLabel = new javax.swing.JLabel();
        fileComboBox = new javax.swing.JComboBox<>();
        videosLabel = new javax.swing.JLabel();
        videosComboBox = new javax.swing.JComboBox<>();
        audiosLabel = new javax.swing.JLabel();
        audiosComboBox = new javax.swing.JComboBox<>();
        recordButton = new javax.swing.JButton();

        jLabel3.setText("List of Clients :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("The selected Client :");

        jTextField4.setText("Client 1");
        jTextField4.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        portLabel.setText("Port");

        connectServerButton.setText("Connect");
        connectServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectServerButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        notificationFrame.setEditable(false);
        jScrollPane1.setViewportView(notificationFrame);

        messageTextfield.setText("Enter the message...");

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        optionsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "File", "Record", "Video", "Image" }));
        optionsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsComboBoxActionPerformed(evt);
            }
        });

        imgResourceLabel.setText("Images:");

        imageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageComboBoxActionPerformed(evt);
            }
        });

        fileResourceLabel.setText("Files:");

        fileComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileComboBoxActionPerformed(evt);
            }
        });

        videosLabel.setText("Videos:");

        videosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videosComboBoxActionPerformed(evt);
            }
        });

        audiosLabel.setText("Audios:");

        audiosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                audiosComboBoxActionPerformed(evt);
            }
        });

        recordButton.setText("Record");
        recordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(portLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(connectServerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(disconnectButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(296, 296, 296)
                            .addComponent(clientLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(messageTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optionsComboBox, 0, 97, Short.MAX_VALUE))
                    .addComponent(imgResourceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fileResourceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fileComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(videosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(audiosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(videosLabel)
                            .addComponent(audiosLabel)
                            .addComponent(recordButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portLabel)
                    .addComponent(portTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectServerButton)
                    .addComponent(disconnectButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(messageTextfield)
                            .addComponent(optionsComboBox)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgResourceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(imageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fileResourceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(videosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(videosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(audiosLabel)
                        .addGap(12, 12, 12)
                        .addComponent(audiosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectServerButtonActionPerformed
        connect();
    }//GEN-LAST:event_connectServerButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        disconnect();
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        sendMessageToServer();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void imageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageComboBoxActionPerformed
        String selectedImageName = (String) imageComboBox.getSelectedItem();
        if (selectedImageName != null) {
            // Lấy đường dẫn đầy đủ từ Map
            String selectedImagePath = imageMap.get(selectedImageName);
            if (selectedImagePath != null) {
                // Hiển thị ảnh trong ImageFrame
                showImage(selectedImagePath);
            } else {
                appendNotification("Image path not found for: " + selectedImageName);
            }
        }
    }//GEN-LAST:event_imageComboBoxActionPerformed

    private void optionsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsComboBoxActionPerformed
        selectOptions();
    }//GEN-LAST:event_optionsComboBoxActionPerformed

    private void fileComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileComboBoxActionPerformed
        String selectedFileName = (String) fileComboBox.getSelectedItem();
        if (selectedFileName != null) {
            String selectedFilePath = fileMap.get(selectedFileName);
            if (selectedFilePath != null) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // Thư mục mặc định
                fileChooser.setSelectedFile(new File(selectedFileName));

                int result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File saveFile = fileChooser.getSelectedFile();
                    try {
                        Files.copy(Paths.get(selectedFilePath), saveFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        Desktop.getDesktop().open(saveFile); // Mở file sau khi lưu
                        appendNotification("File saved and opened: " + saveFile.getAbsolutePath());
                    } catch (AccessDeniedException e) {
                        appendNotification("Access denied: " + saveFile.getAbsolutePath());
                    } catch (IOException e) {
                        appendNotification("Error saving file: " + e.getMessage());
                    }
                } else {
                    appendNotification("Save operation canceled.");
                }
            } else {
                appendNotification("File path not found for: " + selectedFileName);
            }
        }
    }//GEN-LAST:event_fileComboBoxActionPerformed

    private void videosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videosComboBoxActionPerformed
        String selectedFileName = (String) videosComboBox.getSelectedItem();
        if (selectedFileName != null) {
            String selectedFilePath = videoMap.get(selectedFileName);
            if (selectedFilePath != null) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // Thư mục mặc định
                fileChooser.setSelectedFile(new File(selectedFileName));

                int result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File saveFile = fileChooser.getSelectedFile();
                    try {
                        Files.copy(Paths.get(selectedFilePath), saveFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        Desktop.getDesktop().open(saveFile); // Mở file sau khi lưu
                        appendNotification("File saved and opened: " + saveFile.getAbsolutePath());
                    } catch (AccessDeniedException e) {
                        appendNotification("Access denied: " + saveFile.getAbsolutePath());
                    } catch (IOException e) {
                        appendNotification("Error saving file: " + e.getMessage());
                    }
                } else {
                    appendNotification("Save operation canceled.");
                }
            } else {
                appendNotification("File path not found for: " + selectedFileName);
            }
        }
    }//GEN-LAST:event_videosComboBoxActionPerformed

    private void audiosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_audiosComboBoxActionPerformed
        String selectedFileName = (String) audiosComboBox.getSelectedItem();
        if (selectedFileName != null) {
            String selectedFilePath = audioMap.get(selectedFileName);
            if (selectedFilePath != null) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // Thư mục mặc định
                fileChooser.setSelectedFile(new File(selectedFileName));

                int result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File saveFile = fileChooser.getSelectedFile();
                    try {
                        Files.copy(Paths.get(selectedFilePath), saveFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        Desktop.getDesktop().open(saveFile); // Mở file sau khi lưu
                        appendNotification("File saved and opened: " + saveFile.getAbsolutePath());
                    } catch (AccessDeniedException e) {
                        appendNotification("Access denied: " + saveFile.getAbsolutePath());
                    } catch (IOException e) {
                        appendNotification("Error saving file: " + e.getMessage());
                    }
                } else {
                    appendNotification("Save operation canceled.");
                }
            } else {
                appendNotification("File path not found for: " + selectedFileName);
            }
        }
    }//GEN-LAST:event_audiosComboBoxActionPerformed

    private void recordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordButtonActionPerformed
        try {
            // URL của trang web ghi âm
            String url = "https://online-voice-recorder.com/vi/";

            // Kiểm tra xem Desktop API có được hỗ trợ trên hệ thống không
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    // Mở trình duyệt mặc định với URL
                    desktop.browse(new URI(url));
                } else {
                    JOptionPane.showMessageDialog(this, "Browse action is not supported on your system.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Desktop is not supported on your system.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to open the browser: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_recordButtonActionPerformed

    private void monitorServerConnection() {
        monitorThread = new Thread(() -> {
            while (running) {
                try {
                    if (socket != null && socket.isConnected() && !socket.isClosed()) {
                        // Kết nối đang hoạt động
                        isServerAvailable = true;
                    } else {
                        // Kết nối đã ngắt
                        handleServerDisconnected();
                    }
                    Thread.sleep(2000); // Kiểm tra server mỗi 5 giây
                } catch (InterruptedException e) {
                    appendNotification("Monitor thread interrupted.");
                }
            }
        });
        monitorThread.start();
    }

    private void handleServerDisconnected() {   
        if (!isShowNotification){
            appendNotification("Server is unavailable. Trying to reconnect...");
            isShowNotification = true;
        }
        isServerAvailable = false;
        SwingUtilities.invokeLater(() -> {
            connectServerButton.setEnabled(true);  // Bật nút Connect
            disconnectButton.setEnabled(false);   // Tắt nút Disconnect
        });
        reconnectToServer();
    }

    private void reconnectToServer() {
        if (reconnectThread != null && reconnectThread.isAlive()) {
            // Nếu đã có thread reconnect đang chạy, không cần tạo thêm
            return;
        }
        reconnectThread = new Thread(() -> {
            while (!isServerAvailable && running) {
                try {
                    Thread.sleep(2000); // Chờ 5 giây trước khi thử lại
                    appendNotification("Attempting to reconnect to server...");
                    connect();          // Gọi phương thức connect
                } catch (InterruptedException e) {
                    appendNotification("Reconnection thread interrupted.");
                }
            }
            isShowNotification = false;
        });
        reconnectThread.start();
    }

     // Method to handle connection to the server
    public void connect() {
        try {
            int port = Integer.parseInt(portTextfield.getText().trim());  // Get port number from textfield
            socket = new Socket("localhost", port);  // Connect to server
            appendNotification("Successfully connected to the Server."); // Display a successful connection message in the notification frame
            clientLabel.setText("Client - " + socket.getLocalPort());
            this.setTitle("Client - " + socket.getLocalPort());
            
            // Disable the connect button after a successful connection
            SwingUtilities.invokeLater(() -> {
                connectServerButton.setEnabled(false);
                disconnectButton.setEnabled(true); // Enable disconnect button
            });
            clientReceiver = new ClientReceiver(socket,this);
            new Thread(clientReceiver).start();
            
            isServerAvailable = true;
            isShowNotification = false;
        } catch (IOException ex) {
            appendNotification("Error connecting to server: " + ex.getMessage());
            isServerAvailable = false;
            // Not use connectServerButton.setEnable(false) to user can try again
        }
    }
    
     // Method to handle disconnect from the server
    public void disconnect() {
        running = false; // Dừng monitor thread
        try {
            if (socket != null) {
                dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("TEXT"); // Header xác định loại dữ liệu
                dos.writeUTF("DISCONNECT"); // Gửi nội dung tin nhắn
                socket.close();
                appendNotification("Disconnected from server.");
                SwingUtilities.invokeLater(() -> {
                    connectServerButton.setEnabled(true);  // Re-enable connect button
                    disconnectButton.setEnabled(false);  // Disable disconnect button
                });
            }
        } catch (IOException ex) {
            appendNotification("Error disconnecting from server: " + ex.getMessage());
        }
    }
    
     // Method to send a message to the server
    public void sendMessageToServer() {
        try {
            if (socket == null || socket.isClosed()){
                appendNotification("Cannot send the message because of the connection error.");
                reconnectToServer();
                return;
            }
            dos = new DataOutputStream(socket.getOutputStream());
            if (dos != null) {
                String message = messageTextfield.getText().trim();
                if (message.isEmpty()) {
                    appendNotification("Cannot send empty message.");
                    return;
                }
                messageTextfield.setText("");  // Clear the text field
                dos.writeUTF("TEXT"); // Header xác định loại dữ liệu
                dos.writeUTF(message); // Gửi nội dung tin nhắn
                dos.flush();
                appendNotification("You: " + message);
            }
        } catch (IOException ex) {
            appendNotification("Cannot send the message because of the connection error.");
        }
    }
    
    public void sendImage(){
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(imageFilter);

        int result = fileChooser.showDialog(this, "Open");
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null && selectedFile.exists()) {
                try {
                    dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF("IMAGE"); // Header xác định loại dữ liệu
                    dos.writeUTF(selectedFile.getName()); // Gửi tên file

                    byte[] fileBytes = Files.readAllBytes(selectedFile.toPath());
                    dos.writeInt(fileBytes.length); // Gửi độ dài nội dung
                    dos.write(fileBytes); // Gửi nội dung ảnh
                    dos.flush();
                   appendNotification("You send the image : " + selectedFile.getName());
                } catch (Exception e) {
                   e.printStackTrace();
                   JOptionPane.showMessageDialog(this, "Error sending file name to server.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
               JOptionPane.showMessageDialog(this, "Selected file does not exist.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    public void addImage(String imageName, String imagePath){
        imageMap.put(imageName, imagePath); // Lưu vào Map
        imageComboBox.addItem(imageName);
    }
    
    public void showImage(String imagePath){
        imageView = new ImageView();
        imageView.displayImage(imagePath);
    }
    
    public void addFile(String fileName, String filePath){
        fileMap.put(fileName, filePath);
        fileComboBox.addItem(fileName);
    }
    
    public void sendFile(){
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showDialog(this, "Open");
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null && selectedFile.exists()) {
                // Get the file's extension
                String fileName = selectedFile.getName();
                String fileExtension = getFileExtension(fileName);

                // Check if the file is not the image, video or audio file
                if (!isImageFile(fileExtension) && !isVideoFile(fileExtension) && !isAudioFile(fileExtension)) {
                    try {
                        dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF("FILE"); // Header xác định loại dữ liệu
                        dos.writeUTF(selectedFile.getName()); // Gửi tên file

                        byte[] fileBytes = Files.readAllBytes(selectedFile.toPath());
                        dos.writeInt(fileBytes.length); // Gửi độ dài nội dung
                        dos.write(fileBytes); // Gửi nội dung file
                        dos.flush();
                        appendNotification("You sent the file: " + selectedFile.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error sending file to client.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Selected file type is not allowed (image, video, or audio).", 
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selected file does not exist.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    // Method to get file's extension
    private String getFileExtension(String fileName) {
        int index = fileName.lastIndexOf('.');
        return (index > 0 && index < fileName.length() - 1) ? fileName.substring(index + 1).toLowerCase() : "";
    }

    // Method to check if this is a image file
    private boolean isImageFile(String extension) {
        return extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") || extension.equals("gif");
    }

    // Method to check if this is a video file
    private boolean isVideoFile(String extension) {
        return extension.equals("mp4") || extension.equals("avi") || extension.equals("mkv") || extension.equals("mov");
    }

    // Method to check if this is a audio file
    private boolean isAudioFile(String extension) {
        return extension.equals("mp3") || extension.equals("wav") || extension.equals("aac") || extension.equals("flac");
    }
    
    public void addVideo(String videoName, String videoPath){
        videoMap.put(videoName, videoPath);
        videosComboBox.addItem(videoName);
    }
    
    public void sendVideo(){
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showDialog(this, "Open");
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null && selectedFile.exists()) {
                // Get the file's extension
                String fileName = selectedFile.getName();
                String fileExtension = getFileExtension(fileName);
                if (isVideoFile(fileExtension)){
                    try {
                        dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF("VIDEO"); // Header xác định loại dữ liệu
                        dos.writeUTF(selectedFile.getName()); // Gửi tên file

                        byte[] fileBytes = Files.readAllBytes(selectedFile.toPath());
                        dos.writeInt(fileBytes.length); // Gửi độ dài nội dung
                        dos.write(fileBytes); // Gửi nội dung video
                        dos.flush();
                        appendNotification("You sent the video file: " + selectedFile.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error sending file to server.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else JOptionPane.showMessageDialog(this, "Selected file type is not video.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(this, "Selected file does not exist.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void addAudio(String audioName, String audioPath){
        audioMap.put(audioName, audioPath);
        audiosComboBox.addItem(audioName);
    }
    
    public void sendRecord(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("D://LTM//TCP_JavaProject//src//tcp_javaproject//resources//audios"));
        
        int result = fileChooser.showDialog(this, "Open");
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null && selectedFile.exists()) {
                // Get the file's extension
                String fileName = selectedFile.getName();
                String fileExtension = getFileExtension(fileName);
                if (isAudioFile(fileExtension)){
                    try {
                        dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF("AUDIO"); // Header xác định loại dữ liệu
                        dos.writeUTF(selectedFile.getName()); // Gửi tên file

                        byte[] fileBytes = Files.readAllBytes(selectedFile.toPath());
                        dos.writeInt(fileBytes.length); // Gửi độ dài nội dung
                        dos.write(fileBytes); // Gửi nội dung video
                        dos.flush();
                        appendNotification("You sent the audio file: " + selectedFile.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error sending file to server.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else JOptionPane.showMessageDialog(this, "Selected file type is not audio.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(this, "Selected file does not exist.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Method to notify
    public synchronized void appendNotification(String message) {
        SwingUtilities.invokeLater(() -> {
            notificationFrame.setText(notificationFrame.getText() + message + "\n");
        });
    }
    
    public void selectOptions(){
        String selectedOption = optionsComboBox.getSelectedItem().toString();
        switch (selectedOption) {
            case "Image":
                sendImage();
                break;
            case "File":
                sendFile();
                break;
            case "Video":
                sendVideo();
                break;
            case "Record":
                sendRecord();
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public static void main(String args[]) {
        ClientGUI client = new ClientGUI();
        java.awt.EventQueue.invokeLater(() -> {
            client.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> audiosComboBox;
    private javax.swing.JLabel audiosLabel;
    private javax.swing.JLabel clientLabel;
    private javax.swing.JButton connectServerButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JComboBox<String> fileComboBox;
    private javax.swing.JLabel fileResourceLabel;
    private javax.swing.JComboBox<String> imageComboBox;
    private javax.swing.JLabel imgResourceLabel;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField messageTextfield;
    private javax.swing.JTextPane notificationFrame;
    private javax.swing.JComboBox<String> optionsComboBox;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portTextfield;
    private javax.swing.JButton recordButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JComboBox<String> videosComboBox;
    private javax.swing.JLabel videosLabel;
    // End of variables declaration//GEN-END:variables
}
