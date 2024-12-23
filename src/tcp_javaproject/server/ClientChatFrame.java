package tcp_javaproject.server;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import tcp_javaproject.ImageView;

public class ClientChatFrame extends javax.swing.JFrame {
    
    private ClientHandler clientHandler;
    private List<ClientHandler> clientHandlers = new ArrayList<>();
    private ServerGUI serverGUI;
    private String clientName;
    public Map<String, String> imageMap = new HashMap<>();
    private Map<String, String> fileMap = new HashMap<>();
    private Map<String, String> videoMap = new HashMap<>();
    private Map<String, String> audioMap = new HashMap<>();

    
    public ClientChatFrame(ServerGUI serverGUI) {
        this.serverGUI = serverGUI;
        initComponents();
    }
        
    public void setNameClientLabel(String nameClientLabel) {
        this.nameClientLabel.setText(nameClientLabel);
    }

    public JLabel getNameClientLabel() {
        return nameClientLabel;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sendButton = new javax.swing.JButton();
        nameClientLabel = new javax.swing.JLabel();
        messageTextfield = new javax.swing.JTextField();
        optionsComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatFrame = new javax.swing.JTextPane();
        imagesLabel = new javax.swing.JLabel();
        imagesComboBox = new javax.swing.JComboBox<>();
        filesLabel = new javax.swing.JLabel();
        filesComboBox = new javax.swing.JComboBox<>();
        videosLabel = new javax.swing.JLabel();
        videosComboBox = new javax.swing.JComboBox<>();
        audiosLabel = new javax.swing.JLabel();
        audiosComboBox = new javax.swing.JComboBox<>();
        recordButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        messageTextfield.setText("Enter the text ...");

        optionsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "File", "Video", "Record", "Image" }));
        optionsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsComboBoxActionPerformed(evt);
            }
        });

        chatFrame.setEditable(false);
        jScrollPane1.setViewportView(chatFrame);

        imagesLabel.setText("Images:");

        imagesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagesComboBoxActionPerformed(evt);
            }
        });

        filesLabel.setText("Files:");

        filesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filesComboBoxActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(messageTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optionsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagesLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagesComboBox, 0, 169, Short.MAX_VALUE)
                            .addComponent(filesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(videosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(audiosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filesLabel)
                                    .addComponent(videosLabel)
                                    .addComponent(audiosLabel)
                                    .addComponent(recordButton))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(nameClientLabel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(nameClientLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(videosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(videosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(audiosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(audiosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageTextfield)
                    .addComponent(optionsComboBox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(recordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        sendText();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void optionsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsComboBoxActionPerformed
        selectOption();
    }//GEN-LAST:event_optionsComboBoxActionPerformed

    private void imagesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagesComboBoxActionPerformed
        String selectedImageName = (String) imagesComboBox.getSelectedItem();
        if (selectedImageName != null) {
            // Lấy đường dẫn đầy đủ từ Map
            String selectedImagePath = imageMap.get(selectedImageName);
            if (selectedImagePath != null) {
                // Hiển thị ảnh trong ImageView
                showImage(selectedImagePath);
            } else {
                appendNotification("Image path not found for: " + selectedImageName);
            }
        }
    }//GEN-LAST:event_imagesComboBoxActionPerformed

    private void filesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filesComboBoxActionPerformed
        String selectedFileName = (String) filesComboBox.getSelectedItem();
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
    }//GEN-LAST:event_filesComboBoxActionPerformed

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

    public void appendNotification(String message){
        SwingUtilities.invokeLater(() -> {
            chatFrame.setText(chatFrame.getText() + message + "\n");
        });
    }
    
    public ClientHandler findClientHandler(){
        clientName = nameClientLabel.getText();
        clientHandlers = serverGUI.getClientHandlers();
        clientHandler = serverGUI.findTheSelectedClient(clientName, clientHandlers);
        return clientHandler;
    }
    
    public void sendText(){
        String message = messageTextfield.getText().trim();
        if (message.isEmpty()){
            appendNotification("Cannot send the empty message!!!");
        } else {
            clientHandler = findClientHandler();
            if (clientHandler == null){
                appendNotification("Client not found or disconnected. Cannot send message.");
                return;
            }
            clientHandler.sendMessageToSelectedClient(message);
            appendNotification("Server : " + message);
            messageTextfield.setText("");
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
                   clientHandler = findClientHandler();
                   clientHandler = serverGUI.findTheSelectedClient(clientName, clientHandlers);
                   clientHandler.sendImageToSelectedClient(selectedFile);
                   appendNotification("Server send the image : " + selectedFile.getName());
               } catch (Exception e) {
                   e.printStackTrace();
                   JOptionPane.showMessageDialog(this, "Error sending file name to client.", "Error", JOptionPane.ERROR_MESSAGE);
               }
           } else {
               JOptionPane.showMessageDialog(this, "Selected file does not exist.", "Warning", JOptionPane.WARNING_MESSAGE);
           }
       }
    }
    
    public void addImage(String imageName, String imagePath){
        imageMap.put(imageName, imagePath);
        imagesComboBox.addItem(imageName);
    }
    
    public void showImage(String imagePath){
        ImageView imageView = new ImageView();
        imageView.displayImage(imagePath);
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
                        clientHandler = findClientHandler();
                        clientHandler = serverGUI.findTheSelectedClient(clientName, clientHandlers);
                        clientHandler.sendFileToSelectedClient(selectedFile);
                        appendNotification("Server sent the file: " + selectedFile.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error sending file to client.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Selected file type is not allowed (image, video, or audio).", "Warning", JOptionPane.WARNING_MESSAGE);
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
    
    public void addFile(String fileName, String filePath){
        fileMap.put(fileName, filePath);
        filesComboBox.addItem(fileName);
    }
    
    public void sendVideo(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("D://LTM//TCP_JavaProject//src//tcp_javaproject//resources//videos"));
        int result = fileChooser.showDialog(this, "Open");
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null && selectedFile.exists()) {
                // Get the file's extension
                String fileName = selectedFile.getName();
                String fileExtension = getFileExtension(fileName);
                if (isVideoFile(fileExtension)){
                    try {
                        clientHandler = findClientHandler();
                        clientHandler = serverGUI.findTheSelectedClient(clientName, clientHandlers);
                        clientHandler.sendVideoToSelectedClient(selectedFile);
                        appendNotification("Server sent the video file: " + selectedFile.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error sending file to client.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else JOptionPane.showMessageDialog(this, "Selected file type is not video.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(this, "Selected file does not exist.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void addVideo(String videoName, String videoPath){
        videoMap.put(videoName, videoPath);
        videosComboBox.addItem(videoName);
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
                        clientHandler = findClientHandler();
                        clientHandler = serverGUI.findTheSelectedClient(clientName, clientHandlers);
                        clientHandler.sendAudioToSelectedClient(selectedFile);
                        appendNotification("Server sent the audio file: " + selectedFile.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error sending file to client.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else JOptionPane.showMessageDialog(this, "Selected file type is not audio.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(this, "Selected file does not exist.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void addAudio(String audioName, String audioPath){
        audioMap.put(audioName, audioPath);
        audiosComboBox.addItem(audioName);
    }
    
    public void selectOption(){
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
    
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ClientChatFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> audiosComboBox;
    private javax.swing.JLabel audiosLabel;
    private javax.swing.JTextPane chatFrame;
    private javax.swing.JComboBox<String> filesComboBox;
    private javax.swing.JLabel filesLabel;
    private javax.swing.JComboBox<String> imagesComboBox;
    private javax.swing.JLabel imagesLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messageTextfield;
    private javax.swing.JLabel nameClientLabel;
    private javax.swing.JComboBox<String> optionsComboBox;
    private javax.swing.JButton recordButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JComboBox<String> videosComboBox;
    private javax.swing.JLabel videosLabel;
    // End of variables declaration//GEN-END:variables
}
