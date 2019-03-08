package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import subject.Stock;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Shobhit
 */
public class Communicator {
    private DatagramSocket udpClient ;
    private Socket socket;
    private InetAddress address;
    private boolean isMonitoring;
    private Portfolio userPortFolio;
    private boolean timeOut = false;

    
    public Communicator(Portfolio userFolio){
        this.userPortFolio = userFolio;
    }

    public void start(){
        try {
            String add = "127.0.0.1";
            address = InetAddress.getByName(add);
            udpClient = new DatagramSocket();
            udpClient.setSoTimeout(2000);
            isMonitoring = true;

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        monitoring();

    }

    public void monitoring(){
        StreamStocksMessage startMessage = new StreamStocksMessage();
        for(String symbol: userPortFolio.getSymbols()) {
            startMessage.Add(symbol);
        }
        
        Send(startMessage);
        while (isMonitoring)
        {
            // Try to receive a TickerMessage and pass it onto the Portfolio for procesing.  It will
            // wait 1000 ms before giving up on the receive attempt.  In that caase, the message will
            // be null and the Portfolio.Update method will do nothing.
            try
            {
                TickerMessage message = Receive(1000);
                String symbol = message.getSymbol();
                Stock stock = userPortFolio.getStock(symbol);
                stock.updateStock(message);
            }
            catch (Exception e)
            {
                //JOptionPane.showMessageDialog(null, "No response from server");
            
                //e.printStackTrace();
            }
        }

    }

    public void Stop()
    {
        isMonitoring = false;

        if (udpClient != null)
        {
            udpClient.close();
            udpClient = null;
        }
    }

    private void Send(StreamStocksMessage message)
    {
        if (message == null) return;

        byte[] bytesToSend = message.Encode();
        DatagramPacket packet = new DatagramPacket(bytesToSend, bytesToSend.length,address,12099);//PortNumber

        try
        {
            udpClient.send(packet);
        } 
        catch (Exception err)
        {
           JOptionPane.showMessageDialog(null,"Unknown Error");
        }

        return;
    }


    private TickerMessage Receive(int timeout)
    {
        timeout = 1000;
        TickerMessage message = null;

        byte[] receivedBytes = receiveBytes(timeout);
        if (receivedBytes != null && receivedBytes.length > 0){

            try {
                message = TickerMessage.Decode(receivedBytes);
                
            } catch (IOException e) {
               
                e.printStackTrace();
            }
        }
        return message;
    }


    public byte[] receiveBytes(int timeout){

        byte[] receiveData ;

        receiveData = new byte[42];
        final DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        try {
            udpClient.receive(receivePacket);
        } catch (IOException e) {
             timeOut = true;
             Stop();
        }
        return receivePacket.getData();
    }
    
    public boolean checkForUnknownSymbol(){
        return timeOut == true;
        
    }
    
    public boolean correctIPAddress(String ip){
        return ip == "169.254.56.42" || ip=="169.254.91.179" || ip=="10.0.0.158" ||ip=="169.254.195.23"||ip=="127.0.0.1"||ip=="52.42.233.246";
    }
}
