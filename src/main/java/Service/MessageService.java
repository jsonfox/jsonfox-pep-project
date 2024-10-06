package Service;

import java.util.List;

import DAO.MessageDAO;
import Model.Message;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService() {
        this.messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    private boolean isValidMessage(Message message) {
        return (message.getMessage_text().length() > 0 && message.getMessage_text().length() <= 255);
    }

    public List<Message> getAllMessages() {
        return this.messageDAO.getAllMessages();
    }

    public Message createMessage(Message message) {
        if (!this.isValidMessage(message)) {
            return null;
        }
        return this.messageDAO.createMessage(message);
    }

    public Message getMessageById(int id) {
        return this.messageDAO.getMessageById(id);
    }

    public Message updateMessageById(int id, Message message) {
        Message existingMessage = this.messageDAO.getMessageById(id);
        if (existingMessage == null) {
            return null;
        }
        if (!this.isValidMessage(message)) {
            return null;
        }
        this.messageDAO.updateMessageById(id, message);
        existingMessage.setMessage_text(message.getMessage_text());
        return existingMessage;
    }

    public Message deleteMessageById(int id) {
        return this.messageDAO.getMessageById(id);
    }

    public List<Message> getMessagesByAccountId(int account_id) {
        return this.messageDAO.getMessagesByAccountId(account_id);
    }
}