package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.List;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Shobhit
 */
public class StreamStocksMessage {
    private ArrayList <String> _symbols;

    public ArrayList <String> getSymbols() { return _symbols; }

    public short Count() { return (_symbols == null) ? (short) 0 :  (short) _symbols.size(); }

    public void Add(String symbol)
    {
        if (_symbols==null) _symbols = new ArrayList<>();

        if (symbol !=null && !symbol.isEmpty() &&  !symbol.trim().isEmpty())
            _symbols.add(symbol);
    }

    public byte[] Encode()
    {
        ByteBuffer buffer = ByteBuffer.allocate(2 + Count()*6).order(ByteOrder.BIG_ENDIAN);


        if (_symbols != null)
        {
            buffer.putShort(Count());

            for (String symbol : _symbols)
            {
                try{
                   String paddedSymbol = HelperFunctions.padRight(symbol,6);
                    byte[] bytes = paddedSymbol.getBytes(StandardCharsets.US_ASCII);
                    buffer.put(bytes); 
                }catch (Exception e){
                    continue;
                }
                
            }
        }

        return buffer.array();
    }

    public static StreamStocksMessage Decode(byte[] bytes)
    {
        StreamStocksMessage message = null;

        if (bytes != null && bytes.length >= 2)
        {
            message = new StreamStocksMessage();
            message._symbols = new ArrayList<>();

            ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN);

            int count =  buffer.getShort();

            for (int i = 0; i < count; i++)
            {
                if (buffer.remaining()>=6)
                {
                    byte[] tmp = new byte[6];
                    buffer.get(tmp);
                    String symbol = new String(tmp, 0, 6, StandardCharsets.US_ASCII);
                    if (symbol != null && !symbol.trim().isEmpty()) {
                        message.Add(symbol.trim());
                    } else {
                        message = null;
                        break;
                    }
                }
                else {
                    message = null;
                    break;
                }
            }
        }

        return message;
    }
}
