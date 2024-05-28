package co.inges.redvendedores.model;

import co.inges.redvendedores.persistencia.CSVUtil;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Chat implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String vendedores;
    private String miChat;

    public Chat() {
        super();
    }

    public Chat(String vendedores, String miChat) {
        super();
        this.vendedores = vendedores;
        this.miChat = miChat;
    }

    public String getVendedores() {
        return vendedores;
    }

    public void setVendedores(String vendedores) {
        this.vendedores = vendedores;
    }

    public String getMiChat() {
        return miChat;
    }

    public void setMiChat(String miChat) {
        this.miChat = miChat;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Chat [vendedores=" + vendedores + ", miChat=" + miChat + "]";
    }

    public static List<Chat> cargarChatsDesdeCSV(String filePath) throws IOException {
        List<Chat> chats = new ArrayList<>();
        List<String[]> data = CSVUtil.readCSV(filePath);
        for (String[] row : data) {
            Chat chat = new Chat(row[0], row[1]);
            chats.add(chat);
        }
        return chats;
    }

    public static void guardarChatsEnCSV(String filePath, List<Chat> chats) throws IOException {
        List<String[]> data = new ArrayList<>();
        for (Chat chat : chats) {
            data.add(new String[]{chat.getVendedores(), chat.getMiChat()});
        }
        CSVUtil.writeCSV(filePath, data);
    }
}





