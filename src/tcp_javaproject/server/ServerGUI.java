package tcp_javaproject.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.SwingUtilities;

public class ServerGUI extends javax.swing.JFrame {
    
    private ServerSocket serverSocket;
    private ExecutorService clientHandlerPool;
    private Socket clientSocket;
    private ClientHandler clientHandler;
    private List<ClientHandler> clientHandlers = new ArrayList<>();
    private Set<String> openedClientWindows = new HashSet<>();
    private ClientChatFrame clientWindow;
    public ServerGUI() {
        initComponents();
    }

    public List<ClientHandler> getClientHandlers() {
        return clientHandlers;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serverLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        portTextfield = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificationFrame = new javax.swing.JTextPane();
        messageTextfield = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        listClientLabel = new javax.swing.JLabel();
        clientComboBox = new javax.swing.JComboBox<>();
        selectedClientLabel = new javax.swing.JLabel();
        selectedClientTextField = new javax.swing.JTextField();
        disconnectButton = new javax.swing.JButton();
        refreshListButton = new javax.swing.JButton();
        openButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        serverLabel.setText("Server");

        portLabel.setText("Port");

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        notificationFrame.setEditable(false);
        jScrollPane1.setViewportView(notificationFrame);

        messageTextfield.setText("Enter the message to send to all clients");

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        listClientLabel.setText("List of Clients :");

        clientComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientComboBoxActionPerformed(evt);
            }
        });

        selectedClientLabel.setText("The selected Client :");

        selectedClientTextField.setText("Client 1");
        selectedClientTextField.setEnabled(false);

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        refreshListButton.setText("Refresh List");
        refreshListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshListButtonActionPerformed(evt);
            }
        });

        openButton.setText("Open in New Window");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(498, 498, 498)
                        .addComponent(serverLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(portLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(portTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(startButton)
                        .addGap(18, 18, 18)
                        .addComponent(stopButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(messageTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listClientLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectedClientLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectedClientTextField)
                    .addComponent(clientComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(disconnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openButton, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(serverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portLabel)
                    .addComponent(portTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton)
                    .addComponent(stopButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listClientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(clientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectedClientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedClientTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(disconnectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshListButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(openButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(messageTextfield))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        startServer();
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        stopServer();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void clientComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientComboBoxActionPerformed
        selecteClient();
    }//GEN-LAST:event_clientComboBoxActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        sendToAllClients();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        disconnectClient();
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void refreshListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshListButtonActionPerformed
        refreshListOfClient();
    }//GEN-LAST:event_refreshListButtonActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        openClientChat();
    }//GEN-LAST:event_openButtonActionPerformed

    public void startServer() {
        String portText = portTextfield.getText().trim();
        if (!isPortValid(portText)) {
            appendNotification("Invalid port. Please enter a number between 1 and 65535.");
            return;
        }
        int port = Integer.parseInt(portText);
        try {
            serverSocket = new ServerSocket(port);
            clientHandlerPool = Executors.newFixedThreadPool(10); // Handle up to 10 clients concurrently
            appendNotification("Server started on port " + port);
            stopButton.setEnabled(true);
            startButton.setEnabled(false);

            // Accept clients in a new thread
            new Thread(() -> {
                try {
                    while (!serverSocket.isClosed()) {
                        Socket clientSocket = serverSocket.accept();
                        ClientHandler clientHandler = new ClientHandler(clientSocket, this, clientWindow);
                        synchronized (clientHandlers) {
                            clientHandlers.add(clientHandler);
                        }
                        clientHandlerPool.submit(clientHandler);
                        if (startButton.isEnabled()) clientHandler.sendMessage("restart");
                        appendNotification("Client connected: " + clientSocket.getPort());
                    }
                } catch (IOException e) {
                    if (!serverSocket.isClosed()) {
                        appendNotification("Error accepting client: " + e.getMessage());
                    }
                }
            }).start();
        } catch (IOException e) {
            appendNotification("Error starting server: " + e.getMessage());
        }
    }
    
    public void stopServer() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) serverSocket.close();
            synchronized (clientHandlers) {
                for (ClientHandler clientHandler : clientHandlers) {
                    clientHandler.sendMessage("stop");
                    clientHandler.disconnectClient();
                }
                clientHandlers.clear();
            }
            if (clientHandlerPool != null && !clientHandlerPool.isShutdown()) {
                clientHandlerPool.shutdown();
            }
            appendNotification("Server stopped.");
            stopButton.setEnabled(false);
            startButton.setEnabled(true);
        } catch (IOException e) {
            appendNotification("Error stopping server: " + e.getMessage());
        }
    }
    
    public synchronized void addClientToComboBox(String clientName) {
        SwingUtilities.invokeLater(() -> {
            clientComboBox.addItem(clientName);
        });
    }
    
    public synchronized void removeClientHandler(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
    }
    
    public synchronized void removeClientFromComboBox(String clientName) {
        SwingUtilities.invokeLater(() -> {
            clientComboBox.removeItem(clientName);
            appendNotification(clientName + " has disconnected.");
        });
        // Find and delete
        synchronized (clientHandlers) {
            clientHandlers.removeIf(handler -> handler.getClientName().equals(clientName));
        }
    }
    
    public synchronized void selecteClient() {
        String selectedClient = (String) clientComboBox.getSelectedItem();
        if (selectedClient != null) {
            selectedClientTextField.setText(selectedClient);
        }
    }
    
    public synchronized void sendToAllClients() {
        String message = messageTextfield.getText().trim();
        if (message.isEmpty()) {
            appendNotification("Cannot send empty message.");
            return;
        }
        synchronized (clientHandlers) {
            for (ClientHandler clientHandler : clientHandlers) {
                clientHandler.sendMessage(message);
            }
        }
        messageTextfield.setText("");
        appendNotification("Server: " + message);
    }
    
    public boolean isPortValid(String portText) {
        try {
            int port = Integer.parseInt(portText);
            return port > 0 && port <= 65535;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public synchronized void appendNotification(String message) {
        SwingUtilities.invokeLater(() -> {
            notificationFrame.setText(notificationFrame.getText() + message + "\n");
        });
    }
    
    public ClientHandler findTheSelectedClient(String clientName, List<ClientHandler> clientHandlers){
        synchronized (clientHandlers) {
            for (ClientHandler clientHandler : clientHandlers) {
                if (clientHandler.getClientName().equals(clientName)) {
                    return clientHandler;
                }
            }
        }
        return null;
    }
    
    public void disconnectClient(){
        String selectedClient = (String) clientComboBox.getSelectedItem();
        if (selectedClient == null) {
            appendNotification("No client selected to disconnect.");
            return;
        }
        ClientHandler handlerToDisconnect = findTheSelectedClient(selectedClient, this.getClientHandlers());
        if (handlerToDisconnect != null) {
            handlerToDisconnect.sendMessage("disconnect");
            handlerToDisconnect.disconnectClient();
            removeClientFromComboBox(selectedClient);
        } else {
            appendNotification("No client found to disconnect.");
        }                
    }
    
    public void refreshListOfClient(){
        // Tạo danh sách tạm để lưu các client đang hoạt động
        List<ClientHandler> activeClients = new ArrayList<>();

        // Kiểm tra từng client handler trong danh sách
        for (ClientHandler clientHandler : clientHandlers) {
            if (clientHandler.isConnected()) {
                activeClients.add(clientHandler);
            }
        }
        // Cập nhật danh sách clientHandlers với danh sách mới
        clientHandlers.clear();
        clientHandlers.addAll(activeClients);

        // Cập nhật combobox với danh sách client đang hoạt động
        clientComboBox.removeAllItems(); // Xóa tất cả các mục hiện tại
        for (ClientHandler clientHandler : clientHandlers) {
            clientComboBox.addItem(clientHandler.getClientName()); // Thêm tên client vào combobox
    }

        // Thông báo cập nhật danh sách
        appendNotification("List of connected clients has been refreshed.");
    }
    
    public void openClientChat(){
        String selectedClient = (String) clientComboBox.getSelectedItem();
        if (selectedClient == null) {
            appendNotification("No client selected to open in new window.");
            return;
        }
        if (openedClientWindows.contains(selectedClient)) {
            appendNotification("You opened window for " + selectedClient);
            return;
        }
        ClientHandler handlerToOpen = findTheSelectedClient(selectedClient, this.getClientHandlers());
        if (handlerToOpen != null && handlerToOpen.isConnected()){
            handlerToOpen.openInNewWindow(selectedClient);
            openedClientWindows.add(selectedClient);
        } else {
            appendNotification("No client found to open in new window");
        }
    }
    
    public void closeClientChat(String clientName) {
        if (openedClientWindows.contains(clientName)) {
            openedClientWindows.remove(clientName);
            appendNotification("Cửa sổ chat của client " + clientName + " đã được đóng.");
        }
    }
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new ServerGUI().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> clientComboBox;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listClientLabel;
    private javax.swing.JTextField messageTextfield;
    private javax.swing.JTextPane notificationFrame;
    private javax.swing.JButton openButton;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portTextfield;
    private javax.swing.JButton refreshListButton;
    private javax.swing.JLabel selectedClientLabel;
    private javax.swing.JTextField selectedClientTextField;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel serverLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables

}
